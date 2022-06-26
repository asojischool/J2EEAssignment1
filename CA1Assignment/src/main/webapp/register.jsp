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

	<%!boolean useJS = true;%>

	<%
	if (useJS) {
	%>
	<script>
		$(document).ready(function() {
			const queryParams = new URLSearchParams(window.location.search);
			const errCode = queryParams.get("errCode");

			if (errCode && errCode == "invalidRegister") {
				$("#message").css({
					'display' : 'block'
				}).html("Username/email is already taken.");
			} else {
				$("message").css({
					'display' : 'none'
				});
			}
		});
	</script>
	<%
	} else {
	%>

	<%
	}
	%>
    <%@include file="navbar.jsp"%>
	<h1 id="message" style="color:red;"></h1>
	
	<div class="container">
		<div
			class="row d-flex justify-content-center height height align-content-center">
			<div class="col-md-5">
				<div class="box shadow bg-white p-4">
					<h1 class="text-center mb-4">Register</h1>
					<form action="registerUser" method="post">
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="text" name="username"
								placeholder="username" id="floatingUsername"> <label
								for="floatingUsername">Username</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="text" name="email"
								placeholder="email" id="floatingEmail"> <label
								for="floatingEmail">Email</label>
						</div>
						<div class="form-floating mb-4">
							<input class="form-control rounded-0" type="password"
								name="password" placeholder="password" id="floatingPassword">
							<label for="floatingPassword">Password</label>
						</div>
						<div class="form-floating mb-4">
							<input  type="radio" name="radio1" value="Public User">Public User
						</div>
						<div class="form-floating mb-4">
							<input  type="radio" name="radio1" value="Business Owner">Business Owner
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
