<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table cellspacing="10" cellpadding="10" border="3">

<%
   out.println("<h2>The Student present on specified date are:<br></h2>");
   List<String> list = (List<String>)request.getAttribute("studentlist");
   for(String student : list){
	  out.println("<tr> <td> "+student +"</td> </tr>");
   }

%>

</table>
</body>
</html>