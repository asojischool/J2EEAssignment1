<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="models.User" %>
	<%
		Boolean authorized = (Boolean)session.getAttribute("authorized");
		User user = (User)session.getAttribute("sessUser");
		System.out.println(user.getUsername());
	%>
	<h1>Hello <%= user.getUsername() %> I am <%= authorized %>ly authorized</h1>
	
	
	
</body>
</html>