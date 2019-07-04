// @ts-nocheck
document.getElementById("nameError").style.display="none";
document.getElementById("password1Error").style.display="none";
document.getElementById("validationError").style.display="none";
function nameFunction(){
	var x = document.getElementById("nameError");
	if(document.getElementById("name").value==""){
		document.getElementById("name").style.borderColor = "red";
		x.style.display = "block";
	}
	else{
		document.getElementById("name").style.removeProperty('border');
		x.style.display = "none";
	}
}
function password1Function(){
	var x = document.getElementById("password1Error");
	if(document.getElementById("password").value==""){
		document.getElementById("password").style.borderColor = "red";
		x.style.display = "block";
	}
	else{
		document.getElementById("password").style.removeProperty('border');
		x.style.display = "none";
	}
}
function buttonClicked(){
	var name=document.getElementById("name").value;
	var password=document.getElementById("password").value;
	var loginData={"name":name,"password":password};
	if(name==""){
		document.getElementById("name").style.borderColor = "red";
		document.getElementById("nameError").style.display= "block";
		return;
	}
	if(password==""){
		document.getElementById("password").style.borderColor = "red";
		document.getElementById("password1Error").style.display= "block";
		return;
	}
	else{
	$.ajax({
		type: 'POST',
		dataType: 'json',
		contentType:'application/json;charset=utf-8;',
		url: "retriveByNameAndPassword/"+name+"/"+password,
		success: function (user) {
			console.log(user);
            if (user != null) {
            	window.location = "http://localhost:8080/thirdPage.html?"+user.name+"="+user.id;
             }
            else{
            	document.getElementById("validationError").style.display="block";
            }
        },
		error: function(xhr, textStatus, errorThrown){
		//alert('request failed'+errorThrown);
		}
		});
	}
	
}