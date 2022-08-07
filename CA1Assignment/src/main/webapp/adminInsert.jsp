<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminInsert.jsp</title>
<style>
	table, tr, td {
  		border:0px solid black;
  		margin-right: auto;
  		margin-left: auto;
	}
	h2 {
	}
	body {
		padding-top: 72px;
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

	<%@page import="models.User" %>
	
	<%-- <%
	User user = (User) session.getAttribute("sessUser");
	if (user == null) {
		response.sendRedirect("home.jsp");
	} else {
		String userRole = user.getRole();
		if (!(userRole.equals("admin"))) {
			response.sendRedirect("home.jsp");
		}
	}
	%> --%>
	
	<%
		String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEjP5eJ4WIGuhEMAXpp2M11odo9HItPz3c3fAvPNzu_0nEXyeP";
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
		String tempName = (String) request.getAttribute("tempName");
		String tempBrief = (String) request.getAttribute("tempBrief");
		String tempFull = (String) request.getAttribute("tempFull");
		String tempStart = (String) request.getAttribute("tempStart");
		String tempEnd = (String) request.getAttribute("tempEnd");
		String tempLocation = (String) request.getAttribute("tempLocation");
		String tempPrice = (String) request.getAttribute("tempPrice");
		String tempSlots = (String) request.getAttribute("tempSlots");
		String tempBought = (String) request.getAttribute("tempBought");
		String tempCatID = (String) request.getAttribute("tempCatID");
		String tempImage = (String) request.getAttribute("tempImage");
		if (tempName == null){
			tempName = "";
		} 
		if (tempBrief == null){
			tempBrief = "";
		} 
		if (tempFull == null){
			tempFull = "";
		} 
		if (tempStart == null){
			tempStart = "";
		} 
		if (tempEnd == null){
			tempEnd = "";
		} 
		if (tempLocation == null){
			tempLocation = "";
		} 
		if (tempPrice == null){
			tempPrice = "";
		} 
		if (tempSlots == null){
			tempSlots = "";
		} 
		if (tempBought == null){
			tempBought = "";
		} 
		if (tempCatID == null){
			tempCatID = "";
		} 
		if (tempImage != null){
			image = tempImage;
		} 
	%>

	<div>
		<h2 style="text-align:center;" class="text-info">Add Tour</h2>
	</div>
	
	<div class="container">
		<table class="row d-flex justify-content-center height height align-content-center">
			<form action="adminInsert" method="post">
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Tour Name: </td>
					<td class="box shadow bg-white p-4"><input type="text" name="name" value="<%=tempName %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Brief Description</td>
					<td class="box shadow bg-white p-4"><input type="text" name="briefDescription" value="<%=tempBrief %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Full Description</td>
					<td class="box shadow bg-white p-4"><input type="text" name="fullDescription" value="<%=tempFull %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Start Date</td>
					<td class="box shadow bg-white p-4"><input type="text" name="start" value="<%=tempStart %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">End Date</td>
					<td class="box shadow bg-white p-4"><input type="text" name="end" value="<%=tempEnd %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Location</td>
					<td class="box shadow bg-white p-4"><input type="text" name="location" value="<%=tempLocation %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Price</td>
					<td class="box shadow bg-white p-4"><input type="number" name="price" value="<%=tempPrice %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Available Slots</td>
					<td class="box shadow bg-white p-4"><input type="number" name="slots" value="<%=tempSlots %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Tours Bought</td>
					<td class="box shadow bg-white p-4"><input type="text" name="bought" value="<%=tempBought %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Category ID</td>
					<td class="box shadow bg-white p-4"><input type="number" name="catID" value="<%=tempCatID %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Image URL</td>
					<td class="box shadow bg-white p-4"><input type="text" name="image" value="<%=image %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="d-grid gap-2 mb-4"><input class="btn btn-success fs-5" type="submit" value="Submit"></td>
			</form>
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