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
	<%@page import="models.User"%>

	<%
	User user = (User) session.getAttribute("sessUser");
	if (user == null) {
		response.sendRedirect("home.jsp");
	} else {
		String userRole = user.getRole();
		if (!(userRole.equals("admin"))) {
			response.sendRedirect("home.jsp");
		}
	}
	%>


	<%
	AdminService adminService = new AdminService();
	String tourStr = adminService.adminView();
	%>

	<%@include file="navbarAdmin.jsp"%>

	<div>
		<h2 style="text-align:center;" class="text-info">Tour Info</h2>
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