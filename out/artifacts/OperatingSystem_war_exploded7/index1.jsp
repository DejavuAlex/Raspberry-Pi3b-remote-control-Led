<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Invest corporate category Bootstrap Responsive website Template | Home :: w3layouts</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Invest Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Custom Theme files -->
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<!-- //Custom Theme files -->
	<!-- js -->
	<script src="js/jquery-2.2.3.min.js"></script>
	<!-- //js -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Questrial" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Jacques+Francois+Shadow" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<!-- banner -->
<div class="banner-w3layouts">
		<div class="flexslider">
			<ul class="slides">
				<li>
					<div class="banner-w3text banner-img4">
					  <input type="radio" name="radio" id="radio" value="radio">
					  <label for="radio">key Button </label>
					  <h4> <em class="fa fa-free-code-camp" aria-hidden="true"></em> <span>移动</span>端照明控制系统</h4>
					  <h5> 
							<span></span>2018-2019冬季学期
							<span></span></h5>
				  </div>
				</li>
				<li>
					<div class="banner-w3text banner-img2">
					  <h4> <em class="fa fa-free-code-camp" aria-hidden="true"></em> <span>组长：</span>杨松洁</h4>
					  <h5>
							<span></span>组员：
							<span></span>赵思诚 陈国捷 周敬敬 谭策晖</h5>
					</div>
				</li>
			</ul>
		</div>
		<!-- FlexSlider -->
		<script defer src="js/jquery.flexslider.js"></script>
		<script>
			$(window).load(function () {
				$('.flexslider').flexslider({
					animation: "slide",
					start: function (slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
		<!-- //FlexSlider -->
		<!-- banner-info -->
		<div class="banner-agileinfo">
			<div class="container">
				<div class="w3header">
					<!--header-->
					<nav class="navbar navbar-default">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<h1>
								<a href="index.html">
									<span>p</span>roject</a>
							</h1>
						</div>
						<!-- navbar-header -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						  <ul class="nav navbar-nav navbar-right">
								<li>
									
									<a href="about.html">About</a>
								</li>
								<li>
									<a href="index.html" class="active">us</a>
								</li>
								<li>
<ul class="dropdown-menu">
					<li>
											<a href="icons.html">Web Icons</a>
				  </li>
										<li>
											<a href="typography.html">Typography</a>
										</li>
								  </ul>
						    </li>
								<li> </li>
								<li> </li>
						  </ul>
						  <div class="clearfix"> </div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- about -->
<div class="col-md-6 w3_agileits-ab-main">
  <div class="about-inner">
	<h3 class="agileits-title">
							<span>about project</span>
	  </h3>
						<p class="about-text-w3l">本课程项目基于web已有框架Spring+SpringMVC+Mybatis， 根据移动端发送的操作信息，上传到web服务器，服务器根据TCP协议分发请求至保持有连接的树莓派上，之后树莓派控制照明模块完成对照明二极管的控制</p>
					</div>
				</div>
<!-- about-slid -->

<!-- //about-slid -->
	<!--services section starts here-->

<!--//services section ends here-->
	<!-- //about -->
	<!-- team -->

<!-- //team -->
<!-- footer -->

<!-- //footer -->
	<!-- Tooltip -->
	<div class="tooltip-content">
		<div class="modal fade features-modal" id="myModal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Invest</h4>
					</div>
					<div class="modal-body">
						<img src="images/1.jpg" class="img-responsive" alt="image">
						<p>Fusce et congue nibh, ut ullamcorper magna. Donec ac massa tincidunt, fringilla sapien vel, tempus massa. Vestibulum
							felis leo, tincidunt sit amet tristique accumsan. In vitae dapibus metus. Donec nec massa non nulla mattis aliquam
							egestas et mi.</p>
					</div>
				</div>
			</div>
		</div>
</div>
	<!-- //Tooltip -->
	<!-- start-smooth-scrolling -->
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<script>
		jQuery(document).ready(function ($) {
			$(".scroll").click(function (event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop: $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->

	<!-- smooth-scrolling-of-move-up -->
	<script>
		$(document).ready(function () {
			/*
			   var defaults = {
				   containerID: 'toTop', // fading element id
				   containerHoverID: 'toTopHover', // fading element hover id
				   scrollSpeed: 1200,
				   easingType: 'linear' 
			   };
			   */

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>

	<script src="js/SmoothScroll.min.js"></script>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/bootstrap.js"></script>
</body>

</html>