<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navbar</title>
<style>
body {
	padding-top: 72px;
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
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark p-md-3">
		<div class="container-fluid">
			<a class="navbar-brand" href="">Admin</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="admin.jsp">Tours</a></li>
					<li class="nav-item"><a class="nav-link" href="customer.jsp">Users</a></li>
				</ul>
				<%
				if (session.getAttribute("sessUser") != null && (Boolean) session.getAttribute("authenticated") == true) {
				%>

				<ul class="navbar-nav ms-auto">
					<li class="nav-item px-3"><a class="nav-link text-white"><strong>Logged-In</strong></a></li>
					<li class="nav-item"><a
						class="nav-link btn btn-danger text-white" href="logout"
						type="button"><strong>Logout</strong></a></li>
				</ul>
				<%
				}
				%>
			</div>

		</div>
	</nav>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>