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
	<%@include file="navbarAdmin.jsp"%>
	
	<%
		String url = request.getRequestURL().toString(); 
		request.setAttribute("url", url);
	%>
	
	<%
		String id = request.getParameter("id");
	
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String role = request.getParameter("role");
		
		String email = request.getParameter("email");
	%>
	
	<div>
		<h2 style="text-align: center;" class="text-info">Edit Customer</h2>
	</div>
	
	<div class="container">
		<table
			class="row d-flex justify-content-center height height align-content-center">
			<form action="custUpdate" method="post">
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">User ID:</td>
					<td class="box shadow bg-white p-4"><input type="number"
						value="<%=id%>" name="id" readonly></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4"> Username:</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=username%>" name="username"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Password:</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=password%>" name="password"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Role:</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=role%>" name="role"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Email</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=email%>" name="email"></td>
				</tr>
				<tr class="col-md-5">
					<td class="d-grid gap-2 mb-4"><input
						class="btn btn-success fs-5" type="submit" value="Submit"></td>
				</tr>
			</form>
			<tr class="col-md-5">
				<td class="d-grid gap-2 mb-4">
					<form action="deleteUser" method="post">
						<input type="hidden" name="id" value="<%=id%>"> <input
							class="btn btn-danger fs-5" type="submit" value="Delete"
							class="button">
					</form>
				</td>
			</tr>
			<tr class="col-md-5">
				<td class="d-grid gap-2 mb-4">
					<form action="customer.jsp">
						<input class="btn btn-primary fs-5" type="submit" value="Back">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>