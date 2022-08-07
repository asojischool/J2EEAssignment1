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
<title>Insert title here</title>
</head>
<body>

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

	<%@include file="navbarAdmin.jsp"%>
	
	<div class="container">
		<h2 style="text-align: center;" class="text-info">Results</h2>
	</div>
	
	<%
		String str = (String) request.getAttribute("str");
	
		out.print(str);
	%>
	
	<div>
		<form action="admin.jsp">
			<input class="btn btn-primary fs-5" type="submit" value="Back To Home">
		</form>
	</div>
</body>
</html>