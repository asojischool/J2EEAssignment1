<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="servlets.allUser"%>
	<%@page import="models.UserService"%>
	<%@page import="models.User"%>
	
	<%
		UserService userService = new UserService();
		String userStr = userService.allUser();
	%>
	
	<%@include file="navbarAdmin.jsp"%>
	
	<%
		String err = (String) request.getAttribute("err");
		if (err != null) {
	%>
		<div id="message" class="alert alert-danger" role="alert"><%= err %></div>
	<%
		}
	%>
	
	<%
		String successMsg = (String) request.getAttribute("successMsg");
		if (successMsg != null) {
	%>
		<div id="message" class="alert alert-success" role="alert"><%= successMsg %></div>
	<%
		}
	%>
	
	<div class="container">
		<%
		out.print(userStr);
		%>
	</div>
</body>
</html>