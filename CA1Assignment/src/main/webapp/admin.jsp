<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table, tr, td {
  		border:1px solid black;
  		margin-right: auto;
  		margin-left: auto;
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
	<%@page import="servlets.adminView" %>
	<%@page import="models.AdminService" %>
	

	<%
	AdminService adminService = new AdminService();
	String tourStr = adminService.adminView();
	%>

	<div class="container">
		<%
			out.print(tourStr);
		%>
		<form action="adminInsert.jsp">
			<input type="submit" value="Add New Tour">
		</form>
	</div>
</body>
</html>