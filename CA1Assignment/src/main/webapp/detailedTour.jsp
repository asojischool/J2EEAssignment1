<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="models.User"%>
<%@page import="models.Tour"%>
<%@page import="models.TourService"%>
<%@page import="models.Category"%>
<%@page import="models.CategoryService"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Arvo:wght@700&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Arvo:wght@700&family=Epilogue&family=Roboto&display=swap')
	;

.banner-image-container {
	height: 300px;
}

img {
	object-fit: cover;
	image-rendering: pixelated;
}

.tourHeader {
	font-family: 'Arvo', serif;
}

.iconText {
	font-family: 'Roboto', sans-serif;
}
</style>
<meta charset="ISO-8859-1">
<title>detailedTour.jsp</title>
<script src="https://kit.fontawesome.com/996f70c9aa.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>
<body>

	<%!int tourID = 0;%>

	<%
	String tempTourID = request.getParameter("tourID");
	if (tempTourID == null || tempTourID == "") {
		response.sendRedirect("home.jsp");
		return;
	}

	try {
		tourID = Integer.parseInt(tempTourID);
	} catch (NumberFormatException e) {
		response.sendRedirect("home.jsp");
		return;
	}

	TourService tourService = new TourService();

	Tour detailedTour = tourService.getDetailedTour(tourID);
	if (detailedTour == null) {
		response.sendRedirect("home.jsp");
		return;
	}

	CategoryService categoryService = new CategoryService();

	String success = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errMsg");
	if (success != null) {
	%>
	<div
		class="alert alert-success alert-dismissible fade show position-absolute"
		role="alert">
		<%=success%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%
	}
	if (err != null) {
	%>
	<div
		class="alert alert-danger alert-dismissible fade show position-absolute"
		role="alert">
		<%=err%>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%
	}
	%>

	<%@include file="navbar.jsp"%>

	<main>
		<div class="w-100 banner-image-container">
			<img class="w-100 h-100" alt="Tour"
				src="<%=detailedTour.getImage()%>">
		</div>

		<div class="container mt-5">
			<div>
				<h1 class="tourHeader text-warning text-center"><%=detailedTour.getTourName()%></h1>
			</div>
			<div class="row">
				<div class="col-8">
					<div class="mt-3">
						<div class="">
							<div class="fs-6">
								<i class="bi bi-tags fa-3x align-middle text-danger"></i>
								<p class="align-middle d-inline fw-bold iconText">
									Category:
									<%=categoryService.capitalizeWord(categoryService.getCategoryName(detailedTour.getCategoryID()))%></p>
							</div>
							<div class="fs-6">
								<i class="bi bi-person fa-3x align-middle mr-2 text-danger"></i>
								<p class="align-middle d-inline fw-bold iconText">
									Available Slots:
									<%=detailedTour.getAvailableSlots()%></p>
							</div>
							<div class="fs-6">
								<i class="bi bi-currency-dollar fa-3x align-middle text-danger"></i>
								<p class="align-middle d-inline fw-bold iconText">
									Price:
									<%=String.format("%.2f", detailedTour.getPrice())%></p>
							</div>
							<div class="fs-6">
								<i class="bi bi-geo-alt fa-3x align-middle text-danger"></i>
								<p class="align-middle d-inline fw-bold iconText">
									Location:
									<%=tourService.capitalizeWord(detailedTour.getLocation())%></p>
							</div>
							<div class="fs-6">
								<i class="bi bi-calendar-week fa-3x align-middle text-danger"></i>
								<p class="align-middle d-inline fw-bold iconText">
									Duration:
									<%=detailedTour.getDuration()%> days</p>
							</div>
							<br>
						</div>
						<p class="fst-italic"><%=detailedTour.getBriefDescription()%></p>
						<br>
						<p class=""><%=detailedTour.getFullDescription()%></p>
					</div>
				</div>
				<div class="col-4">
					<div class="mt-3">
						<h4>Book this Tour</h4>
						<form action="addToCart" method="post">
							<label>Quantity:</label> <input type="hidden" name="tourID"
								value="<%=detailedTour.getTourID()%>"> <input
								type="number" name="quantity" min=1 max=<%=detailedTour.getAvailableSlots() %> value=1><br>
							<br> <input class="btn btn-success" type="submit"
								value="Add to Cart">
						</form>
					</div>
				</div>
			</div>

		</div>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>