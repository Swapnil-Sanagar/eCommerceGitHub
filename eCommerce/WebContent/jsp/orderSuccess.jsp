<!doctype html>
<html lang="en" ng-app="myApp">
<head>
<%@include file="metadata.jsp"%>
</head>
<body>
	<!-- Header Section Starts -->
	<%@include file="header.jsp"%>
	<div id="main-container" class="container" ng-controller="OrderSuccessController">
		<!-- Breadcrumb Starts -->
		<ol class="breadcrumb">
			<li><a href="home">Home</a>
			</li>
			<li class="Active">Success</li>
		</ol>
		<!-- Breadcrumb Ends -->
		<!-- Main Heading Starts -->
		<h2 class="main-heading text-center">Your order has been placed!</h2><br/><br/>
		<!-- Main Heading Ends -->
		<div class="body-page wrapper">
			<p>Your order has been successfully processed!</p>
			<p>
				Please direct any questions you have to the <a href="#">Store
					Owner</a>.
			</p>
			<p>Thanks for shopping with us online!</p>
			<div class="buttons">
				<div class="pull-right">
					<a href="home" class="btn button">Continue</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Section Starts -->
	<%@include file="footer.jsp"%>
	<!-- Footer Section Ends -->
</body>