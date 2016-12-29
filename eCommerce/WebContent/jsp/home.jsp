<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" ng-app="myApp" >
	<head>
		<%@include file="metadata.jsp"%>
	</head>
	<body>
		<!-- Header Section Starts -->
		<%@include file="header.jsp"%>
		<!-- Slider Section Starts -->
		<div class="slider">
			<div class="container">
				<div id="main-carousel" class="carousel slide" data-ride="carousel">
					<!-- Wrapper For Slides Starts -->
					<div class="carousel-inner">
						<div class="item active">
							<img  style="width:100%;" src="<%=request.getContextPath()%>/images/BigSave_Diwali_10Oct.jpg"
								alt="Slider" class="img-responsive img-circle" />
						</div>
						<div class="item">
							<img style="width:100%;" src="<%=request.getContextPath()%>/images/diwali_Hero_packs-7Oct.jpg"
								alt="Slider" class="img-responsive img-circle" />
						</div>
						<div class="item">
							<img style="width:100%;" src="<%=request.getContextPath()%>/images/Lindberg_Desktop_banner.jpg"
								alt="Slider" class="img-responsive img-circle" />
						</div>
						<div class="item">
							<img style="width:100%;" src="<%=request.getContextPath()%>/images/Diwali-inhousebrands-13Oct.jpg"
								alt="Slider" class="img-responsive img-circle" />
						</div>
					</div>
					<!-- Wrapper For Slides Ends -->
					<!-- Controls Starts -->
					<a class="left carousel-control" href="#main-carousel"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> </a>
					<a class="right carousel-control" href="#main-carousel"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> </a>
					<!-- Controls Ends -->
				</div>
			</div>
		</div>
		<!-- Slider Section Ends -->
		<!-- Latest Products Starts -->
		<%@include file="latestProducts.jsp"%>
		<!-- Latest Products Ends -->
		<!-- 3 Column Banners Starts -->
		<div class="col3-banners">
			<div class="container">
				<ul class="row list-unstyled">
					<li class="col-sm-4">
						<img src="<%=request.getContextPath()%>/images/3col-banner1.jpg"
							alt="banners" class="img-responsive" />
					</li>
					<li class="col-sm-4">
						<img src="<%=request.getContextPath()%>/images/3col-banner2.jpg"
							alt="banners" class="img-responsive" />
					</li>
					<li class="col-sm-4">
						<img src="<%=request.getContextPath()%>/images/3col-banner3.jpg"
							alt="banners" class="img-responsive" />
					</li>
				</ul>
			</div>
		</div>
		<!-- 3 Column Banners Ends -->
		<!-- Featured Products Starts -->
		<%@include file="featuredProducts.jsp"%>
		<!-- Featured Products Ends -->
		<!-- 1 Column Banners Starts -->
		<div class="col1-banners">
			<div class="container">
				<img src="<%=request.getContextPath()%>/images/1col-banner1.jpg"
					alt="banners" class="img-responsive" />
			</div>
		</div>
		<!-- 1 Column Banners Ends -->
		<!-- Footer Section Starts -->
		<%@include file="footer.jsp"%>
		<!-- Footer Section Ends -->
	</body>
</html>