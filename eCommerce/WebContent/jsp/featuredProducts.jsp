<section class="product-carousel">


<div class="container" ng-controller="FeatureProductController">
	<!-- Heading Starts -->
	<h2 class="product-head">Featured Products</h2>
	<!-- Heading Ends -->
	<!-- Products Row Starts -->
		<div class="carousel slide row" data-ride="carousel" data-type="multi"
		data-interval="2000" id="fruitscarousel1">

		<div class="carousel-inner">
			<div ng-class="$first ? 'item active' : 'item'"
				ng-repeat="product in featuredProducts" id="{{product.productId}}" ng-if="$index+6 <=featuredProducts.length">
				<div class="col-md-3 col-sm-4 col-xs-12 product-col"
					style="width: 100%">
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index].productId}}&productName={{featuredProducts[$index].productName}}&unitPrice={{featuredProducts[$index].unitPrice}}">{{featuredProducts[$index].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index].productId}}&productName={{featuredProducts[$index].productName}}&unitPrice={{featuredProducts[$index].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right:30px">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index+1].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+1].productId}}&productName={{featuredProducts[$index+1].productName}}&unitPrice={{featuredProducts[$index+1].unitPrice}}">{{featuredProducts[$index+1].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index+1].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index+1].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index+1].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+1].productId}}&productName={{featuredProducts[$index+1].productName}}&unitPrice={{featuredProducts[$index+1].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index+2].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+2].productId}}&productName={{featuredProducts[$index+2].productName}}&unitPrice={{featuredProducts[$index+2].unitPrice}}">{{featuredProducts[$index+2].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index+2].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index+2].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index+2].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+2].productId}}&productName={{featuredProducts[$index+2].productName}}&unitPrice={{featuredProducts[$index+2].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px" ng-init="$index ==$index+3">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index+3].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+3].productId}}&productName={{featuredProducts[$index+3].productName}}&unitPrice={{featuredProducts[$index+3].unitPrice}}">{{featuredProducts[$index+3].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index+3].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index+3].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index+3].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+3].productId}}&productName={{featuredProducts[$index+3].productName}}&unitPrice={{featuredProducts[$index+3].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px" ng-init="$index ==$index+4">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index+4].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+4].productId}}&productName={{featuredProducts[$index+4].productName}}&unitPrice={{featuredProducts[$index+4].unitPrice}}">{{featuredProducts[$index+4].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index+4].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index+4].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index+4].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+4].productId}}&productName={{featuredProducts[$index+4].productName}}&unitPrice={{featuredProducts[$index+4].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
					<div class="image" style="float: left;padding-right: 30px" ng-init="$index ==$index+5">
						<img
							src="<%=request.getContextPath()%>/images/{{featuredProducts[$index+5].imageName}}"
							alt="product" class="img-responsive">

						<div class="caption">
							<h4>
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+5].productId}}&productName={{featuredProducts[$index+5].productName}}&unitPrice={{featuredProducts[$index+5].unitPrice}}">{{featuredProducts[$index+5].productName}}</a>
							</h4>
							<div class="description">
								{{featuredProducts[$index+5].productDescription}}</div>
							<div class="price">
								<span class="price-new"><label>$</label>{{featuredProducts[$index+5].unitPrice}}</span>
								<span class="price-old"><label>$</label>{{featuredProducts[$index+5].msrp}}</span>
							</div>
							<div class="cart-button button-group">
								<a
									href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{featuredProducts[$index+5].productId}}&productName={{featuredProducts[$index+5].productName}}&unitPrice={{featuredProducts[$index+5].unitPrice}}"
									type="button" class="btn btn-cart"> Add To Cart </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<a class="left carousel-control" style="width: 8%"
			href="#fruitscarousel1" data-slide="prev"><i
			class="glyphicon glyphicon-chevron-left"></i> </a> <a
			class="right carousel-control" style="width: 8%"
			href="#fruitscarousel1" data-slide="next"><i
			class="glyphicon glyphicon-chevron-right"></i> </a>

	</div>
	<!-- Products Row Ends -->
</div>
</section>