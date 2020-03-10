<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- -Afficher  date en Java-- -->
<%
	DateFormat monFormat= new SimpleDateFormat("hh:mm:ss aa");
String maintenant=monFormat.format(new Date());
%>
L'heure est <%=maintenant%>
</body>
</html>