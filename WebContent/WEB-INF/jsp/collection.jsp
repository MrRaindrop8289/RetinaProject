<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry">
			<c:forEach items="${collectionPicture }" var="p">
				
			<article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
				<figure>
					<a><img src="${p.src_image }" alt="Image" class="img-responsive"></a>
				</figure>
				<span class="fh5co-meta"><a name="${p.id }" onclick="collection(this)" style="cursor: pointer;">取消收藏</a></span>
				<h2 class="fh5co-article-title"><a href="${pageContext.request.contextPath }/collection.action?id=${p.id}">收藏时间</a></h2>
				<span class="fh5co-meta fh5co-date">${p.dateS }</span>
			</article>
			
			</c:forEach>
		</div>
	</div>

	<footer id="fh5co-footer">
		<p><small>&copy; 2018. Medicine Picture Collection And Management System. <br> </small></p>
	</footer>


	

	<script src="js/jquery.min.js"></script>

	<script src="js/jquery.easing.1.3.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/main.js"></script>
	<script type="text/javascript">
		function add(){
			$("#addPicture").click();
		}
		function Submit(){
			var formData = new FormData();
			formData.append("Picture",$("#addPicture")[0].files[0]);
			$.ajax({
				url:'${pageContext.request.contextPath}/AddPicture.action',
				type:'post',
				data:formData,
				processData:false,
				contentType:false,
				success:function(data){
					alert(data);
				},
		        error: function(XMLHttpRequest, textStatus, errorThrown){  
		            alert("提交失败" + "\nreadystatus:"+  XMLHttpRequest.readyState + "\nstatus:"+ XMLHttpRequest.status + "\nresponse:"+  + XMLHttpRequest.responseText);
		        }
			});
		}
		function collection(data){
			var pictureid = data.name;
			if (data.innerHTML == "收藏"){
				$.ajax({
					url:"${pageContext.request.contextPath}/AddCollection.action",
					type:"post",
					data:JSON.stringify({
						id : pictureid
					}),
					contentType : "application/json;charset=UTF-8",
					success:function(ReturnData){
						if (ReturnData=="OK"){
							data.innerHTML="取消收藏";
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){  
	              alert("收藏失败" + XMLHttpRequest.readyState + "\n" +  XMLHttpRequest.status + "\n" +  XMLHttpRequest.responseText);
	          }  
				});
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/RemoveCollection.action",
					type:"post",
					dataType:"json",
					data:JSON.stringify({
						id:id
					}),
					contentType : "application/json;charset=UTF-8",
					success:function(ReturnData){
						if (ReturnData=="OK"){
							data.innerHTML="收藏";
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown){  
	              alert("取消收藏失败" + XMLHttpRequest.readyState + "\n" +  XMLHttpRequest.status + "\n" +  XMLHttpRequest.responseText);
	          }  
				});
			}
			
		}
	</script>
	</body>
</html>

