<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.*"%>
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
<title>Sales History</title>
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

	OrderService orderService = new OrderService();
	ArrayList<Order> orders = orderService.getSalesHistory(userID);
	
	%>
	
	<%@include file="navbar.jsp"%>
	
	<main>
		<div class="container">
			<h1 class="mt-4">Sales History</h1>
			<%
			if (orders != null) {
				if (!(orders.isEmpty())) {
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
								<td>Date</td>
							</tr>
						</thead>
						<tbody>
							<%
							for (int i = 0; i < orders.size(); i++) {
								Order orderItem = orders.get(i);
							%>
							<tr>
								<td><%=orderItem.getTourName()%></td>
								<td><%=String.format("%.2f", orderItem.getPrice())%></td>
								<td><%=orderItem.getQuantity()%></td>
								<td><%=String.format("%.2f", orderItem.getPrice() * (double) orderItem.getQuantity()) %></td>
								<td><%=orderItem.getDate() %></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<%
			} else {
			%>
			<h1>Your Sales History is Empty</h1>
			<%
			}
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