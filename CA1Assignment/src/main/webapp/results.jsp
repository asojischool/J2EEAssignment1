<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<title>Insert title here</title>
</head>
<body>

	<%@include file="navbarAdmin.jsp"%>
	
	<div class="container">
		<h2 style="text-align: center;" class="text-info">Results</h2>
	</div>
	
	<%
		String str = (String) request.getAttribute("str");
	
		out.print(str);
	%>
</body>
</html>