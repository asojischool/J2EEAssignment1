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

.btn-incre, .btn-decre {
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>

	<%
	Integer userID = (Integer) session.getAttribute("sessID");

	if (userID == null) {
		request.setAttribute("err", "Please login to use the cart");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		return;
	}

	TourService tourService = new TourService();
	ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

	// defaults
	double totalCost = 0;
	double rates = 1;
	String currency = "SGD";
	
	if(session.getAttribute("rates") != null) {
		try {
			rates = (Double) (session.getAttribute("rates"));
		} catch (Exception e) {
		}
	}
	
	if(session.getAttribute("currency") != null) {
		try {
			currency = (String) (session.getAttribute("currency"));
		} catch (Exception e) {
		}
	}
	%>

	<%@include file="navbar.jsp"%>

	<main>
		<div class="container">
			<h1 class="mt-4">My Cart</h1>
			<%
			if (cart != null) {
				if (!(cart.isEmpty())) {
			%>
			<div class="container border rounded table-style">
				<div class="table-responsive">
					<table class="table align-middle">
						<thead>
							<tr>
								<td class="text-muted">Tours</td>
								<td>Price</td>
								<td>Quantity</td>
								<td>Sub-total</td>
								<td>Remove</td>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < cart.size(); i++) {
								CartItem cartItem = cart.get(i);
								Tour tour = tourService.getDetailedTour(cartItem.getTourID());

								// check if tour is available
								if (tour == null) {
									cart.remove(i);
									// check if empty after removing, to refresh 
									if (cart.size() == 0) {
								response.sendRedirect("cart.jsp");
									}
									continue;
								}

								totalCost += cartItem.getQuantity() * tour.getPrice();
							%>
							<tr>
								<td><%=tour.getTourName()%></td>
								<td><%=currency + String.format("%.2f", tour.getPrice()* rates)%></td>
								<td>
									<div class="form-group d-flex">
										<a class="btn btn-primary btn-incre"
											href="updateCartQuantity?action=inc&id=<%=i%>"> <i
											class="bi bi-plus"></i>
										</a> <input type="text" name="quantity"
											class="form-control w-50 mx-4"
											value="<%=cartItem.getQuantity()%>" disabled> <a
											class="btn btn-primary btn-decre"
											href="updateCartQuantity?action=dec&id=<%=i%>"> <i
											class="bi bi-dash"></i>
										</a>
									</div>
								</td>
								<td><%=currency + String.format("%.2f", ((double) cartItem.getQuantity() * tour.getPrice() * rates))%></td>
								<td><a href="deleteCartItem?cartIdx=<%=i%>"
									class="btn btn-sm btn-danger">Remove</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
					<div class="m-4">
						Currency: <form action="currencyConversion" name="form1" method="post">
							<select name="selectCurrency">
								<option value="SGD">SGD</option>
								<option value="USD">USD</option>
								<option value="EUR">EUR</option>
								<option value="GBP">GBP</option>
								<option value="JPY">JPY</option>
								<option value="CAD">CAD</option>
								<option value="CAD">AUD</option>
								<option value="CAD">CHF</option>
								<option value="BTC">BTC</option>
							</select>
							<input type="hidden" name="totalValue" value="<%= totalCost %>">
							<input type="submit" name="submit" value="Change">
						</form><br>
							
						<h5>
							<strong>Total Cost (without GST): <%=currency + String.format("%.2f", totalCost * rates)%></strong>
						</h5>
						<br>
						<h3>
							<strong>Total Cost (with GST): <%=currency + String.format("%.2f", (totalCost * 1.07 * rates))%></strong>
						</h3>
					</div>
					<div class="text-center m-4">
						<a href="checkOut.jsp" class="btn btn-sm btn-success fs-5 w-100">Check
							Out</a>
					</div>
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