<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="models.User"%>
<%@page import="models.Category"%>
<%@page import="models.CategoryService"%>
<%@page import="java.util.ArrayList"%>

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

.card-img-top {
    width: 100%;
    height: 314px;
    object-fit: cover;
}

body {
	padding-top: 72px;
}
</style>
<meta charset="ISO-8859-1">
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

</head>
<body>

	<%	
	CategoryService categoryService = new CategoryService();
	ArrayList<Category> categories = categoryService.getCategories();
	%>

	<%@include file="navbar.jsp"%>
	
	<%
	String success = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errMsg");
	
	if(success != null) {
	%>
		<div class="alert alert-success alert-dismissible fade show position-absolute" role="alert">
			<%= success %>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	<%
	}
	
	if(err != null) {
	%>
		<div class="alert alert-danger alert-dismissible fade show position-absolute" role="alert">
			<%= err %>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
	<%
	}
	%>
	
	<main>
		<div class="banner-image py-5">
		
			<div class="text-center container">
				<div class="row py-lg-5">
					<div class="col-lg-6 col-md-8 mx-auto">
						<h1 class="text-light fw-bolder">Tours</h1><br>
						<p class="lead text-light fw-normal">Ready to experience the real
							World? Let's Go Tour World is an award-winning tour
							operator offering a wide range of unique tours. We got many tours that travel to many unique countries
							Make the most of each travel moment and create some wonderful memories with us now!</p>
					</div>
				</div>
			</div>
		</div>


		<div class="py-5 bg-light">
			<div class="container">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

					<%
					if(categories != null || !(categories.isEmpty())){
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
									<h3><%=categoryService.capitalizeWord(name)%>
										Tours
									</h3>
									<p class="card-text"><%=description%></p>
									<a class="btn btn-success btn-lg"
										href="tours.jsp?categoryID=<%=id%>" role="button">Let's Go</a>
								</div>
							</div>
						</div>
					<%
						}
					} else {
					%>
						<div class="text-center">
							<h1>No Categories</h1>
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