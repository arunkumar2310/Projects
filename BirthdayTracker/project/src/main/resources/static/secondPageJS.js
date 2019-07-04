var name2="";
document.getElementById("mobileError").style.display="none";
document.getElementById("nameError").style.display="none";
document.getElementById("password1Error").style.display="none";
document.getElementById("password2Error").style.display= "none";
function namefunction(){
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
function buttonOneClicked(){
	var name=document.getElementById("name").value;
	name2=name;
	var dateOfBirth=document.getElementById("dateOfBirth").value;
	var a=dateOfBirth.split("-");
	var month=a[1];
	var date=a[2];
	var password=document.getElementById("password").value;
	var confirmPassword=document.getElementById("confirmPassword").value;
	var mobile=document.getElementById("mobile").value;
	var colours=document.getElementById("colours").value;
	var cakes="";
	for (var i=0;i<myForm.cakes.options.length;i++) {
		if (myForm.cakes.options[i].selected) {
			cakes = cakes + myForm.cakes.options[i].value + ",";
		}
	}
	var about=document.getElementById("message").value;
	console.log(dateOfBirth);
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
	if(password!=confirmPassword){
		document.getElementById("confirmPassword").style.borderColor = "red";
		document.getElementById("password2Error").style.display= "block";
		return;
	}
	else{
		var response1;
		var userData={"name":name,"dateOfBirth":dateOfBirth,"date":date,"month":month,"mobile":mobile,"password":password,"colour":colours,"cakes":cakes,"about":about};
	    console.log(userData);
			$.ajax({
			type: 'POST',
			dataType: 'json',
			contentType:'application/json; charset=utf-8',
			url: "/save",
			data:JSON.stringify(userData),
			success: function (data) {
				console.log(data);
				window.location = "http://localhost:8080/thirdPage.html?"+data.name+"="+data.id;
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
function buttonTwoClicked(){
	window.location.href="http://localhost:8080/login";
}