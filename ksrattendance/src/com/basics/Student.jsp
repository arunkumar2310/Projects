<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get"action="fir">
<table border="1">
<tr>
<td>Register number:</td>
<td><input type="number" name="regNum"></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td>Phone number:</td>
<td><input type="tel" name="phone"></td>
</tr>
<tr>
<td>Mail Id:</td>
<td><input type="text" name="mail"></td>
</tr>
<tr>
<td>Qualification:</td>
<td>UG<input type="radio" name="qual" value="UG">
PG<input type="radio" name="qual" value="PG"></td>
<td>
</tr>
<tr>
<td>Skills:</td>
<td>Java<input type="checkbox" value="Java" name="skill"></td>
<td>JSP<input type="checkbox" value="JSP" name="skill"></td>
<td>ESP 3.0<input type="checkbox" value="ESP 3.0" name="skill"></td>
</tr>
<tr>
<td>Register number:</td>
<td><input type="submit" value="show student details"></td>
</tr>
</table>
</form>
</body>
</html>