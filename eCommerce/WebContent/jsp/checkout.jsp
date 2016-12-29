<!doctype html>
<html lang="en" ng-app="myApp">
<head>
<%@include file="metadata.jsp"%>
<script type="text/javascript">
	$(document)
			.delegate(
					'#button-shipping-method',
					'click',
					function() {
						$('#collapse-payment-method')
								.parent()
								.find('.panel-heading .panel-title')
								.html(
										'<a href="#collapse-payment-method" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle">Step 2: Payment Method</a>');
						$('a[href=\'#collapse-shipping-method\']').trigger(
								'click');
						$('a[href=\'#collapse-payment-method\']').trigger(
								'click');
						$('#collapse-checkout-confirm').parent().find(
								'.panel-heading .panel-title').html(
								'Step 3: Confirm Order');
					});
	$(document)
			.delegate(
					'#button-payment-method',
					'click',
					function() {
						$('#collapse-checkout-confirm')
								.parent()
								.find('.panel-heading .panel-title')
								.html(
										'<a href="#collapse-checkout-confirm" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle">Step 3: Confirm Order</a>');
						$('a[href=\'#collapse-payment-method\']').trigger(
								'click');
						$('a[href=\'#collapse-checkout-confirm\']').trigger(
								'click');

					});
</script>
</head>
<body ng-controller="CartController">
	<!-- Header Section Starts -->
	<%@include file="header.jsp"%>
	<div id="main-container" class="container">
		<!-- Breadcrumb Starts -->
		<ol class="breadcrumb">
			<li><a href="home.jsp">Home</a>
			</li>
			<li><a href="cart">Shopping Cart</a>
			</li>
			<li class="active">Checkout</li>
		</ol>
		<!-- Breadcrumb Ends -->
		<!-- Main Heading Starts -->
		<h2 class="main-heading text-center">Checkout</h2>
		<!-- Main Heading Ends -->

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a href="#collapse-shipping-method" data-toggle="collapse"
						data-parent="#accordion" class="accordion-toggle">Step 1:
						Delivery Method </a>
				</h4>
			</div>
			<div class="panel-collapse collapse" id="collapse-shipping-method"
				style="height: auto;">
				<div class="panel-body">
					<p>Please select the preferred shipping method to use on this
						order.</p>
					<p>
						<strong>Flat Rate</strong>
					</p>
					<div class="radio">
						<label> <input type="radio" name="shipping_method"
							value="flat.flat" checked="checked"> Flat Shipping Rate -
							$5.00</label>
					</div>
					<p>
						<strong>Add Comments About Your Order</strong>
					</p>
					<p>
						<textarea name="comment" rows="8" class="form-control"></textarea>
					</p>
					<div class="buttons">
						<div class="pull-right">
							<input type="button" value="Continue" id="button-shipping-method"
								data-loading-text="Loading..." class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						class="accordion-toggle">Step 2: Payment Method </a>
				</h4>
			</div>
			<div class="panel-collapse collapse" id="collapse-payment-method"
				style="height: auto;">
				<div class="panel-body">
					<p>Please select the preferred payment method to use on this
						order.</p>
					<div class="radio">
						<label> <input type="radio" name="payment_method"
							value="cod" checked="checked"> Cash On Delivery </label>
					</div>
					<p>
						<strong>Add Comments About Your Order</strong>
					</p>
					<p>
						<textarea name="comment" rows="8" class="form-control"></textarea>
					</p>
					<div class="buttons">
						<div class="pull-right">
							I have read and agree to the <a
								href="http://demopavothemes.com/pav_floral/index.php?route=information/information/agree&amp;information_id=5"
								class="agree"><b>Terms &amp; Conditions</b> </a> <input
								type="checkbox" name="agree" value="1"> &nbsp; <input
								type="button" value="Continue" id="button-payment-method"
								data-loading-text="Loading..." class="btn btn-primary">
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						class="accordion-toggle">Step 3: Confirm Order </a>
				</h4>
			</div>
			<div class="panel-collapse collapse" id="collapse-checkout-confirm"
				style="height: auto;">
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td class="text-left">Product Name</td>
									<td class="text-left">Model</td>
									<td class="text-right">Quantity</td>
									<td class="text-right">Unit Price</td>
									<td class="text-right">Total</td>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="item in ngCart.getCart().items">
									<td class="text-left"><a href="#"><span
											ng-bind="item._name"></span>
									</a></td>
									<td class="text-left"><span ng-bind="item._name"></span>
									</td>
									<td class="text-right"><span ng-bind="item._quantity"></span>
									</td>
									<td class="text-right"><span ng-bind="item._price"></span>
									</td>
									<td class="text-right">{{ item._quantity * item._price }}</span>
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="4" class="text-right"><strong>Sub-Total:</strong>
									</td>
									<td class="text-right"><span
										ng-bind="ngCart.getSubTotal()"></span>
									</td>
								</tr>
								<tr>
									<td colspan="4" class="text-right"><strong>Eco
											Tax (-2.00)</strong>
									</td>
									<td class="text-right"><span ng-bind="ngCart.getTax()"></span>
									</td>
								</tr>
								<tr>
									<td colspan="4" class="text-right"><strong>VAT
											(17.5%)</strong>
									</td>
									<td class="text-right"><span ng-bind="ngCart.getVat()"></span>
									</td>
								</tr>
								<tr>
									<td colspan="4" class="text-right"><strong>Total:</strong>
									</td>
									<td class="text-right"><span ng-bind="ngCart.totalCost()"></span>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
					<div class="buttons">
						<div class="pull-right" ng-controller="OrderController">
							<a ng-click="confirmOrder()" id="button-confirm"
								class="btn btn-primary" data-loading-text="Loading...">Confirm
								Order</a>
						</div>
					</div>
					<!-- <script type="text/javascript">
					
						$('#button-confirm')
								.on(
										'click',
										function() {
											$
													.ajax({
														type : 'get',
														url : 'index.php?route=extension/payment/cod/confirm',
														cache : false,
														beforeSend : function() {
															$('#button-confirm')
																	.button(
																			'loading');
														},
														complete : function() {
															$('#button-confirm')
																	.button(
																			'reset');
														},
														success : function() {
															location = 'http://demopavothemes.com/pav_floral/index.php?route=checkout/success';
														}
													});
										});
					
					</script> -->
				</div>
			</div>
		</div>
	</div>
	<!-- Footer Section Starts -->
	<%@include file="footer.jsp"%>
	<!-- Footer Section Ends -->
</body>
</html>