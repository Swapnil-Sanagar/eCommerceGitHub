<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en" ng-app="myApp">
	<head>
		<%@include file="metadata.jsp"%>
	</head>
	<body ng-controller="CartController">
		<!-- Header Section Starts -->
		<%@include file="header.jsp"%>
		<!-- Main Container Starts -->
		<div id="main-container" class="container">
		<!-- Breadcrumb Starts -->
			<ol class="breadcrumb">
				<li><a href="home.jsp">Home</a></li>
				<li class="active">Register</li>
			</ol>
		<!-- Breadcrumb Ends -->
		<!-- Main Heading Starts -->
			<h2 class="main-heading text-center">
				Login or create new account
			</h2>
		<!-- Main Heading Ends -->
		<!-- Login Form Section Starts -->
			<section class="login-area">
				<div class="row">
					<div class="col-sm-6">
					<!-- Login Panel Starts -->
						<div class="panel panel-smart">
							<div class="panel-heading">
								<h3 class="panel-title">Login</h3>
							</div>
							<div class="panel-body">
								<p>
								<span class="error" >${errorLogin}</span>
								</p>
								<p>
									Please login using your existing account
								</p>
							<!-- Login Form Starts -->
								<form class="form-inline" role="form" action="login" method="POST" modelAttribute="loginForm">
									<%-- <spring:bind path="username"> --%>
										<div class="form-group">
											<label class="sr-only" for="exampleInputEmail2">Email</label>
											<%-- <form:input path="username" type="text" class="form-control" id="exampleInputEmail2" placeholder="Username"></form:input> --%>
											<input class="form-control" type='text' name='user_name'>
											<%-- <form:errors path="username"></form:errors> --%>
										</div>
									<%-- </spring:bind>
									<spring:bind path="password"> --%>
										<div class="form-group">
											<label class="sr-only" for="exampleInputPassword2">Password</label>
											<%-- <form:input path="password" type="password" class="form-control" id="exampleInputPassword2" placeholder="Password"></form:input> --%>
											<input class="form-control" type='password' name='password' />
											<%-- <form:errors path="password"></form:errors> --%>
										</div>
										<button type="submit" class="btn btn-main">
											Login
										</button>
									<%-- </spring:bind> --%>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
							<!-- Login Form Ends -->
							</div>
						</div>
					<!-- Login Panel Ends -->
					</div>
					<div class="col-sm-6">
					<!-- Account Panel Starts -->
						<div class="panel panel-smart">
							<div class="panel-heading">
								<h3 class="panel-title">
									Create new account
								</h3>
							</div>
							<div class="panel-body">
								<p>
									Registration allows you to avoid filling in billing and shipping forms every time you checkout on this website
								</p>
								<a href="register" class="btn btn-main">
									Register
								</a>
							</div>
						</div>
					<!-- Account Panel Ends -->
					<!-- Guest Checkout Panel Starts -->
						<div class="panel panel-smart">
							<div class="panel-heading">
								<h3 class="panel-title">
									Checkout as Guest
								</h3>
							</div>
							<div class="panel-body">
								<p>
									Checkout as a guest instead!
								</p>
								<button class="btn btn-main">As Guest</button>
							</div>
						</div>
					<!-- Guest Checkout Panel Ends -->
					</div>
				</div>
			</section>
		<!-- Login Form Section Ends -->
		</div>
		<!-- Main Container Ends -->
		<!-- Footer Section Starts -->
		<%@include file="footer.jsp"%>
		<!-- Footer Section Ends -->
</body>
</html>
