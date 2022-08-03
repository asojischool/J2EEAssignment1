<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register.jsp</title>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
	<link rel="stylesheet" href="css/login.css">
</head>
<body>


	<%
	String tempUsername = (String) request.getAttribute("tempUsername");
	String tempPassword = (String) request.getAttribute("tempPassword");
	String tempEmail = (String) request.getAttribute("tempEmail");
	if (tempUsername == null){
		tempUsername = "";
	} 
	if (tempPassword == null){
		tempPassword = "";
	} 
	if (tempEmail == null){
		tempEmail = "";
	} 
	%>
    <%@include file="navbar.jsp"%>

	<%
					// if error
					String err = (String) request.getAttribute("err");
					if (err != null) {
					%>
						<div id="message" class="alert alert-danger" role="alert"><%= err %></div>
					<%
					}
					%>
	
	<div class="container">
		<div
			class="row d-flex justify-content-center height height align-content-center">
			<div class="col-md-5">
				<div class="box shadow bg-white p-4">
					<h1 class="text-center mb-4">Register</h1>
					<form action="registerUser" method="post">
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="text" name="username"
								placeholder="username" id="floatingUsername" value="<%=tempUsername%>"> <label
								for="floatingUsername">Username</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="text" name="email"
								placeholder="email" id="floatingEmail" value="<%=tempEmail%>"> <label
								for="floatingEmail">Email</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="password" value="<%=tempPassword%>"
								name="password" placeholder="password" id="floatingPassword">
							<label for="floatingPassword">Password</label>
						</div>
						<div class="d-grid gap-2 mb-4">
							<input class="btn btn-success fs-5" type="submit"
								name="btnSubmit" value="Register">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html> 
