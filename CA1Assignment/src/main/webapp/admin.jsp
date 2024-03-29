<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, tr, td {
	border: 0px solid black;
	margin-right: auto;
	margin-left: auto;
}
body {
	padding-top: 72px;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<meta charset="ISO-8859-1">
<title>admin.jsp</title>
</head>
<body>
	<%@page import="servlets.adminView"%>
	<%@page import="models.AdminService"%>
	<%@page import="models.UserService"%>
	<%@page import="models.User"%>

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

	<%
	AdminService adminService = new AdminService();
	String tourStr = adminService.adminView(); 
	
	%>

	<%@include file="navbarAdmin.jsp"%>

	<div class="container">
		<h2 style="text-align:center;" class="text-info">Tour Info</h2>
	</div>
	
	<div class="container">
		<form action="searchTour">
			 <input type="text" name="search" placeholder="Search">
			 <input type="submit" name="submit" value="Search By Tour Name">
			<input type="submit" name="submit" value="Search By Location">
		</form>
		<form action="tourInquiry">
			<input class="btn btn-success fs-5" type="submit"
				value="Sort By Popularity">
		</form>
	</div>

	<div class="container">
		<%
		out.print(tourStr);
		%>
		<form action="adminInsert.jsp">
			<input class="btn btn-primary fs-5" type="submit"
				value="Add New Tour">
		</form>
	</div>
</body>
</html>