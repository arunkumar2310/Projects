var name = window.location.href;
var name1=name.split("?");
var name2=name1[1].split("=");
var userName=name2[0];
var userId=name2[1];
document.getElementById("name").innerHTML="Welcome "+userName+" !!!";
var event = 1;
document.getElementById("wish").style.display="none";
function showWishes(){
	if(event == 0){
		document.getElementById("myTable").style.display="none";
		event=2;
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
			url: "retriveWish/"+userId,
			success: function(data, textStatus ){
				console.log(data);
				myfunction(data);
				return data;
			},
			error: function(xhr, textStatus, errorThrown){
				alert('request failed'+errorThrown);
			}
		});
		function myfunction(data){
			var body = document.getElementsByTagName("body")[0];
			var table = document.createElement("table");
			var tableBody = document.createElement("tbody");
			for (var i = -1; i < data.length ; i++) {
				var row = document.createElement("tr");
				for (var j = 0; j < 2; j++) {
					var cell = document.createElement("td");
					var cellText;
					var button=document.createElement("input");
					button.type="button";
					button.value="SEND";
					button.setAttribute("id","button/"+i);
					//button.addEventListener("click",sendButton);
					if(j==0){
						if(i==-1){
							cellText = document.createTextNode("Wisher");
						}
						else{
							cellText = document.createTextNode(data[i].wishedBy);
						}
					}
					else{
						if(i==-1){
							cellText = document.createTextNode("Wish");
						}
						else{
							cellText = document.createTextNode(data[i].wishMessage);
						}
					}
					if(j==2){
						if(i==-1){
							cellText = document.createTextNode("Reply");
						}
						else{
							cellText = document.createElement("input");
							cellText.type="text";
							cellText.maxLength="100";
							cellText.placeholder="Leave a reply here...";
							cellText.size="80";
							cellText.setAttribute("id","input/"+i);
						}
					}
					cell.appendChild(cellText);
					if(j==2&&i!=-1){
						cell.appendChild(button);
					}
					cell.height="30px;";
					if(i==-1){
						cell.align="center";
					}
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
		}
	}
}
function nextPage(){
	window.location.href="http://localhost:8080/fourthPage.html?"+userName+"="+userId;
}
function firstPage(){
	alert("You will be logged out!!!");
	window.location.href="http://localhost:8080/login";
}
function thirdPage(){
	window.location.href="http://localhost:8080/thirdPage.html?"+userName+"="+userId;
}
function fifthPage(){
	window.location.href="http://localhost:8080/fifthPage.html?"+userName+"="+userId;
}