<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminInsert.jsp</title>
<style>
	table, tr, td {
  		border:1px solid black;
  		margin-right: auto;
  		margin-left: auto;
	}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>
<body>
	<table>
		<form action="adminInsert" method="post">
			<tr>
				<td>Tour Name: </td>
				<td><input type="text" name="name"></td>
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
	</table>
</body>
</html>