<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.banner-image {
	background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
		url(image/singapore.png);
	background-size: cover;
	background-position: center;
}

body {
	padding-top: 72px;
}
</style>
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

	<%@include file="navbar.jsp"%>

	<main>
		<div class="banner-image py-5">
			<div class="text-center container">
				<div class="row py-lg-5">
					<div class="col-lg-6 col-md-8 mx-auto">
						<h1 class="text-light fw-bolder">Singapore Tours</h1><br>
						<p class="lead text-light fw-normal">Ready to experience the real
							Singapore? Let's Go Tour Singapore is an award-winning tour
							operator offering a wide range of unique tours. We got Bike
							Tours, Food Tours, Boat Tours, Walking tours, Nature Tours,
							Theatrical Tours and more. Make the most of each travel moment
							and create some wonderful memories with us now!</p>
					</div>
				</div>
			</div>
		</div>


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