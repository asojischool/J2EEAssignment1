<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
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
	<%@page import="models.User"%>
	<%@page import="models.Tour"%>
	<%@page import="java.util.ArrayList"%>

	<%
	Tour detailedTour = (Tour) session.getAttribute("sessDetailedTour");
	int tourID = (Integer) session.getAttribute("sessTourID");
	%>

	<%@include file="navbar.jsp"%>

	<main>
		<div class="w-100 banner-image-container">
			<img class="w-100 h-100" alt="Tour"
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEjP5eJ4WIGuhEMAXpp2M11odo9HItPz3c3fAvPNzu_0nEXyeP">
		</div>

		<div class="container mt-5">
			<div>
				<h1 class="tourHeader text-warning text-center"><%=detailedTour.getTour_name()%></h1>
			</div>
			<div class="mt-3">
				<div class="">
					<div class="fs-6">
						<i class="bi bi-tags fa-3x align-middle text-danger"></i>
						<p class="align-middle d-inline fw-bold iconText">Category</p>
					</div>
					<div class="fs-6">
						<i class="bi bi-person fa-3x align-middle mr-2 text-danger"></i>
						<p class="align-middle d-inline fw-bold iconText">Slots</p>
					</div>
					<div class="fs-6">
						<i class="bi bi-currency-dollar fa-3x align-middle text-danger"></i>
						<p class="align-middle d-inline fw-bold iconText">Cost: $100</p>
					</div>
					<br>
				</div>
				<p class="fst-italic"><%=detailedTour.getBriefDescription()%></p>
				<br>
				<p class=""><%=detailedTour.getFullDescription()%></p>
			</div>
		</div>
		
		<div class="container mt-5">
			<h1 class="">Reviews</h1>
			<
		</div>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>