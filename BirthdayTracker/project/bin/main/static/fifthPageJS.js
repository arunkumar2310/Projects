document.getElementById("mobileError").style.display="none";
document.getElementById("password1Error").style.display="none";
document.getElementById("password2Error").style.display= "none";
var name = window.location.href;
var name1=name.split("?");
var name2=name1[1].split("=");
var userName=name2[0];
var userId=name2[1];
var dateOfBirth;
document.getElementById("userName").innerHTML="Welcome "+userName+" !!!";
$.ajax({
	type: 'POST',
	dataType: 'json',
	contentType:'application/json;charset=utf-8;',
	url: "retriveById/"+userId,
	success: function (data) {
		console.log(data);
		myfunction(data);
	},
	failure:function(response){
		alert(response);
	},
	error: function(xhr, textStatus, errorThrown){
		//alert('request failed'+errorThrown);
	}
});	
function mobilefunction(){
	var x = document.getElementById("mobileError");
	if(/^([0-9]{10})$/.test(document.getElementById("mobile").value)==false){
		document.getElementById("mobile").style.borderColor = "red";
		x.style.display = "block";
	}
	else{
		document.getElementById("mobile").style.removeProperty('border');
		x.style.display = "none";
	}
}
function password1Function(){
	var x = document.getElementById("password1Error");
	if(document.getElementById("password").value==null){
		document.getElementById("password").style.borderColor = "red";
		x.style.display = "block";
	}
	else{
		document.getElementById("password").style.removeProperty('border');
		x.style.display = "none";
	}
}
function password2Function(){
	var x = document.getElementById("password2Error");
	if(document.getElementById("password").value!=document.getElementById("confirmPassword").value){
		document.getElementById("confirmPassword").style.borderColor = "red";
		x.style.display = "block";
	}
	else{
		document.getElementById("confirmPassword").style.removeProperty('border');
		x.style.display = "none";
	}
}

function myfunction(data){
	id=data.id;
	var dob=data.dateOfBirth.split("T");
	dateOfBirth=dob[0];
	document.getElementById("name").value=data.name;
	document.getElementById("dateOfBirth").value=dateOfBirth;
	console.log(id);
	console.log(dateOfBirth);
}
console.log(userId);
console.log(dateOfBirth);
function buttonOneClicked(){
	name2=name;
	var name11=document.getElementById("name").value;
	var dateOfBirth11=document.getElementById("dateOfBirth").value;
	var a=dateOfBirth11.split("-");
	var month=a[1];
	var date=a[2];
	var password1=document.getElementById("password").value;
	var confirmPassword1=document.getElementById("confirmPassword").value;
	var mobile=document.getElementById("mobile").value;
	var colours=document.getElementById("colours").value;
	var cakes="";
	for (var i=0;i<myForm.cakes.options.length;i++) {
		if (myForm.cakes.options[i].selected) {
			cakes = cakes + myForm.cakes.options[i].value + ",";
		}
	}
	var about=document.getElementById("message").value;
	if(password1==""){
		document.getElementById("password").style.borderColor = "red";
		document.getElementById("password1Error").style.display= "block";
		return;
	}
	if(password1!=confirmPassword1){
		document.getElementById("confirmPassword").style.borderColor = "red";
		document.getElementById("password2Error").style.display= "block";
		return;
	}
	
	else{
		var response1;
		var userData={"id":userId,"name":userName,"dateOfBirth":dateOfBirth11,"date":date,"month":month,"mobile":mobile,"password":password1,"colour":colours,"cakes":cakes,"about":about};
	    $.ajax({
			type: 'POST',
			dataType: 'json',
			contentType:'application/json; charset=utf-8',
			url: "/save",
			data:JSON.stringify(userData),
			success: function (data) {
				if (data!=null) {
					alert("Profile updated successfully!!!");
					window.location.href="http://localhost:8080/fourthPage.html?"+userName+"="+userId;
				}
			},
			failure:function(response){
				alert(response);
			},
			error: function(xhr, textStatus, errorThrown){
				//alert('request failed'+errorThrown);
			}
		});
	}

}
function fourthPage(){
	window.location.href="http://localhost:8080/fourthPage.html?"+userName+"="+userId;
}
function firstPage(){
	alert("You will be logged out!!!");
	window.location.href="http://localhost:8080/login";
}
function thirdPage(){
	window.location.href="http://localhost:8080/thirdPage.html?"+userName+"="+userId;
}