<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Home.jsp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="stylesheet" href="css/login.css">

</head>
<body>
	<%@page import="models.User"%>
	<%@page import="models.Category"%>
	<%@page import="models.CategoryService"%>
	<%@page import="java.util.ArrayList"%>

	<%
	User user = (User) session.getAttribute("sessUser");
	Boolean authorized = (Boolean) session.getAttribute("authorized");

	CategoryService categoryService = new CategoryService();
	ArrayList<Category> categories = categoryService.getCategories();
	%>

	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Tours</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
					</li>
				</ul>
			</div>

			<%
			if (session.getAttribute("sessUser") != null) {
			%>
			<div class="navbar-text">
				<p>Logged-In</p>
			</div>
			<a href="logout" class="btn btn-danger me-2" type="button">Logout</a>
			<%
			}
			%>


		</div>
	</nav>

	<main>
		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-light">Singapore Tours</h1>
					<p class="lead text-muted">Ready to experience the real
						Singapore? Let's Go Tour Singapore is an award-winning tour
						operator offering a wide range of unique tours. We got Bike Tours,
						Food Tours, Boat Tours, Walking tours, Nature Tours, Theatrical
						Tours and more. Make the most of each travel moment and create
						some wonderful memories with us now!</p>
				</div>
			</div>
		</section>

		<div class="py-5 bg-light">
			<div class="container">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

					<%
					for (Category category : categories) {
						int id = category.getCategoryID();
						String image = category.getCategoryImage();
						String name = category.getCategoryName();
						String description = category.getCategoryDescription();
					%>
					<div class="col">
						<div class="card shadow-sm">
							<img class="card-img-top" alt="attraction" src=<%=image%>>
							<div class="card-body">
								<h3><%=name%>
									Tours
								</h3>
								<p class="card-text"><%=description%></p>
								<form></form>
								<a class="btn btn-success btn-lg"
									href="getTours?categoryID=<%=id%>" role="button">Let's Go</a>
							</div>
						</div>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>

	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>