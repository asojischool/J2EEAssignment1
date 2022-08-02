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
<style>
.table-style {
	border-top: 10px solid red
}

body {
	padding-top: 72px;
}

.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
<title>Cart</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />

</head>
<body>

	<%
	TourService tourService = new TourService();
	ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

	int totalCost = 0;
	%>

	<%@include file="navbar.jsp"%>

	<main>
		<div class="container">
			<h1>My Cart</h1>
			<%
			if (cart != null) {
				if (!(cart.isEmpty())) {
			%>
			<div class="container border rounded table-style">
				<div class="table-responsive">
					<table class="table align-middle">
						<thead>
							<tr>
								<td>Tours</td>
								<td>Price</td>
								<td>Quantity</td>
								<td>Subtotal</td>
								<td>Remove</td>
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
								<td>
									<div class="form-group d-flex">
										<a class="btn btn-sm btn-incre" href="updateCartQuantity?action=inc&id=<%= i %>"> + </a> 
											<input type="text" name="quantity" class="form-control w-50"  value="<%=cartItem.getQuantity()%>" disabled> 
										<a class="btn btn-sm btn-decre" href="updateCartQuantity?action=dec&id=<%= i %>"> - </a>
									</div>
								</td>
								<td><%=cartItem.getQuantity() * tour.getPrice()%></td>
								<td><a href="deleteCartItem?cartIdx=<%=i%>"
									class="btn btn-sm btn-danger">Remove</a></td>
							</tr>
							<%
							}
							%>
							<tr>
								<td colspan="5"><strong>Total: <%=totalCost%></strong></td>
								<!-- checkout -->
							<tr>
						</tbody>
					</table>
				</div>
			</div>
			<%
				} else {
					%>
					<h1>Your Cart is Empty</h1>
					<%
				}
			} else {
			%>
			<h1>Your Cart is Empty</h1>
			<%
			}
			%>
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