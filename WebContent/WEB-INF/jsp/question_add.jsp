<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				<figure class="animate-box">
					<!-- <img src="images/test1.jpg" alt="Image" class="img-responsive"> -->
				</figure>
				<input id="questionTitle" type="text" value="题目"  onfocus="if(this.value == '题目'){this.value = '';}" onblur="if (this.value == '') {this.value = '题目';}" style="    width: 13.7em;
										    margin: 0 auto;
										    padding-top: 15px;
										    display: block;
										    background: 0;
										    border: 0;
										    border-bottom: 1px solid #FFF;
										    color: #000;
										    font-weight: 500;
										    outline: 0;
										    text-align: center;
										    transition: border-color .2s ease;
										        font-size: 120%;
  											line-height: 120%;"	>
				<span class="fh5co-meta animate-box">${user.name }</span>
				<span class="fh5co-meta fh5co-date animate-box"></span>
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article" style="
				    padding-top: 36px;
				">
					<div class="row">
						
							<div class="fh5co-highlight right">
								<h4 style="
									    text-align: center;
									    line-height: inherit;
									    margin-bottom: 0px;
									    margin-top: 0px;
									">问题描述</h4>
								<!--  oninput="this.style.height = this.scrollHeight+'px'" -->
								<textarea id="questionContent" class="mytxt" style="width: 100%;height: 300px;"></textarea>
								
								<span class="fh5co-meta animate-box fadeInUp animated" style="text-align: center;"><a href="" style=" text-decoration: none;" onclick="return submit()">提交问题</a></span>
							</div>
					

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
    function submit(){
        var title = $("#questionTitle").val();
        var content = $("#questionContent").val();
        console.log(title);
        console.log(content);
    	$.ajax({
    		url:"${pageContext.request.contextPath}/addQuestion.action",
    		type:"post",
            async : false,
    		data:JSON.stringify({
    			question:title,
    			content:content
    		}),
    		contentType:"application/json;charset=UTF-8",
    		dataType:"json",
    		success:function(data){
    			console.log(data);
    			if (data.type == 'same'){
    				alert("已存在相应问题:" + data.questionid);
    			}else if (data != null){
    				alert("已添加:" + data.questionid);
    			}
				window.location.href="${pageContext.request.contextPath}/questionSingle.action?id="+data.questionid;
    		},
    		error:function (XMLHttpRequest, textStatus,errorThrown){
    			alert("Error" +  + XMLHttpRequest.readyState +"  " +  XMLHttpRequest.status);
    		}
    			
    			
    	})
    	
    	return false;
    }



    </script>

	</body>
</html>

