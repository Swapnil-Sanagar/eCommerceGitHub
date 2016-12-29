<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/favicon.ico" />
<meta charset="utf-8">
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Flowers Shoppe Stores - Bootstrap 3 E-Commerce Template</title>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

<!-- Google Web Fonts -->
<link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

<!-- CSS Files -->
<link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/owl.carousel.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/responsive.css" rel="stylesheet">

<!-- JavaScript Files -->
<%@include file="include.jsp"%>

<!--[if lt IE 9]>
	<script src="js/ie8-responsive-file-warning.js"></script>
<![endif]-->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
     <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath()%>/images/fav-144.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath()%>/images/fav-114.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath()%>/images/fav-72.png">
<link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath()%>/images/fav-57.png">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/fav.png">

<script>
jQuery(document).ready(function() {
        
	jQuery('.carousel[data-type="multi"] .item').each(function(){
		var next = jQuery(this).next();
		if (!next.length) {
			next = jQuery(this).siblings(':first');
		}
		next.children(':first-child').clone().appendTo(jQuery(this));
	  
		for (var i=0;i<2;i++) {
			next=next.next();
			if (!next.length) {
				next = jQuery(this).siblings(':first');
			}
			next.children(':first-child').clone().appendTo($(this));
		}
	});
        
});
</script>
<style>
	.carousel-control.left, .carousel-control.right {
		background-image:none;
	}
	
	@media (min-width: 992px ) {
		.carousel-inner .active.left {
			left: -25%;
		}
		.carousel-inner .next {
			left:  25%;
		}
		.carousel-inner .prev {
			left: -25%;
		}
	}
	
	@media (min-width: 768px) and (max-width: 991px ) {
		.carousel-inner .active.left {
			left: -33.3%;
		}
		.carousel-inner .next {
			left:  33.3%;
		}
		.carousel-inner .prev {
			left: -33.3%;
		}
		.active > div:first-child {
			display:block;
		}
		.active > div:first-child + div {
			display:block;
		}
		.active > div:last-child {
			display:none;
		}
	}
	
	@media (max-width: 767px) {
		.carousel-inner .active.left {
			left: -100%;
		}
		.carousel-inner .next {
			left:  100%;
		}
		.carousel-inner .prev {
			left: -100%;
		}
		.active > div {
			display:none;
		}
		.active > div:first-child {
			display:block;
		}
	}
</style>
