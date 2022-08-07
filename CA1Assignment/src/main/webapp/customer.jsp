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
	<%@page import="models.UserService" %>
	<%@page import="models.User" %>
	
	<% 
	Integer userID = (Integer) session.getAttribute("sessID");

	if (userID == null) {
		request.setAttribute("errMsg", "Please login as Administrator");
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		return;
	}
	else {
		UserService userService = new UserService();
		User user = userService.getUserByID(userID);
		if (!user.getRole().equals("admin")) {
			request.setAttribute("errMsg", "Please login as Administrator");
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			return;
		}
	}
	%>
	
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
		<h2 style="text-align:center;" class="text-info">Customer Info</h2>
	</div>
	
	<div class="container">
		<form action="searchUser">
			 <input type="text" name="search" placeholder="Search">
			 <input type="submit" name="submit" value="Search By Name">
			<input type="submit" name="submit" value="Search By Residential Area">
		</form>
		<form action="userInquiry">
			<input class="btn btn-success fs-5" type="submit"
				value="Show Amount Spent">
		</form>
	</div>
	
	<div class="container">
		<%
		out.print(userStr);
		%>
		<form action="custInsert.jsp">
			<input class="btn btn-primary fs-5" type="submit"
				value="Create New User">
		</form>
	</div>
</body>
</html>