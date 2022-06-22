<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Register</h1>
    <form action="registerUser" method="post">
	
		Username: <input name="username" type='text'> <br>
        Email: <input name="email" type='text'> <br>
		Password: <input name="password" type='password'> <br>
		<input type="radio" name="radio1" value="Public User">Public User
		<input type="radio" name="radio1" value="Business Owner">Business Owner<br>
		
	<input type="submit" value="Register" name="btnSubmit">
	</form>
</body>
</html> 
