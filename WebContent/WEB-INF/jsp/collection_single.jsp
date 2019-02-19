<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html class="no-js">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>医学图像收集与管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link rel="shortcut icon" href="favicon.ico">
	<link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/icomoon.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/textarea.css">
	<script src="js/modernizr-2.6.2.min.js"></script>

	</head>
	<body>
	<div id="fh5co-offcanvas">
			<a class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i class="icon-cross3"></i> <span>Close</span></span></a>
			<div class="fh5co-bio">
				<a href="${pageContext.request.contextPath }/User.action">
				<figure>
					<img src="${user.head_src }" alt="Free HTML5 Bootstrap Template" class="img-responsive">
				</figure>
				<h3 class="heading"></h3>
				<h2>${user.name }</h2>
				<p>${user.signature }</p>
				</a>
			</div>
	
			<div class="fh5co-menu">
				<div class="fh5co-box">
					<h3 class="heading">导航</h3>
					<ul>
						<li><a href="${pageContext.request.contextPath }/main.action">首页</a></li>
					<c:if test="${user.permission == true}">
						<li><a href="${pageContext.request.contextPath }/question.action">医师认证</a></li>
					</c:if>
					<c:if test="${user.permission == false}">
						<li><a href="${pageContext.request.contextPath }/question.action">答疑解惑</a></li>
						<li><a href="${pageContext.request.contextPath }/collection.action">图片收藏</a></li>
						<li><a href="#">敬请期待</a></li>
					</c:if>
						<li><a href="${pageContext.request.contextPath }/logout.action">注销</a></li>
					</ul>
				</div>
				
			</div>
		</div>
	<!-- END #fh5co-offcanvas -->
	<header id="fh5co-header">
		
		<div class="container-fluid">

			<div class="row">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				<div class="col-lg-12 col-md-12 text-center">
					<h1 id="fh5co-logo"><a href="index.html">医学图像收集与管理系统</a></h1>
				</div>

			</div>
		
		</div>

	</header>
	<a href="#" class="fh5co-post-prev"><span><i class="icon-chevron-left"></i> Prev</span></a>
	<a href="#" class="fh5co-post-next"><span>Next <i class="icon-chevron-right"></i></span></a>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				<figure class="animate-box">
					<img src="images/single_1.jpg" alt="Image" class="img-responsive">
				</figure>
				<textarea id="ta" class="mytxt" style="width: 100%;height: 300px;">　1960年代的香港，因生母在阿飞旭仔（张国荣）长大成人过程中的缺失，他把自己优雅地比喻为“无根鸟”，对生命中遇到的每一个女人都表现得放荡不羁，售票员苏丽珍（张曼玉）和舞女咪咪（刘嘉玲）先后令他感受过温暖，可是她们也只能当当小情人。为摆脱沉重和无力感，旭仔抛下一切去南洋找寻生母。 
　　暗恋过苏丽珍且目睹过她与旭仔情感一路变化的，曾是小巡警今在跑船的超仔（刘德华）在菲律宾又遇到旭仔，是缘分也是宿命，他参与、见证了阿飞命运被改写的过程。</textarea>
				<span class="fh5co-meta animate-box"><a href="">提交备注</a></span>
				<h2 class="fh5co-article-title animate-box">图片信息</h2>
				<span class="fh5co-meta fh5co-date animate-box">于 四月 二十八日 二零一八年 收藏</span>
				
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
					
			</article>
		</div>
	</div>

		<p><small>&copy; 2018. Medicine Picture Collection And Management System. <br> </small></p>
	</footer>


	

	<script src="js/jquery.min.js"></script>

	<script src="js/jquery.easing.1.3.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/main.js"></script>
	</body>
</html>

