<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<link rel="stylesheet" href="css/style_User.css">
	<link rel="stylesheet" href="css/User.css">
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
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				<figure class="animate-box">
					<!-- <img src="images/test1.jpg" alt="Image" class="img-responsive"> -->
				</figure>
				<h2 class="fh5co-article-title animate-box">${user.name }的主页</h2>
				<span class="fh5co-meta animate-box">于 ${user.dateS }注册</span>
				<div  id="head_img" style="padding-bottom: 20px;">
				<span class="fh5co-meta fh5co-date animate-box"><img class="head_img" src="${user.head_src }"></span>
					<input id="HeadFileSrc" type="file" name="" style="display: none;"></span>
				</div>
				</div>
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
					<div class="row">
							<div id="UserName" class="fh5co-highlight right" style="text-align: center;border: none;">
								<div style="display: inline;">用户名:</div><input id="UserName" type="text" value="${user.name }" style="    width: 13.7em;
										    margin: 0 auto;
										    padding-top: 15px;
										    background: 0;
										    border: 0;
										    border-bottom: 1px solid #000;
										    color: #000;
										    outline: 0;
										    text-align: center;
										    transition: border-color .2s ease;
										        font-size: 100%;
  											line-height: 100%;"	readonly="readonly">
  								<div id="UserNameChange" class="changeModify" onclick="editUserName()"><svg viewBox="0 0 12 12" class="Icon ModifyButton-icon Icon--modify" width="12" height="16" aria-hidden="true" style="height: 16px; width: 12px;"><title></title><g><path d="M.423 10.32L0 12l1.667-.474 1.55-.44-2.4-2.33-.394 1.564zM10.153.233c-.327-.318-.85-.31-1.17.018l-.793.817 2.49 2.414.792-.814c.318-.328.312-.852-.017-1.17l-1.3-1.263zM3.84 10.536L1.35 8.122l6.265-6.46 2.49 2.414-6.265 6.46z" fill-rule="evenodd"></path></g></svg>修改</div>
							</div>
							<div id="Sginature" class="fh5co-highlight right" style="text-align: center;border: none;">
								<div style="display: inline;">个性签名:</div><input id="UserSignature" type="text" value="${user.signature }" style="    width: 13.7em;
										    margin: 0 auto;
										    padding-top: 15px;
										    background: 0;
										    border: 0;
										    border-bottom: 1px solid #000;
										    color: #000;
										    outline: 0;
										    text-align: center;
										    transition: border-color .2s ease;
										        font-size: 100%;
  											line-height: 100%;"	readonly="readonly"	>
  							<div id="SignatureChange" class="changeModify" onclick="editSignature()"><svg viewBox="0 0 12 12" class="Icon ModifyButton-icon Icon--modify" width="12" height="16" aria-hidden="true" style="height: 16px; width: 12px;"><title></title><g><path d="M.423 10.32L0 12l1.667-.474 1.55-.44-2.4-2.33-.394 1.564zM10.153.233c-.327-.318-.85-.31-1.17.018l-.793.817 2.49 2.414.792-.814c.318-.328.312-.852-.017-1.17l-1.3-1.263zM3.84 10.536L1.35 8.122l6.265-6.46 2.49 2.414-6.265 6.46z" fill-rule="evenodd"></path></g></svg>修改</div>
							</div>

				</div>
			</article>
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
		$("#UserName").hover(function(){
			$("#UserNameChange").removeClass("changeModify");
			$("#UserNameChange").addClass("hover");
		},function(){
			$("#UserNameChange").removeClass("hover");
			$("#UserNameChange").addClass("changeModify");
		})
		$("#Sginature").hover(function(){
			$("#SignatureChange").removeClass("changeModify");
			$("#SignatureChange").addClass("hover");
		},function(){
			$("#SignatureChange").removeClass("hover");
			$("#SignatureChange").addClass("changeModify");
		})
		$("#head_img").hover(function(){
			$("#head_imgModify a").removeClass("changeModify");
			$("#head_imgModify a").addClass("hover");
		},function(){
			$("#head_imgModify a").removeClass("hover");
			$("#head_imgModify a").addClass("changeModify");
		})
		function editUserName(){
			var UserName = prompt("请输入您的昵称：","");
			$.ajax({
				url:"${pageContext.request.contextPath}/changeUserName.action",
				type:"post",
				data:JSON.stringify({
					name : UserName
				}),
				contentType : "application/json;charset=UTF-8",
				success:function(ReturnData){
					if (ReturnData=="OK"){
						window.location.href = '${pageContext.request.contextPath}/User.action';
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){  
              alert("操作失败" + XMLHttpRequest.readyState + "\n" +  XMLHttpRequest.status + "\n" +  XMLHttpRequest.responseText);
          }   
			});
			
		}
		function editSignature(){
			var Signature = prompt("请输入您的签名：","");
			$.ajax({
				url:"${pageContext.request.contextPath}/changeUserSignature.action",
				type:"post",
				data:JSON.stringify({
					signature : Signature
				}),
				contentType : "application/json;charset=UTF-8",
				success:function(ReturnData){
					if (ReturnData=="OK"){
						window.location.href = '${pageContext.request.contextPath}/User.action';
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){  
              alert("操作失败" + XMLHttpRequest.readyState + "\n" +  XMLHttpRequest.status + "\n" +  XMLHttpRequest.responseText);
          }   
			});
		}
		function headFile(){
			return $("#HeadFileSrc").click();
		}
	</script>

	</body>
</html>