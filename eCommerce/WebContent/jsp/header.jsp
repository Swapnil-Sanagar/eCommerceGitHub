<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="header-area"> <!-- Starts -->
<div class="container">
	<!-- Header Top Starts -->
	<div class="header-top">
		<div class="row" ng-controller="CartController">
			<!-- Header Links Starts -->
			<div class="col-sm-8 col-xs-12">
				<div class="header-links">
					<ul class="nav navbar-nav pull-left">
						<li><a href="<%=request.getContextPath()%>/"> <i
								class="fa fa-home hidden-lg hidden-md" title="Home"></i> <span
								class="hidden-sm hidden-xs"> Home </span> </a></li>
						<li><a href="#"> <i
								class="fa fa-heart hidden-lg hidden-md" title="Wish List"></i> <span
								class="hidden-sm hidden-xs"> Wish List(0) </span> </a></li>
						<li><a href="#"> <i
								class="fa fa-user hidden-lg hidden-md" title="My Account"></i> <span
								class="hidden-sm hidden-xs"> My Account </span> </a></li>
						<li><a href="cart"> <i
								class="fa fa-shopping-cart hidden-lg hidden-md"
								title="Shopping Cart"></i> <span class="hidden-sm hidden-xs">
									Shopping Cart </span> </a></li>
									
						<c:choose>
						<c:when  test="${pageContext.request.userPrincipal.name != null}">
							<li><a href="#"> <i
								class="fa fa-shopping-cart hidden-lg hidden-md"
								title="Name"></i> <span class="hidden-sm hidden-xs">
									Welcome <b>${pageContext.request.userPrincipal.name}</b> </span> </a></li>
							<li><a href="#" ng-click="addCartItemsOnLogout();"> <i
								class="fa fa-home hidden-lg hidden-md" title="Logout"></i> <span
								class="hidden-sm hidden-xs"> Logout </span> </a></li>
						</c:when>
						<c:otherwise>
							<li><a href="<%= request.getContextPath()%>/register"> <i
								class="fa fa-unlock hidden-lg hidden-md" title="Register"></i> <span
								class="hidden-sm hidden-xs"> Register </span> </a></li>
							<li><a href="<%= request.getContextPath()%>/login"> <i
								class="fa fa-lock hidden-lg hidden-md" title="Login"></i> <span
								class="hidden-sm hidden-xs"> Login </span> </a></li>
						</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			<!-- Header Links Ends -->
			<!-- Currency & Languages Starts -->
			<div class="col-sm-4 col-xs-12">
				<div class="pull-right">
					<!-- Languages Starts -->
					<div class="btn-group">
						<button class="btn btn-link dropdown-toggle"
							data-toggle="dropdown">
							<span class="hidden-sm hidden-xs">Language</span> <span
								class="hidden-lg hidden-md">EN</span> <i
								class="fa fa-angle-double-down"></i>
						</button>
						<ul class="pull-right dropdown-menu">
							<li><a tabindex="-1" href="#">English</a></li>
							<li><a tabindex="-1" href="#">French</a></li>
						</ul>
					</div>
					<!-- Languages Ends -->
					<!-- Currency Starts -->
					<div class="btn-group">
						<button class="btn btn-link dropdown-toggle"
							data-toggle="dropdown">
							<span class="hidden-sm hidden-xs">Currency</span> <span
								class="hidden-lg hidden-md">$</span> <i
								class="fa fa-angle-double-down"></i>
						</button>
						<ul class="pull-right dropdown-menu">
							<li><a tabindex="-1" href="#">Pound </a>
							</li>
							<li><a tabindex="-1" href="#">US Dollar</a>
							</li>
							<li><a tabindex="-1" href="#">Euro</a>
							</li>
						</ul>
					</div>
					<!-- Currency Ends -->
				</div>
			</div>
			<!-- Currency & Languages Ends -->
		</div>
	</div>
	<!-- Header Top Ends -->
	<!-- Main Header Starts -->
	<div class="main-header">
		<div class="row">
			<!-- Search Starts -->
			<div class="col-md-3">
				<div id="search">
					<div class="input-group">
						<input type="text" class="form-control input-lg"
							placeholder="Search"> <span class="input-group-btn">
							<button class="btn btn-lg" type="button">
								<i class="fa fa-search"></i>
							</button> </span>
					</div>
				</div>
			</div>
			<!-- Search Ends -->
			<!-- Logo Starts -->
			<div class="col-md-5">
				<div id="logo">
					<a href="<%=request.getContextPath()%>/"><img
						src="<%=request.getContextPath()%>/images/logo.png"
						title="Flower Shoppe" alt="Flower Shoppe" class="img-responsive" />
					</a>
				</div>
			</div>
			<!-- Logo Starts -->
			<!-- Shopping Cart Starts -->
			<div class="col-md-4">
				<c:choose>
				<c:when test="${afterLogin != null}">
					<div ng-if="${afterLogin} == true">
						<div id="cart" class="btn-group btn-block" 
						 	ng-controller="CartDBController">
							<button type="button" data-toggle="dropdown"
								class="btn btn-block btn-lg dropdown-toggle">
								<i class="fa fa-shopping-cart"></i>
								<span class="hidden-md">Cart:</span>
								<span id="cart-total"> <span style="margin-top: 0px;"
									ng-bind="ngCart.getTotalItems()"></span> <span
									style="margin-top: 0px;"> <ng-pluralize
											count="ngCart.getTotalItems()"
											when="{1: 'item', 'other':'items'}"></ng-pluralize>
								</span>&nbsp; <span style="margin-top: 0px;"
									ng-bind="ngCart.totalCost() | currency"></span> </span> <i
									class="fa fa-caret-down"></i>
							</button>
							<ul class="dropdown-menu pull-right">
								<li>
									<table class="table hcart">
										<tr ng-repeat="item in ngCart.getCart().items">
											<td class="text-center"><a href="#"> <img
													src="<%=request.getContextPath()%>/images/hcart-thumb1.png"
													alt="image" title="image"
													class="img-thumbnail img-responsive" /> </a></td>
											<td class="text-left"><a href="#"> {{
													item._name }} </a></td>
											<td class="text-right">x {{ item._quantity }}</td>
											<td class="text-right">$ {{ item._price }}</td>
											<td class="text-center"><a
												ng-click="ngCart.removeItemById( item._id )"
												style="cursor: pointer;"> <i class="fa fa-times"></i> </a></td>
										</tr>
									</table></li>
								<li>
									<table class="table table-bordered total">
										<tbody>
											<tr>
												<td class="text-right"><strong>Sub-Total</strong>
												</td>
												<td class="text-left">{{ ngCart.getSubTotal() }}</td>
											</tr>
											<tr>
												<td class="text-right"><strong>Eco Tax (-2.00)</strong>
												</td>
												<td class="text-left">{{ ngCart.getTax() }}</td>
											</tr>
											<tr>
												<td class="text-right"><strong>VAT (17.5%)</strong>
												</td>
												<td class="text-left">{{ ngCart.getVat() }}</td>
											</tr>
											<tr>
												<td class="text-right"><strong>Total</strong>
												</td>
												<td class="text-left">{{ ngCart.totalCost() }}</td>
											</tr>
										</tbody>
									</table>
									<p class="text-right btn-block1">
										<a href="<%=request.getContextPath()%>/cart"> View Cart </a> <a href="#"> Checkout </a>
									</p></li>
							</ul>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div id="cart" class="btn-group btn-block"
					 	ng-controller="CartController" >
						<button type="button" data-toggle="dropdown"
							class="btn btn-block btn-lg dropdown-toggle">
							<i class="fa fa-shopping-cart"></i> <span class="hidden-md">Cart:</span>
							<span id="cart-total"> <span style="margin-top: 0px;"
								ng-bind="ngCart.getTotalItems()"></span> <span
								style="margin-top: 0px;"> <ng-pluralize
										count="ngCart.getTotalItems()"
										when="{1: 'item', 'other':'items'}"></ng-pluralize>
							</span>&nbsp; <span style="margin-top: 0px;"
								ng-bind="ngCart.totalCost() | currency"></span> </span> <i
								class="fa fa-caret-down"></i>
						</button>
						<ul class="dropdown-menu pull-right">
							<li>
								<table class="table hcart">
									<tr ng-repeat="item in ngCart.getCart().items">
										<td class="text-center"><a href="#"> <img
												src="<%=request.getContextPath()%>/images/hcart-thumb1.png"
												alt="image" title="image"
												class="img-thumbnail img-responsive" /> </a></td>
										<td class="text-left"><a href="#"> {{
												item._name }} </a></td>
										<td class="text-right">x {{ item._quantity }}</td>
										<td class="text-right">$ {{ item._price }}</td>
										<td class="text-center"><a
											ng-click="ngCart.removeItemById( item._id )"
											style="cursor: pointer;"> <i class="fa fa-times"></i> </a></td>
									</tr>
								</table></li>
							<li>
								<table class="table table-bordered total">
									<tbody>
										<tr>
											<td class="text-right"><strong>Sub-Total</strong>
											</td>
											<td class="text-left">{{ ngCart.getSubTotal() }}</td>
										</tr>
										<tr>
											<td class="text-right"><strong>Eco Tax (-2.00)</strong>
											</td>
											<td class="text-left">{{ ngCart.getTax() }}</td>
										</tr>
										<tr>
											<td class="text-right"><strong>VAT (17.5%)</strong>
											</td>
											<td class="text-left">{{ ngCart.getVat() }}</td>
										</tr>
										<tr>
											<td class="text-right"><strong>Total</strong>
											</td>
											<td class="text-left">{{ ngCart.totalCost() }}</td>
										</tr>
									</tbody>
								</table>
								<p class="text-right btn-block1">
									<a href="<%=request.getContextPath()%>/cart"> View Cart </a> <a href="checkout"> Checkout </a>
								</p></li>
						</ul>
					</div>
				</c:otherwise>
				</c:choose>
			</div>
			<form id="logout" action="<%= request.getContextPath() %>/logout" method="post">
			  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<!-- Shopping Cart Ends -->
		</div>
	</div>
	<!-- Main Header Ends -->
	<!-- Main Menu Starts -->
	<nav id="main-menu" class="navbar" role="navigation"> <!-- Nav Header Starts -->
	<div class="navbar-header">
		<button type="button" class="btn btn-navbar navbar-toggle"
			data-toggle="collapse" data-target=".navbar-cat-collapse">
			<span class="sr-only">Toggle Navigation</span> <i class="fa fa-bars"></i>
		</button>
	</div>
				
	<!-- Nav Header Ends --> <!-- Navbar Cat collapse Starts -->
	<div class="collapse navbar-collapse navbar-cat-collapse">
		<ul class="nav navbar-nav" ng-controller="CategoryMenuController">
			<li ng-repeat="category in menuCategories">
				<a 
				ng-class="{ 'dropdown-toggle': category.categories.length>0 }"
				ng-attr-data-toggle=" {{category.categories.length>0 ? 'dropdown' : 'notToggle' }}"
				ng-attr-data-hover=" {{category.categories.length>0 ? 'dropdown' : 'notHover' }}"
				ng-attr-data-delay=" {{category.categories.length>0 ? '10' : 'notDelay' }}"
				href="<%=request.getContextPath()%>/jsp/categoryGrid.jsp?categoryId={{category.categoryId}}&categoryName={{category.categoryName}}&categoryDescription={{category.categoryDescription}}" >
				{{category.categoryName}}
				</a>
				
				<div class="dropdown-menu" ng-if="category.categories.length>0">
					<div class="dropdown-inner">
						<ul class="list-unstyled" >
							<li ng-repeat="subLevel1category in category.categories">
								<a  tabindex="-2" 
								href="<%=request.getContextPath()%>/jsp/categoryList.jsp?categoryId={{subLevel1category.categoryId}}&categoryName={{category.categoryName}}&categoryDescription={{category.categoryDescription}}" >{{subLevel1category.categoryName}}</a>
							</li>
						</ul>										
					</div>
				</div>
					
			</li>
			
                 
			<li class="dropdown"><a href="<%=request.getContextPath()%>/jsp/category-list.jsp?categoryId={{category.categoryId}}&categoryName={{category.categoryName}}&categoryDescription={{category.categoryDescription}}"
				class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
				data-delay="10"> Pages </a>
				<ul class="dropdown-menu" role="menu">
					<li><a tabindex="-1" href="<%=request.getContextPath()%>/">Home</a>
					</li>
					<li><a tabindex="-1" href="#">About</a>
					</li>
					<li><a tabindex="-1" href="#">Category
							List</a>
					</li>
					<li><a tabindex="-1" href="#">Category
							Grid</a>
					</li>
					<li><a tabindex="-1" href="product.jsp">Product</a>
					</li>
					<li><a tabindex="-1" href="#">Product Full
							Width</a>
					</li>
					<li><a tabindex="-1" href="cart">Cart</a>
					</li>
					<li><a tabindex="-1" href="login.jsp">Login</a>
					</li>
					<li><a tabindex="-1" href="#">Compare Products</a>
					</li>
					<li><a tabindex="-1" href="#">Typography</a>
					</li>
					<li><a tabindex="-1" href="register.jsp">Register</a>
					</li>
					<li><a tabindex="-1" href="#">Contact</a>
					</li>
					<li><a tabindex="-1" href="#">404</a>
					</li>
				</ul>
			</li>
		</ul> 
	</div>
	<!-- Navbar Cat collapse Ends --> </nav>
	<!-- Main Menu Ends -->
</div>
<!-- Ends --> </header>
<!-- Header Section Ends -->