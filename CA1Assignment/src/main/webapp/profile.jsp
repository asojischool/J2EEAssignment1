<%@page import="models.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="models.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile.jsp</title>
<style>
.displayNone {
	display: none;
}

.height {
	height: 80vh;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	type="text/javascript"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>

<body>
	

	<%@include file="navbar.jsp"%>

	<%!boolean useJS = true;%>

	<%
	UserService userService = new UserService();
	User user = null;
	
	String role = (String) session.getAttribute("sessRole");
	Integer id = (Integer) session.getAttribute("sessID");
	Boolean authenticated = (Boolean) session.getAttribute("authenticated");

	if(authenticated == null || authenticated == false) {
		response.sendRedirect("home.jsp");
		return;
	} else {
		user = userService.getUserByID(id);
	}
	%>

	<!-- Input Field -->
	<div class="container">
		<div
			class="row d-flex justify-content-center height height align-content-center">
			<div class="col-md-5">
				<div class="box shadow bg-white p-4">
					<h1 class="text-center mb-4">Profile</h1>
					<%
					// if error
					String err = (String) request.getAttribute("err");
					String success = (String) request.getAttribute("success");
					if (err != null) {
					%>
						<div id="message" class="alert alert-danger" role="alert"><%= err %></div>
					<%
					}
					if (success != null) {
					%>
						<div id="message" class="alert alert-success" role="alert"><%= success %></div>
					<%
					}
					%>
					<form action="updateProfile" method="post">
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="text" name="username"
								placeholder="username" id="floatingUsername"
								value="<%=user.getUsername()%>"><label
								for="floatingUsername">Username</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="password"
								name="password" placeholder="password" id="floatingPassword"
								value="<%=user.getPassword()%>"> <label
								for="floatingPassword">Password</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="email" name="email"
								placeholder="password" id="floatingEmail"
								value="<%=user.getEmail()%>"> <label
								for="floatingPassword">Email</label>
						</div>
						<div class="d-grid gap-2 mb-4">
							<input class="btn btn-success fs-5" type="submit"
								name="btnSubmit" value="Update">
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>