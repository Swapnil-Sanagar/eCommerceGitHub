<!doctype html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" ng-app="myApp">
	<head>
		<%@include file="metadata.jsp"%>
	</head>
	<body ng-controller="CartController">
		<!-- Header Section Starts -->
		<%@include file="header.jsp"%>

		<div id="main-container" class="container">
			<!-- Breadcrumb Starts -->
			<ol class="breadcrumb">
				<li>
					<a href="home.jsp">Home</a>
				</li>
				<li class="active">
					Shopping Cart
				</li>
			</ol>
			<!-- Breadcrumb Ends -->
			<!-- Main Heading Starts -->
			<h2 class="main-heading text-center">
				Shopping Cart
			</h2>
			<!-- Main Heading Ends -->
			<!-- Shopping Cart Table Starts -->
			<div class="table-responsive shopping-cart-table">
				<table class="table table-bordered">
					<thead>
						<tr>
							<td class="text-center">
								Image
							</td>
							<td class="text-center">
								Product Details
							</td>
							<td class="text-center">
								Quantity
							</td>
							<td class="text-center">
								Price
							</td>
							<td class="text-center">
								Total
							</td>
							<td class="text-center">
								Action
							</td>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in ngCart.getCart().items">
							<td class="text-center">
								<a href="product.jsp"> <img
										src="<%= request.getContextPath()%>/images/cart-thumb-img1.png"
										alt="Product Name" title="Product Name" class="img-thumbnail" />
								</a>
							</td>
							<td class="text-center">
								<a href="#"><span ng-bind="item._name"></span></a>
							</td>
							<td class="text-center">
							<i class="fa fa-minus-circle" aria-hidden="true" ng-class="{'disabled':item.getQuantity()==1}" ng-click="item.setQuantity(-1, true)"></i>&nbsp;&nbsp;
			                <span ng-bind="item._quantity"></span>&nbsp;&nbsp;
			                <i class="fa fa-plus-circle" aria-hidden="true" ng-click="item.setQuantity(1, true)"></i>
			                </td>
							<td class="text-center">
								<span ng-bind="item._price"></span>
							</td>
							<td class="text-center">
								<span ng-bind="item._price*item._quantity"></span>
							</td>
							<td class="text-center">
								<button type="button" title="Remove"
									class="btn btn-default tool-tip" ng-click="ngCart.removeItemById( item._id )" style="cursor: pointer;">
									<i class="fa fa-trash" aria-hidden="true"></i>
								</button>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="4" class="text-right">
								<strong>Total :</strong>
							</td>
							<td colspan="2" class="text-left">
								{{ngCart.getSubTotal()}}
							</td>
						</tr>
					</tfoot>
				</table>
			</div>
			<!-- Shopping Cart Table Ends -->
			<!-- Shipping Section Starts -->
			<section class="registration-area">
			<div class="row">
				<!-- Shipping & Shipment Block Starts -->
				<div class="col-sm-6">
					<!-- Taxes Block Starts -->
					<div class="panel panel-smart">
						<div class="panel-heading">
							<h3 class="panel-title">
								Shipping &amp; Taxes
							</h3>
						</div>
						<div class="panel-body">
							<c:choose>
								<c:when test="${addressFailureMessage != null}">${addressFailureMessage}</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<!-- Form Starts -->
							<form:form action="getAddressInfo.htm" class="form-horizontal" role="form" modelAttribute="addressForm">
								<spring:bind path="country">
									<div class="form-group">
										<label for="inputCountry" class="col-sm-3 control-label">Country :</label>
										<div class="col-sm-9">
											<form:select path="country" class="form-control" id="inputCountry">
												<option value="">- All Countries -</option>
												<option>India</option>
												<option>USA</option>
												<option>UK</option>
												<option>China</option>
											</form:select>
										</div>
									</div>
								</spring:bind>
								<spring:bind path="region">
									<div class="form-group">
										<label for="inputRegion" class="col-sm-3 control-label">Region :</label>
										<div class="col-sm-9">
											<form:select path="region" class="form-control" id="inputRegion">
												<option value="">- All Regions -</option>
												<option>North India</option>
												<option>South India</option>
											</form:select>
										</div>
									</div>
								</spring:bind>
								<spring:bind path="zip">
									<div class="form-group">
										<label for="inputZipCode" class="col-sm-3 control-label">Zip Code :</label>
										<div class="col-sm-9">
											<form:input path="zip" type="text" class="form-control" id="inputZipCode" placeholder="Zip Code"></form:input>
											<form:errors path="zip" cssClass="error"></form:errors>
										</div>
									</div>
								</spring:bind>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-default">
											Get Info
										</button>
									</div>
								</div>
							</form:form>
							<!-- Form Ends -->
						</div>
					</div>
					<!-- Taxes Block Ends -->
					<!-- Shipment Information Block Starts -->
					<div class="panel panel-smart">
						<c:choose>
							<c:when test="${successMessage != null}"><span class="success">${successMessage}</span></c:when>
							<c:otherwise>${failureMessage}</c:otherwise>
						</c:choose>
						<span>${message}</span>
						<div class="panel-heading">
							<h3 class="panel-title">
								Shipment Information
							</h3>
						</div>
						<div class="panel-body">
							<!-- Form Starts -->
							<form:form class="form-horizontal" role="form" action="addShippingAddress.htm" method="POST" modelAttribute="userForm">
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
													<option>North India</option>
													<option>South India</option>
												</form:select>
												<form:errors path="addressForm.region" cssClass="error"></form:errors>
											</div>
										</div>
								</spring:bind>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-main">
											Submit
										</button>
									</div>
								</div>
							</form:form>
							<!-- Form Ends -->
						</div>
					</div>
					<!-- Shipment Information Block Ends -->
				</div>
				<!-- Shipping & Shipment Block Ends -->
				<!-- Discount & Conditions Blocks Starts -->
				<div class="col-sm-6">
					<!-- Discount Coupon Block Starts -->
					<div class="panel panel-smart">
						<div class="panel-heading">
							<h3 class="panel-title">
								Discount Coupon Code
							</h3>
						</div>
						<div class="panel-body">
							<!-- Form Starts -->
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label for="inputCouponCode" class="col-sm-3 control-label">
										Coupon Code :
									</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="inputCouponCode"
											placeholder="Coupon Code">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-default">
											Apply Coupon
										</button>
									</div>
								</div>
							</form>
							<!-- Form Ends -->
						</div>
					</div>
					<!-- Discount Coupon Block Ends -->
					<!-- Conditions Panel Starts -->
					<div class="panel panel-smart">
						<div class="panel-heading">
							<h3 class="panel-title">
								Terms &amp; Conditions
							</h3>
						</div>
						<div class="panel-body">
							<p>
								HTML Nullam varius, turpis et commodo pharetra, est eros
								bibendum elit, nec luctus magna felis sollicitudin mauris.
								Integer in mauris eu nibh euismod gravida. Duis ac tellus et
								risus vulputate vehicula.
							</p>
							<p>
								Donec lobortis risus a elit. Etiam tempor. Ut ullamcorper,
								ligula eu tempor congue, eros est euismod turpis, id tincidunt
								sapien risus a quam. Maecenas fermentum consequat mi. Donec
								fermentum. Pellentesque malesuada nulla a mi.
							</p>
							<p>
								Duis sapien sem, aliquet nec, commodo eget, consequat quis,
								neque. Aliquam faucibus, elit ut dictum aliquet, felis nisl
								adipiscing sapien, sed malesuada diam lacus eget erat. Cras
								mollis scelerisque nunc. Nullam arcu. Aliquam consequat.
							</p>
						</div>
					</div>
					<!-- Conditions Panel Ends -->
					<!-- Total Panel Starts -->
					<div class="panel panel-smart">
						<div class="panel-heading">
							<h3 class="panel-title">
								Total
							</h3>
						</div>
						<div class="panel-body">
							<dl class="dl-horizontal">
								<dt>
									Coupon Discount :
								</dt>
								<dd>
									0.00
								</dd>
								<dt>
									Subtotal :
								</dt>
								<dd>
									{{ ngCart.getSubTotal() }}
								</dd>
								<dt>
									Payment Fee :
								</dt>
								<dd>
									{{ ngCart.getPaymentFee()}}
								</dd>
								<dt>
									Shipment Fee :
								</dt>
								<dd>
									{{ ngCart.getShipping()}}
								</dd>
								<dt>
									Tax  :
								</dt>
								<dd>
									{{ ngCart.getTax() }}
								</dd>
								<dt>
									Vat  :
								</dt>
								<dd>
									{{ ngCart.getVat() }}
								</dd>
							</dl>
							<hr />
							<dl class="dl-horizontal total">
								<dt>
									Total :
								</dt>
								<dd>
									{{ngCart.totalCost()}}
								</dd>
							</dl>
							<hr />
							<div class="text-uppercase clearfix">
								<a href="#" class="btn btn-default pull-left"> <span
									class="hidden-xs">Continue Shopping</span> <span
									class="visible-xs">Continue</span> </a>
								<a href="checkout" class="btn btn-default pull-right"> Checkout </a>
							</div>
						</div>
					</div>
					<!-- Total Panel Ends -->
				</div>
				<!-- Discount & Conditions Blocks Ends -->
			</div>
			</section>
			<!-- Shipping Section Ends -->
		</div>
		<!-- Main Container Ends -->
		<!-- Footer Section Starts -->
		<%@include file="footer.jsp"%>
		<!-- Footer Section Ends -->
	</body>