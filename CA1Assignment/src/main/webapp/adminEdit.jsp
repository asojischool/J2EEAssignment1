<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table, th, td {
  		border:1px solid black;
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
	<%String id = request.getParameter("id"); %>
	<%String name = request.getParameter("name"); %>

	
	<table>
		<form action="adminUpdate" method="post">
			<tr>
				<td>Tour ID: </td>
				<td><input type="number" value="<%= id %>" name="id" readonly></td>
			</tr>
			<tr>
				<td>Tour Name: </td>
				<td><input type="text" value="<%= name %>" name="name"></td>
			</tr>
			<tr>
				<td>Brief Description</td>
				<td><input type="text" name="briefDescription"></td>
			</tr>
			<tr>
				<td>Full Description</td>
				<td><input type="text" name="fullDescription"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<td>Available Slots</td>
				<td><input type="number" name="slots"></td>
			</tr>
			<tr>
				<td>Category ID</td>
				<td><input type="number" name="catID"></td>
			</tr>
			<tr>
				<td>Image URL</td>
				<td><input type="text" name="image"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
				
			</tr>
			</form>
			<tr>
				<td>
					<form action="adminDelete" method="post">
						<input type="hidden" name="id" value="<%= id%>">
						<input type="submit" value="Delete" class="button">
					</form>
				</td>
		
	</table>
	<form action="admin.jsp">
		<input type="submit" value="Back">
	</form>
</body>
</html>