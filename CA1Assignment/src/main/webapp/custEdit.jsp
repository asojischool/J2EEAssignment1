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
	
	<%@page import="models.UserService" %>
	<%@page import="models.User" %>
	
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
		String url = request.getRequestURL().toString(); 
		request.setAttribute("url", url);
	%>
	
	<%
		String id = request.getParameter("id");
	
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		String role = request.getParameter("role");
		
		String email = request.getParameter("email");
		
		String area = request.getParameter("area");
	%>
	
	
	<div>
		<h2 style="text-align: center;" class="text-info">Edit Customer</h2>
	</div>
	<div class="container">
		<table
			class="row d-flex justify-content-center height height align-content-center">
			<form action="updateUser" method="post">
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
					<td class="box shadow bg-white p-4">
						<select id="role" name="role">
						 <%
						 	if(role.equals("admin")) {
						 %>
						 <option value="admin" selected>Admin</option>
						 <option value="member">Member</option>
						 <%
							}
						 %>
						 <%
							if(role.equals("member")) {
						%>
						 <option value="member" selected>Member</option>
						 <option value="admin">Admin</option>
						 <%
							}
						 %>
  						</select>
					</td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Email</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=email%>" name="email"></td>
				</tr>
				<tr class="col-md-5">
					<td class="box shadow bg-white p-4">Residential Area</td>
					<td class="box shadow bg-white p-4"><input type="text"
						value="<%=area%>" name="area"></td>
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