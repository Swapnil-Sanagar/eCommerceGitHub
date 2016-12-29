<!doctype html>
<html lang="en" ng-app="myApp">
	<head>
		<%@include file="metadata.jsp"%>
	</head>
	<body ng-controller="CartController">
		<!-- Header Section Starts -->
		<%@include file="header.jsp"%>

		<div id="main-container" class="container">
			<div class="row">
				<!-- Primary Content Starts -->
				<div class="col-md-9">
					<!-- Breadcrumb Starts -->
					<ol class="breadcrumb">
						<li>
							<a href="home.jsp">Home</a>
						</li>
						<li>
							<a href="#">Category</a>
						</li>
						<li class="active">
							Product
						</li>
					</ol>
					<!-- Breadcrumb Ends -->
					<div id="quantityAlertMsg"></div>
					<!-- Product Info Starts -->
					<div class="row product-info">
						<!-- Left Starts -->
						<div class="col-sm-5 images-block">
							<p>
								<img id="product_<%= request.getParameter("productId")%>" src="<%=request.getContextPath()%>/images/<%= request.getParameter("productId")%>.png"
									alt="Image" class="img-responsive thumbnail" />
							</p>
							<ul class="list-unstyled list-inline">
								<li>
									<img src="<%=request.getContextPath()%>/images/thumb1.png"
										alt="Image" class="img-responsive thumbnail" />
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/images/thumb2.png"
										alt="Image" class="img-responsive thumbnail" />
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/images/thumb3.png"
										alt="Image" class="img-responsive thumbnail" />
								</li>
								<li>
									<img src="<%=request.getContextPath()%>/images/thumb4.png"
										alt="Image" class="img-responsive thumbnail" />
								</li>
							</ul>
						</div>
						<!-- Left Ends -->
						<!-- Right Starts -->
						<div id="<%= request.getParameter("productId")%>" class="col-sm-7 product-details">
							<!-- Product Name Starts -->
							<h2>
								<%= request.getParameter("productName")%>
							</h2>
							<!-- Product Name Ends -->
							<hr />
							<!-- Manufacturer Starts -->
							<ul class="list-unstyled manufacturer">
								<li>
									<span>Brand:</span> Indian spices
								</li>
								<li>
									<span>Reward Points:</span> 300
								</li>
								<li>
									<span>Availability:</span>
									<strong class="label label-success">In Stock</strong>
								</li>
							</ul>
							<!-- Manufacturer Ends -->
							<hr />
							<!-- Price Starts -->
							<div class="price">
								<span class="price-head">Price :</span>
								<span class="price-new">$<%= request.getParameter("unitPrice")%></span>
							</div>
							<!-- Price Ends -->
							<hr />
							
							<!-- Available Options Starts -->
							<div class="options">
								<div class="form-group">
									<label class="control-label text-uppercase"
										for="input-quantity">
										Quantity:
									</label>
									<input ng-model="q" type="text" name="quantity" size="2"
										id="input-quantity" class="form-control" />
								</div>
								<div class="cart-button button-group">
									<button type="button" class="btn btn-cart" ng-click="ngCart.addItem('<%= request.getParameter("productId")%>', '<%= request.getParameter("productName")%>', <%= request.getParameter("unitPrice")%>, q, data,null)">
										Add to cart
									</button>
								</div>
							</div>
							<!-- Available Options Ends -->
							<hr />
						</div>
						<!-- Right Ends -->
					</div>
					<!-- product Info Ends -->
					<!-- Product Description Starts -->
					<div class="product-info-box">
						<h4 class="heading">
							Description
						</h4>
						<div class="content panel-smart">
							<p>
								Lorem Ipsum is simply dummy text of the printing and typesetting
								industry. Lorem Ipsum has been the industry's standard dummy
								text ever since the 1500s, when an unknown printer took a galley
								of type and scrambled it to make a type specimen book. It has
								survived not only five centuries, but also the leap into
								electronic typesetting, remaining essentially unchanged. It was
								popularised in the 1960s with the release of Letraset sheets
								containing Lorem Ipsum passages, and more recently with desktop
								publishing software like Aldus PageMaker including versions of
								Lorem Ipsum.
							</p>
							<p>
								It has survived not only five centuries, but also the leap into
								electronic typesetting, remaining essentially unchanged. It was
								popularised in the 1960s with the release of Letraset sheets
								containing Lorem Ipsum passages, and more recently with desktop
								publishing software like Aldus PageMaker including versions of
								Lorem Ipsum.
							</p>
						</div>
					</div>
					<!-- Product Description Ends -->
					<!-- Additional Information Starts -->
					<div class="product-info-box">
						<h4 class="heading">
							Additional Information
						</h4>
						<div class="content panel-smart">
							<p>
								Lorem Ipsum is simply dummy text of the printing and typesetting
								industry. Lorem Ipsum has been the industry's standard dummy
								text ever since the 1500s, when an unknown printer took a galley
								of type and scrambled it to make a type specimen book. It has
								survived not only five centuries, but also the leap into
								electronic typesetting, remaining essentially unchanged. It was
								popularised in the 1960s with the release of Letraset sheets
								containing Lorem Ipsum passages, and more recently with desktop
								publishing software like Aldus PageMaker including versions of
								Lorem Ipsum.
							</p>
						</div>
					</div>
					<!-- Additional Information Ends -->
					<!-- Related Products Starts -->
					<div class="product-info-box">
						<h4 class="heading">
							Related Products
						</h4>
						<!-- Products Row Starts -->
						<div class="row">
							<!-- Product #1 Starts -->
							<div class="col-md-4 col-sm-6">
								<div class="product-col">
									<div class="image">
										<img src="<%=request.getContextPath()%>/images/1.png"
											alt="product" class="img-responsive" />
									</div>
									<div class="caption">
										<h4>
											<a href="product.jsp">Flowers</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost
											unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span>
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button button-group">
											<button type="button" class="btn btn-cart">
												Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Product #1 Ends -->
							<!-- Product #2 Starts -->
							<div class="col-md-4 col-sm-6">
								<div class="product-col">
									<div class="image">
										<img src="<%=request.getContextPath()%>/images/2.png"
											alt="product" class="img-responsive" />
									</div>
									<div class="caption">
										<h4>
											<a href="product.jsp">Flowers</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost
											unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span>
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button button-group">
											<button type="button" class="btn btn-cart">
												Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Product #2 Ends -->
							<!-- Product #3 Starts -->
							<div class="col-md-4 col-sm-6">
								<div class="product-col">
									<div class="image">
										<img src="<%=request.getContextPath()%>/images/3.png"
											alt="product" class="img-responsive" />
									</div>
									<div class="caption">
										<h4>
											<a href="product.jsp">Flowers</a>
										</h4>
										<div class="description">
											We are so lucky living in such a wonderful time. Our almost
											unlimited ...
										</div>
										<div class="price">
											<span class="price-new">$199.50</span>
											<span class="price-old">$249.50</span>
										</div>
										<div class="cart-button button-group">
											<button type="button" class="btn btn-cart">
												Add to cart
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Product #3 Ends -->
						</div>
						<!-- Products Row Ends -->
					</div>
					<!-- Related Products Ends -->
				</div>
				<!-- Primary Content Ends -->
				<!-- Sidebar Starts -->
				<div class="col-md-3">
					<!-- Categories Links Starts -->
					<h3 class="side-heading">
						Categories
					</h3>
					<div class="list-group">
						<a href="#" class="list-group-item"> <i
							class="fa fa-chevron-right"></i> family flowers </a>
						<a href="#" class="list-group-item"> <i
							class="fa fa-chevron-right"></i> corporate </a>
						<a href="#" class="list-group-item"> <i
							class="fa fa-chevron-right"></i> congratulation </a>
						<a href="#" class="list-group-item"> <i
							class="fa fa-chevron-right"></i> get well </a>
						<a href="#" class="list-group-item"> <i
							class="fa fa-chevron-right"></i> funeral </a>
					</div>
					<!-- Categories Links Ends -->
					<!-- Shopping Options Starts -->
					<h3 class="side-heading">
						Shopping Options
					</h3>
					<div class="list-group">
						<div class="list-group-item">
							Brands
						</div>
						<div class="list-group-item">
							<div class="filter-group">
								<label class="checkbox">
									<input name="filter1" type="checkbox" value="br1"
										checked="checked" />
									Brand Name 1
								</label>
								<label class="checkbox">
									<input name="filter2" type="checkbox" value="br2" />
									Brand Name 2
								</label>
								<label class="checkbox">
									<input name="filter2" type="checkbox" value="br2" />
									Brand Name 3
								</label>
							</div>
						</div>
						<div class="list-group-item">
							Manufacturer
						</div>
						<div class="list-group-item">
							<div class="filter-group">
								<label class="radio">
									<input name="filter-manuf" type="radio" value="mr1"
										checked="checked" />
									Manufacturer Name 1
								</label>
								<label class="radio">
									<input name="filter-manuf" type="radio" value="mr2" />
									Manufacturer Name 2
								</label>
								<label class="radio">
									<input name="filter-manuf" type="radio" value="mr3" />
									Manufacturer Name 3
								</label>
							</div>
						</div>
						<div class="list-group-item">
							<button type="button" class="btn btn-main">
								Filter
							</button>
						</div>
					</div>
					<!-- Shopping Options Ends -->
					<!-- Bestsellers Links Starts -->
					<h3 class="side-heading">
						Bestsellers
					</h3>
					<div class="product-col">
						<div class="image">
							<img src="<%=request.getContextPath()%>/images/9.png"
								alt="product" class="img-responsive" />
						</div>
						<div class="caption">
							<h4>
								<a href="#">Flowers</a>
							</h4>
							<div class="description">
								We are so lucky living in such a wonderful time. Our almost
								unlimited ...
							</div>
							<div class="price">
								<span class="price-new">$199.50</span>
								<span class="price-old">$249.50</span>
							</div>
							<div class="cart-button button-group">
								<button type="button" class="btn btn-cart">
									Add to cart
								</button>
							</div>
						</div>
					</div>
					<!-- Bestsellers Links Ends -->
				</div>
				<!-- Sidebar Ends -->
			</div>
		</div>
		<!-- Main Container Ends -->
		<!-- Footer Section Starts -->
		<%@include file="footer.jsp"%>
		<!-- Footer Section Ends -->
	</body>