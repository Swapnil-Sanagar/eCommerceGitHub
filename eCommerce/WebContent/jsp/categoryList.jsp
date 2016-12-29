 <!doctype html>
<html lang="en" ng-app="myApp">
	<head>
		<%@include file="metadata.jsp"%>
	</head>
	<body ng-controller="CategoryMenuController" ng-init="categoryId='<%= request.getParameter("categoryId")%>'">
		<!-- Header Section Starts -->
		<%@include file="header.jsp"%>
		<div id="main-container" class="container">
			<div class="row">
				<!-- Primary Content Starts -->
				<!-- Primary Content Starts -->
				<div class="col-md-9">
				<!-- Breadcrumb Starts -->
					<ol class="breadcrumb">
						<li><a href="home.jsp">Home</a></li>
						<li class="active"><%= request.getParameter("categoryName") %></li>
					</ol>
				<!-- Breadcrumb Ends -->
				<!-- Main Heading Starts -->
					<h2 class="main-heading2">
						<%= request.getParameter("categoryName") %>
					</h2>
				<!-- Main Heading Ends -->
				<!-- Category Intro Content Starts -->
					<div class="row cat-intro">
						<div class="col-sm-3">
							<img src="<%=request.getContextPath()%>/images/cat-thumb-img1.png" alt="Image" class="img-responsive img-thumbnail" />
						</div>
						<div class="col-sm-9 cat-body">
							<%= request.getParameter("categoryDescription") %>
						</div>
					</div>					
				<!-- Category Intro Content Ends -->
				<!-- Product Filter Starts -->
					<div class="product-filter">
						<div class="row">
							<div class="col-md-4">
								<div class="display">
									<a href="<%= request.getContextPath()%>/jsp/categoryList.jsp?categoryId=<%= request.getParameter("categoryId") %>&categoryName=<%= request.getParameter("categoryName") %>&categoryDescription=<%= request.getParameter("categoryDescription") %>" class="active">
										<i class="fa fa-th-list" title="List View"></i>
									</a>
									<a href="<%= request.getContextPath()%>/jsp/categoryGrid.jsp?categoryId=<%= request.getParameter("categoryId") %>&categoryName=<%= request.getParameter("categoryName") %>&categoryDescription=<%= request.getParameter("categoryDescription") %>">
										<i class="fa fa-th" title="Grid View"></i>
									</a>
								</div>
							 </div>
							<div class="col-md-2 text-right">
								<label class="control-label">Sort</label>
							</div>
							<div class="col-md-3 text-right">
								<select class="form-control">
									<option value="default" selected="selected">Default</option>
									<option value="NAZ">Name (A - Z)</option>
									<option value="NZA">Name (Z - A)</option>
								</select>
							</div>
							<div class="col-md-1 text-right">
								<label class="control-label">Show</label>
							</div>
							<div class="col-md-2 text-right">
								<select class="form-control">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3" selected="selected">3</option>
								</select>
							</div>
						</div>						 
					</div>
				<!-- Product Filter Ends -->
				<!-- Product List Display Starts -->
					<div class="row"  ng-controller="CategoryProductListController">
					<!-- Product #1 Starts -->
						<div class="col-xs-12" ng-repeat="product in categoryProducts" id="{{product.productId}}">
							<div class="product-col list clearfix">
								<div class="image">
									<img src="<%=request.getContextPath()%>/images/{{product.imageName}}" alt="product" class="img-responsive" />
								</div>
								<div class="caption">
									<h4><a href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{product.productId}}&productName={{product.productName}}&unitPrice={{product.unitPrice}}">{{product.productName}}</a></h4>
									<div class="description">
										{{product.productDescription}}
									</div>
									<div class="price">
										<span class="price-new"><label>$</label>{{product.unitPrice}}</span> 
										<span class="price-old"><label>$</label>{{product.msrp}}</span>
									</div>
									<div class="cart-button button-group">
										<a  
											href="<%=request.getContextPath()%>/jsp/product.jsp?productId={{product.productId}}&productName={{product.productName}}&unitPrice={{product.unitPrice}}"
											type="button" class="btn btn-cart"> Add To Cart </a>								
									</div>
								</div>
							</div>
						</div>
					<!-- Product #1 Ends -->
					</div>
				<!-- Product List Display Ends -->
				<!-- Pagination & Results Starts -->
					<div class="row">
					<!-- Pagination Starts -->
						<div class="col-sm-6 pagination-block">
							<ul class="pagination">
							  <li><a href="#">&laquo;</a></li>
							  <li class="active"><a href="#">1</a></li>
							  <li><a href="#">2</a></li>
							  <li><a href="#">3</a></li>
							  <li><a href="#">4</a></li>
							  <li><a href="#">5</a></li>
							  <li><a href="#">&raquo;</a></li>
							</ul>
						</div>
					<!-- Pagination Ends -->
					<!-- Results Starts -->
						<div class="col-sm-6 results">
							Showing 1 to 3 of 12 (4 Pages)
						</div>
					<!-- Results Ends -->
					</div>
				<!-- Pagination & Results Ends -->
				</div>
				<!-- Primary Content Ends -->
				<!-- Sidebar Starts -->
				<div class="col-md-3">
					<!-- Categories Links Starts -->
					<h3 class="side-heading">
						Categories
					</h3>
					<div class="list-group" >
						<a ng-repeat="category in menuCategories" href="<%= request.getContextPath()%>/jsp/categoryGrid.jsp?categoryId={{category.categoryId}}&categoryName={{category.categoryName}}&categoryDescription={{category.categoryDescription}}" class="list-group-item"> <i
							class="fa fa-chevron-right"></i>{{category.categoryName}}</a>
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
</html>