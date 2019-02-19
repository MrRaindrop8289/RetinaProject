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
					<h1 id="fh5co-logo"><a href="${pageContext.request.contextPath }/main.action">医学图像收集与管理系统</a></h1>
				</div>

			</div>
		
		</div>

	</header>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
				<figure class="animate-box">
					<canvas id="canvas" width="1119px" height="751px"style="
          			background-image: url(${img.src_image});
          			background-size: 100% 100%;
					display: block;
				    vertical-align: middle;
				    border: 0;
					"></canvas>
					<!-- <img src="images/single_1.jpg" alt="Image" class="img-responsive"> -->
				</figure>
				<c:if test="${user.grade != 3}">
					<span class="fh5co-meta animate-box"><a onclick="sumbitAxis()" style="cursor: pointer;">提交数据</a>||<a onclick="clearCanvas()" style="cursor: pointer;">清除标注</a></span>
				</c:if>
				
<!--			C:if出现问题
				<c:if test="${user.grade == 3}">
					<span class="fh5co-meta animate-box"><a onclick="sumbitAxisStudents()" style="cursor: pointer;">提交数据</a>||<a onclick="clearCanvas()" style="cursor: pointer;">清除标注</a></span>
				</c:if>
  -->
				<h2 class="fh5co-article-title animate-box">图片信息来源</h2>
				<span class="fh5co-meta fh5co-date animate-box">${img.dateS }</span>
				<div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">

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
    var canvas = document.getElementById("canvas");
    var context = canvas.getContext("2d");
    var x = -1.0;
    var y = -1.0;
    
    function getLocation(x, y) {
      var bbox = canvas.getBoundingClientRect();
      return {
        x: (x - bbox.left) * (canvas.width / bbox.width),
        y: (y - bbox.top) * (canvas.height / bbox.height)
      };
    }
    canvas.onmousedown = function (e) { 
      canvas.height = canvas.height;  
      var location = getLocation(e.clientX, e.clientY);
      x = location.x;
      y = location.y;
      context.strokeStyle = "#ffffff"; //改变画笔颜色
      context.lineWidth = 1;
      context.arc(location.x,location.y,100,0,2*Math.PI);
      context.stroke();
    };
    function clearCanvas()
    {  
        var c=document.getElementById("canvas");  
        var cxt=c.getContext("2d");  
        x = -1.0;
        y = -1.0;
        c.height=c.height;  
    }  
    function sumbitAxis(){
        var axisX = x;
        var axisY = y;
        var tempform = document.createElement("form");
        tempform.action = "${pageContext.request.contextPath}/sumbitAxis.action";
        tempform.method = "post";
        tempform.style.display="none";
        
        var opt_x = document.createElement("input");
        opt_x.name = "pointx";
        opt_x.value = axisX;
        tempform.appendChild(opt_x);
        var opt_y = document.createElement("input");
        opt_y.name = "pointy";
        opt_y.value = axisY;
        tempform.appendChild(opt_y);
        var opt = document.createElement("input");
        opt.type = "submit";
        tempform.appendChild(opt);
        document.body.appendChild(tempform);
        tempform.submit();
        document.body.removeChild(tempform);
      }
    function sumbitAxisStudents(){
        var axisX = x;
        var axisY = y;
        
        $.ajax({
			url:"${pageContext.request.contextPath}/sumbitAxisStudnets.action",
			type:"post",
			dataType:"json",
			data:JSON.stringify({
				pointx:axisX,
				pointy:axisY
			}),
			contentType : "application/json;charset=UTF-8",
			dataType:"json",
			success:function(ReturnData){
				alert(ReturnData);
				alert("该图片由三位医生标注过，分别为红黄蓝三个圆圈，您的标注位置为白圈");
			    context.strokeStyle = "#FF0000"; //红色
				context.arc(ReturnData.x1,ReturnData.y1,100,0,2*Math.PI);
			    context.strokeStyle = "#FFFF00"; //黄色
				context.arc(ReturnData.x1,ReturnData.y1,100,0,2*Math.PI);
			    context.strokeStyle = "#0000FF"; //蓝色
				context.arc(ReturnData.x1,ReturnData.y1,100,0,2*Math.PI);
			    context.strokeStyle = "#ffffff"; //改变画笔颜色
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){  
          alert("数据发送失败" + XMLHttpRequest.readyState + "\n" +  XMLHttpRequest.status + "\n" +  XMLHttpRequest.responseText);
      }
      });
    }
    </script>

	</body>
</html>

