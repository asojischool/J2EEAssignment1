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
</style>
<meta charset="ISO-8859-1">
<title>adminEdit.jsp</title>
</head>
<body>
	<%String id = request.getParameter("id"); %>
	<%String name = request.getParameter("name"); %>
	
	<table>
		<tr>
			<td>Tour ID: </td>
			<td><input type="text" value="<%= id %>" readonly></td>
		</tr>
		<tr>
			<td>Tour Name: </td>
			<td>
	</table>
	
	
	
</body>
</html>