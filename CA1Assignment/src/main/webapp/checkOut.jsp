<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.CartItem"%>
<%@page import="models.Tour"%>
<%@page import="models.TourService"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkOut</title>
<style>
.displayNone {
	display: none;
}

.height {
	height: 80vh;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>
</head>
<body>
	
	<%
	TourService tourService = new TourService();
	ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
	
	int totalCost = 0;
	%>
	
	<main>
		<div class="container">
			<h1 class="mt-5">CHECKOUT</h1>
			<div class="container mt-4 border rounded">
				<h4>DELIVERY DETAILS</h4>
				<table class="table align-middle">
					<thead>
						<tr>
							<td>Tours</td>
							<td>Price</td>
							<td>Quantity</td>
							<td>Subtotal</td>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < cart.size(); i++) {
							CartItem cartItem = cart.get(i);
							Tour tour = tourService.getDetailedTour(cartItem.getTourID());
							totalCost += cartItem.getQuantity() * tour.getPrice();
						%>
						<tr>
							<td><%=tour.getTour_name()%></td>
							<td><%=tour.getPrice()%></td>
							<td><%=cartItem.getQuantity()%></td>
							<td><%=cartItem.getQuantity() * tour.getPrice()%></td>
						</tr>
						<%
						}
						%>
						<tr>
							<td colspan="4"><strong>Total Cost: $</strong><%= totalCost %></td>
						</tr>
					</tbody>
				</table>
				<h4>CREDIT CARD PAYMENT DETAILS</h4>
				
			</div>
		</div>
		hello world
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