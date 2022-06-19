<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	
	<style>
			/* 0px to disable */
			.debugBox {
				border: 1px solid red;
				padding: 10px;
			}
			.displayNone {
				display: none;
			}
			.textRed {
				color: red;
			}
	</style>
	
	<meta charset="ISO-8859-1">
	<title>login.jsp</title>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<link 
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
		crossorigin="anonymous"
	/>
    <link rel="stylesheet" href="css/login.css">
	
</head>
<body>
	
	<%! boolean useJS = false; %>
	
	<% if(useJS){ %>
		<script>
			$(document).ready(function(){
				const queryParams = new URLSearchParams(window.location.search);
				const errCode = queryParams.get("errCode");
				
				if(errCode && errCode == "invalidLogin"){
					$("#message").css({'display':'block'}).html("You have entered an invalid ID/Password");
				}
				else {
					$("message").css({'display':'none'});
				}
			});
			</script>
	<% } else { %>
		
	<% } %>
	
	<!-- Error Message -->
	<h1 id="message" class="textRed"></h1>
	
	<!-- Input Field -->
	<div class="container">
		<div class="row d-flex justify-content-center height height align-content-center">
			<div class="col-md-5">
				<div class="box shadow bg-white p-4">
					<h1 class="text-center mb-4">Login Form</h1>
					<form action="verifyUser" method="post">
						<div class="form-floating mb-4">
						  	<input class="form-control rounded-0" type="text" name="username" placeholder="username" id="floatingUsername">
						  	<label for="floatingUsername">Username</label>
						</div>
						<div class="form-floating mb-4">
						  	<input class="form-control rounded-0" type="password" name="password" placeholder="password" id="floatingPassword">
						  	<label for="floatingPassword">Password</label>
						</div>
						<div class="d-grid gap-2 mb-4">
						  	<input class="btn btn-success fs-4" type="submit" name="btnSubmit" value="Login">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	
	<script
      src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
      crossorigin="anonymous"
    ></script>
    <!-- <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"
    ></script> -->
    <script 
    	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
    	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" 
    	crossorigin="anonymous">
    </script>
	
</body>
</html>