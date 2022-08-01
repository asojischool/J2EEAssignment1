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
<meta charset="ISO-8859-1">
<title>tours.jsp</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>
<body>
	<%
	
	String tempCategoryID = request.getParameter("categoryID");
	if (tempCategoryID == null){
		response.sendRedirect("home.jsp");
		return;
	}
	
	int categoryID = Integer.parseInt(tempCategoryID);
	
	TourService tourService = new TourService();
	CategoryService categoryService = new CategoryService();
	
	ArrayList<Tour> tours = tourService.getToursByCategory(categoryID);
	Category category = categoryService.getDetailedCategory(categoryID);
	
	if(tours.isEmpty() || tours == null) {
	%>
		<h1>No Tours</h1>
	<%
	} else {
	%>

	<main>
	<%@include file="navbar.jsp"%>

		<section class="py-5 text-center container">
			<div class="row py-lg-5">
				<div class="col-lg-6 col-md-8 mx-auto">
					<h1 class="fw-bold"><%=category.getCategoryName()%>
						Tours
					</h1><br>
					<p class="lead text-muted fw-normal"><%=category.getCategoryDescription()%></p>
				</div>
			</div>
		</section>

	<%
		for (Tour tour : tours) {
			String name = tour.getTour_name();
			int id = tour.getTour_id();
			int price = tour.getPrice();
			int slots = tour.getAvailableSlots();
			/* int categoryID = tour.getCategoryID(); */
			String briefDescription = tour.getBriefDescription();
			String image = tour.getImage();
	%>
		<div class="container">
			<div class="row mt-3 mb-3">
				<div class="col-6">
					<img class="card-img-top" alt="attraction"
						src="<%=image%>">
				</div>
				<div class="col-6">
					<h3><%=name%></h3><br>
					<p>Price: <%=price%></p>
					<p>Slots: <%=slots%></p>
					<p>Know of any relatives or people who are Hainanese? Learn
						more about how the early Hainanese came into Singapore and the
						lives that they’ve led. Not forgetting the important Hainanese
						contribution to the food culture in Singapore! Cook your own
						scrumptious Hainanese dishes under the guidance of our chef!</p>
					<a class="btn btn-success btn-lg"
						href="detailedTour.jsp?tourID=<%=id%>" role="button">Read More</a>
				</div>

			</div>
		</div>
	<%
		}
	}
	%>
	</main>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>