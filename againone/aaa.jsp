<!DOCTYPE HTML>
<html lang='en'>
<head>
<meta charset='utf-8'>
<title> First Application (Using JSP)</title>
</head>
<body>
<%
String name=request.getParameter("name");
String city=request.getParameter("city");
System.out.println("Data Arrived");
System.out.println("Name: "+name);
System.out.println("City: "+city);
%>
<h1>Data Saved</h1> <br>

<%=name%>
<%
out.println("Name: "+name);
out.println("City: "+city);
%>

</body>
</html>
