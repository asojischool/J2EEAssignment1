<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td {
  		border:0px solid black;
  		margin-right: auto;
  		margin-left: auto;
	}
	h1 {
	text-align: center;
	}
	.button {
	color: red;
	font-weight: bold;
	
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<meta charset="ISO-8859-1">
<title>adminEdit.jsp</title>
</head>
<body>

	<%@page import="models.User" %>
	
	<%
		User user = (User)session.getAttribute("sessUser");
		if(user == null) {
			response.sendRedirect("home.jsp");
		}else {
			String userRole = user.getRole();
			if(userRole != "admin") {
				response.sendRedirect("home.jsp");
			}
		}
	%>

	<%String id = request.getParameter("id"); %>
	<%String name = request.getParameter("name"); %>
	
	<div>
		<h2 style="text-align:center;" class="text-info">Edit Tour</h2>
	</div>

	<div class="container">
		<table class="row d-flex justify-content-center height height align-content-center">
			<form action="adminUpdate" method="post">
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Tour ID: </td>
					<td class="box shadow bg-white p-4"><input type="number" value="<%= id %>" name="id" readonly></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Tour Name: </td>
					<td class="box shadow bg-white p-4"><input type="text" value="<%= name %>" name="name"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Brief Description</td>
					<td class="box shadow bg-white p-4"><input type="text" name="briefDescription"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Full Description</td>
					<td class="box shadow bg-white p-4"><input type="text" name="fullDescription"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Price</td>
					<td class="box shadow bg-white p-4"><input type="number" name="price"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Available Slots</td>
					<td class="box shadow bg-white p-4"><input type="number" name="slots"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Category ID</td>
					<td class="box shadow bg-white p-4"><input type="number" name="catID"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Image URL</td>
					<td class="box shadow bg-white p-4"><input type="text" name="image"></td>
				</tr>
				<tr class="col-md-5">
					<td class="d-grid gap-2 mb-4"><input class="btn btn-success fs-5" type="submit" value="Submit"></td>
				</tr>
			</form>
				<tr class="col-md-5">
					<td class="d-grid gap-2 mb-4">
						<form action="adminDelete" method="post">
							<input type="hidden" name="id" value="<%= id%>">
							<input class="btn btn-danger fs-5" type="submit" value="Delete" class="button">
						</form>
					</td>	
				</tr>
				<tr class="col-md-5">
					<td class="d-grid gap-2 mb-4">
						<form action="admin.jsp">
							<input class="btn btn-primary fs-5" type="submit" value="Back">
						</form>
					</td>
				</tr>
		</table>
	</div>
</body>
</html>