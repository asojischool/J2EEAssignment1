<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String tempUsername = (String) request.getAttribute("tempUsername");
		String tempPassword = (String) request.getAttribute("tempPassword");
		String tempEmail = (String) request.getAttribute("tempEmail");
		String tempArea = (String) request.getAttribute("tempArea");
		if (tempUsername == null){
			tempUsername = "";
		} 
		if (tempPassword == null){
			tempPassword = "";
		} 
		if (tempEmail == null){
			tempEmail = "";
		} 
		if (tempArea == null){
			tempArea = "";
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
	
	<div>
		<h2 style="text-align:center;" class="text-info">Create User</h2>
	</div>
	
	<div class="container">
		<table class="row d-flex justify-content-center height height align-content-center">
			<form action="registerUser" method="post">
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Username: </td>
					<td class="box shadow bg-white p-4"><input type="text" name="username" value="<%=tempUsername %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Password</td>
					<td class="box shadow bg-white p-4"><input type="text" name="password" value="<%=tempPassword %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Email</td>
					<td class="box shadow bg-white p-4"><input type="text" name="email" value="<%=tempEmail %>"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Residential Area</td>
					<td class="box shadow bg-white p-4"><input type="number" name="area" value="<%=tempArea %>"></td>
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