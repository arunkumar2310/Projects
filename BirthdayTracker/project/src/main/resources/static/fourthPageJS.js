var name = window.location.href;
var name1=name.split("?");
var name2=name1[1].split("=");
var userName=name2[0];
var userId=name2[1];
document.getElementById("name").innerHTML="Welcome "+userName+" !!!";
var event = 1;
function generate_table() {
	if(event == 0){
		document.getElementById("myTable").style.display="none";
		event = 2;
	}
	else if(event == 2 ){
		document.getElementById("myTable").style.display="table";
		event = 0;
	}
	else if(event == 1){
		event = 0;
		$.ajax({
			type: 'GET',
			dataType: 'json',
			contentType:'application/json',
			url: "dateOfBirth",
			success: function(data, textStatus ){
				myfunction(data);
			},
			error: function(xhr, textStatus, errorThrown){
				alert('request failed'+errorThrown);
			}
		});
		function myfunction(data){
			var body = document.getElementsByTagName("body")[0];
			var table = document.createElement("table");
			var tableBody = document.createElement("tbody");
			var today=new Date();
			console.log(today);
			var month=today.getMonth()+1;
			var date=today.getDate();
			for (var i = -1; i < data.length ; i++) {
				if(i!=-1){
					console.log(i+" "+data[i].month+" "+month);
					if(data[i].name==userName){
						continue;
					}
					if(data[i].month < month){
						continue;
					}
					if(data[i].month == month && data[i].date < date){
						continue;
					}
				}
				var row = document.createElement("tr");
				for (var j = 0; j < 3; j++) {
					console.log(i);
					var cell = document.createElement("td");
					var cellText;
					var button=document.createElement("input");
					button.type="button";
					button.value="SEND";
					button.setAttribute("id","button/"+i);
					button.addEventListener("click",sendButton);
					if(j==0){
						if(i==-1){
							cellText = document.createTextNode("Name");
						}
						else{
							cellText = document.createTextNode(data[i].name);
						}
					}
					else if(j==1){
						if(i==-1){
							cellText = document.createTextNode("D.O.B");
						}
						else{
							cellText = document.createTextNode(data[i].dateOfBirth.split("T")[0]);
						}
					}
					else if(j==2){
						if(i==-1){
							cellText =document.createTextNode("Wish here!!!");
						}
						else{
							cellText = document.createElement("input");
							cellText.type="text";
							cellText.maxLength="100";
							cellText.placeholder="Write a wish here...";
							cellText.size="60";
							cellText.setAttribute("id","input/"+i);
						}
					}
					cell.appendChild(cellText);
					if(i==-1){
						cell.align="center";
					}
					if(j==2&&i!=-1){
						cell.appendChild(button);
					}
					cell.height="30px;";
					row.appendChild(cell);

				}
				tableBody.appendChild(row);
			}
			table.appendChild(tableBody);
			body.appendChild(table);
			table.setAttribute("id","myTable");
			table.setAttribute("border", "1");
			table.setAttribute("align","center");
			table.style.background="skyblue";

			function sendButton(){
				let buttonId=this.id.split("/");
				let inputId="input/"+buttonId[1];
				let wishInputMessage=document.getElementById(inputId).value;
				let wishInputName=data[buttonId[1]].name.trim();
				let wishedToUserId=data[buttonId[1]].id;
				console.log(wishInputName);
				let wish={"wishedTo":wishInputName,"wishMessage":wishInputMessage,"wishedBy":userName,"wishedToUserId":wishedToUserId};
				console.log(wish);
				$.ajax({
					type: 'POST',
					dataType: 'json',
					contentType:'application/json;charset=utf-8',
					url: "/updateWish",
					data:JSON.stringify(wish),
					success: function(response){
						console.log(response);
						alert(response);
					},
					error: function(xhr, textStatus, errorThrown){

						alert("Saved your wish successfully!!!");
					}
				});
			}
		}
	}
}

function reloadPage(){
	window.location.href="http://localhost:8080/fourthPage.html?"+userName+"="+userId;
}
function firstPage(){
	alert("You will be logged out!!!");
	window.location.href="http://localhost:8080/login";
}
function fifthPage(){
	window.location.href="http://localhost:8080/fifthPage.html?"+userName+"="+userId;
}
function thirdPage(){
	window.location.href="http://localhost:8080/thirdPage.html?"+userName+"="+userId;
}