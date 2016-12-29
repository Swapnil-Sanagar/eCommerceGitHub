<section class="product-carousel">


<div class="container" ng-controller="LatestProductController">
	<!-- Heading Starts -->
	<h2 class="product-head">Latest Products</h2>
	<!-- Heading Ends -->
	<!-- Products Row Starts -->
		<div class="carousel slide row" data-ride="carousel" data-type="multi"
		data-interval="2000" id="fruitscarousel">

		<div class="carousel-inner">
			<div ng-class="$first ? 'item active' : 'item'"
				ng-repeat="product in latestProducts" id="{{product.productId}}" ng-if="$index+6 <=latestProducts.length">
				<div class="col-md-3 col-sm-4 col-xs-12 product-col"
					style="width: 100%">
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index].productId}}&productName={{latestProducts[$index].productName}}&unitPrice={{latestProducts[$index].unitPrice}}">{{latestProducts[$index].productName}}</a>
							</h4>
							<div class="description" style="text-align:center;">
								{{latestProducts[$index].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index].productId}}&productName={{latestProducts[$index].productName}}&unitPrice={{latestProducts[$index].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index+1].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+1].productId}}&productName={{latestProducts[$index+1].productName}}&unitPrice={{latestProducts[$index+1].unitPrice}}">{{latestProducts[$index+1].productName}}</a>
							</h4>
							<div class="description">
								{{latestProducts[$index+1].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index+1].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index+1].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+1].productId}}&productName={{latestProducts[$index+1].productName}}&unitPrice={{latestProducts[$index+1].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index+2].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+2].productId}}&productName={{latestProducts[$index+2].productName}}&unitPrice={{latestProducts[$index+2].unitPrice}}">{{latestProducts[$index+2].productName}}</a>
							</h4>
							<div class="description">
								{{latestProducts[$index+2].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index+2].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index+2].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+2].productId}}&productName={{latestProducts[$index+2].productName}}&unitPrice={{latestProducts[$index+2].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px" ng-init="$index ==$index+3">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index+3].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+3].productId}}&productName={{latestProducts[$index+3].productName}}&unitPrice={{latestProducts[$index+3].unitPrice}}">{{latestProducts[$index+3].productName}}</a>
							</h4>
							<div class="description">
								{{latestProducts[$index+3].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index+3].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index+3].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+3].productId}}&productName={{latestProducts[$index+3].productName}}&unitPrice={{latestProducts[$index+3].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index+4].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+4].productId}}&productName={{latestProducts[$index+4].productName}}&unitPrice={{latestProducts[$index+4].unitPrice}}">{{latestProducts[$index+4].productName}}</a>
							</h4>
							<div class="description" style="text-align:center;">
								{{latestProducts[$index+4].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index+4].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index+4].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+4].productId}}&productName={{latestProducts[$index+4].productName}}&unitPrice={{latestProducts[$index+4].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{latestProducts[$index+5].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+5].productId}}&productName={{latestProducts[$index+5].productName}}&unitPrice={{latestProducts[$index+5].unitPrice}}">{{latestProducts[$index+5].productName}}</a>
							</h4>
							<div class="description" style="text-align:center;">
								{{latestProducts[$index+5].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{latestProducts[$index+5].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{latestProducts[$index+5].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{latestProducts[$index+5].productId}}&productName={{latestProducts[$index+5].productName}}&unitPrice={{latestProducts[$index+5].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<a class="left carousel-control" style="width: 8%"
			href="#fruitscarousel" data-slide="prev"><i
			class="glyphicon glyphicon-chevron-left"></i> </a> <a
			class="right carousel-control" style="width: 8%"
			href="#fruitscarousel" data-slide="next"><i
			class="glyphicon glyphicon-chevron-right"></i> </a>

	</div>
	<!-- Products Row Ends -->
</div>
</section>