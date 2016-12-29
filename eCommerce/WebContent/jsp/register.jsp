<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
				Register <br />
				<span>Create New Account</span>
			</h2>
		<!-- Main Heading Ends -->
		<!-- Registration Section Starts -->
			<section class="registration-area">
				<div class="row">
					<div class="col-sm-6">
					<!-- Registration Block Starts -->
						<div class="panel panel-smart">
							<span>${failureMessage}</span>
							<div class="panel-heading">
								<h3 class="panel-title">Personal Information</h3>
							</div>
							<div class="panel-body">
							<!-- Registration Form Starts -->
								<form:form class="form-horizontal" role="form" action="registerUser.htm" method="POST" modelAttribute="userForm">
								<!-- Personal Information Starts -->
									<spring:bind path="firstName">
										<div class="form-group">
											<label for="inputFname" class="col-sm-3 control-label">First Name :</label>
											<div class="col-sm-9">
												<form:input path="firstName" type="text" class="form-control" id="inputFname" placeholder="First Name"></form:input>
												<form:errors  cssClass="error" path="firstName"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="lastName">
										<div class="form-group">
											<label for="inputLname" class="col-sm-3 control-label">Last Name :</label>
											<div class="col-sm-9">
												<form:input path="lastName" type="text" class="form-control" id="inputLname" placeholder="Last Name"></form:input>
												<form:errors cssClass="error" path="lastName"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="email">
										<div class="form-group">
											<label for="inputEmail" class="col-sm-3 control-label">Email :</label>
											<div class="col-sm-9">
												<form:input path="email" type="email" class="form-control" id="inputEmail" placeholder="Email"></form:input>
												<form:errors cssClass="error" path="email"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="phone">
										<div class="form-group">
											<label for="inputPhone" class="col-sm-3 control-label">Phone :</label>
											<div class="col-sm-9">
												<form:input path="phone" type="text" class="form-control" id="inputPhone" placeholder="Phone"></form:input>
												<form:errors cssClass="error" path="phone"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="fax">
										<div class="form-group">
											<label for="inputFax" class="col-sm-3 control-label">Fax :</label>
											<div class="col-sm-9">
												<form:input path="fax" type="text" class="form-control" id="inputFax" placeholder="Fax"></form:input>
											</div>
										</div>
									</spring:bind>
								<!-- Personal Information Ends -->
									<h3 class="panel-heading inner">
										Delivery Information
									</h3>
								<!-- Delivery Information Starts -->
									<spring:bind path="addressForm.company">
										<div class="form-group">
											<label for="inputCompany" class="col-sm-3 control-label">Company :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.company" type="text" class="form-control" id="inputCompany" placeholder="Company"></form:input>
												<form:errors path="addressForm.company" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.companyId">
										<div class="form-group">
											<label for="inputCompanyId" class="col-sm-3 control-label">Company ID :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.companyId" type="text" class="form-control" id="inputCompanyId" placeholder="Company ID"></form:input>
												<form:errors path="addressForm.companyId" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.address1">
										<div class="form-group">
											<label for="inputAddress1" class="col-sm-3 control-label">Address/1 :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.address1" type="text" class="form-control" id="inputAddress1" placeholder="Address/1"></form:input>
												<form:errors path="addressForm.address1" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.address2">
										<div class="form-group">
											<label for="inputAddress2" class="col-sm-3 control-label">Address/2 :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.address2"  type="text" class="form-control" id="inputAddress2" placeholder="Address/2"></form:input>
												<form:errors path="addressForm.address2"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.city">
										<div class="form-group">
											<label for="inputCity" class="col-sm-3 control-label">City :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.city" type="text" class="form-control" id="inputCity" placeholder="City"></form:input>
												<form:errors path="addressForm.city" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.zip">
										<div class="form-group">
											<label for="inputPostCode" class="col-sm-3 control-label">Postal Code :</label>
											<div class="col-sm-9">
												<form:input path="addressForm.zip" type="text" class="form-control" id="inputPostCode" placeholder="Postal Code"></form:input>
												<form:errors path="addressForm.zip" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.country">
										<div class="form-group">
											<label for="inputCountry" class="col-sm-3 control-label">Country :</label>
											<div class="col-sm-9">
												<form:select path="addressForm.country" class="form-control" id="inputCountry">
													<option value="">- All Countries -</option>
													<option>India</option>
													<option>USA</option>
													<option>UK</option>
													<option>China</option>
												</form:select>
												<form:errors path="addressForm.country" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="addressForm.region">
										<div class="form-group">
											<label for="inputRegion" class="col-sm-3 control-label">Region :</label>
											<div class="col-sm-9">
												<form:select path="addressForm.region" class="form-control" id="inputRegion">
													<option value="">- All Regions -</option>
												</form:select>
												<form:errors path="addressForm.region" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
								<!-- Delivery Information Ends -->
									<h3 class="panel-heading inner">
										Password
									</h3>
								<!-- Password Area Starts -->
									<spring:bind path="password">
										<div class="form-group">
											<label for="inputPassword" class="col-sm-3 control-label">Password :</label>
											<div class="col-sm-9">
												<form:input path="password" type="password" class="form-control" id="inputPassword" placeholder="Password"></form:input> 
												<form:errors path="password" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<spring:bind path="passwordConfirm">
										<div class="form-group">
											<label for="inputRePassword" class="col-sm-3 control-label">Re-Password :</label>
											<div class="col-sm-9">
												<form:input path="passwordConfirm" type="password" class="form-control" id="inputRePassword" placeholder="Re-Password"></form:input>
												<form:errors path="passwordConfirm" cssClass="error"></form:errors>
											</div>
										</div>
									</spring:bind>
									<div class="form-group">
										<span class="col-sm-3 control-label">Newsletter :</span>
										<div class="col-sm-9">
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
													Subscribe
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="optionsRadios" id="optionsRadios2" value="option1">
													Unsubscribe
												</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-3 col-sm-9">
											<div class="checkbox">
												<label>
													<form:checkbox  path="terms" value="checked"></form:checkbox>
													I'v read and agreed on Conditions
												</label>
												<br/>
												<form:errors path="terms" cssClass="error"></form:errors>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-3 col-sm-9">
											<button type="submit" class="btn btn-main">
												Register
											</button>
										</div>
									</div>
								<!-- Password Area Ends -->
									<form:hidden path="cartItems" value="{{ngCart.getCart().items}}" readonly="readonly" disabled="disabled"></form:hidden>
								</form:form>
							<!-- Registration Form Starts -->
							</div>							
						</div>
					<!-- Registration Block Ends -->
					</div>
					<div class="col-sm-6">
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
					<!-- Conditions Panel Starts -->
						<div class="panel panel-smart">
							<div class="panel-heading">
								<h3 class="panel-title">
									Conditions
								</h3>
							</div>
							<div class="panel-body">
								<p>
									Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including  versions of Lorem Ipsum.
								</p>
								<ol>
								  <li>Lorem ipsum dolor sit amet</li>
								  <li>Consectetur adipiscing elit</li>
								  <li>Integer molestie lorem at massa</li>
								  <li>Facilisis in pretium nisl aliquet</li>
								  <li>Nulla volutpat aliquam velit</li>
								  <li>Faucibus porta lacus fringilla vel</li>
								  <li>Aenean sit amet erat nunc</li>
								  <li>Eget porttitor lorem</li>
								</ol>
								<p>
									HTML Nullam varius, turpis et commodo pharetra, est eros bibendum elit, nec luctus magna felis sollicitudin mauris. 
								</p>
								<p>
									Integer in mauris eu nibh euismod gravida. Duis ac tellus et risus vulputate vehicula. Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper, ligula eu tempor congue, eros est euismod turpis, id tincidunt sapien risus a quam. Maecenas fermentum consequat mi. Donec fermentum. Pellentesque malesuada nulla a mi. Duis sapien sem, aliquet nec, commodo eget, consequat quis, neque. 
								</p>
								<p>
									Aliquam faucibus, elit ut dictum aliquet, felis nisl adipiscing sapien, sed malesuada diam lacus eget erat. Cras mollis scelerisque nunc. Nullam arcu. Aliquam consequat. Curabitur augue lorem, dapibus quis, laoreet et, pretium ac, nisi. 
								</p>
								<p>
									Aenean magna nisl, mollis quis, molestie eu, feugiat in, orci. In hac habitasse platea dictumst. 
								</p>
							</div>
						</div>
					<!-- Conditions Panel Ends -->
					</div>
				</div>
			</section>
		<!-- Registration Section Ends -->
		</div>
		<!-- Main Container Ends -->
		<!-- Footer Section Starts -->
		<%@include file="footer.jsp"%>
		<!-- Footer Section Ends -->
</body>