<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>医学图像收集与管理系统</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Rounded Flat User Login Form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="css/style_login.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>

		<div class="main">
			<h1>医学图像收集与管理系统</h1>
			<form action="${pageContext.request.contextPath }/login.action" method="post">
			<div class="input_form">
					<input name="account" type="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}" required="">
					<input name="password" type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
			</div>
			<div class="ckeck-bg">
				<div class="checkbox-form">
					<div class="check-left">

					</div>
					<div class="check-right" style="width: 100%;">
							<input type="submit" value="Login" style="width: 100%;">
					</div>
			</form>
					<div class="clearfix" style="text-align: center;margin-top: 1.5em;">
						<a href="${pageContext.request.contextPath }/toRegistUser.action">注册账号</a> | <a href="${pageContext.request.contextPath }/toFindUser.action">找回密码</a>
					 </div>
				</div>

		
			</div>
		</div>
		<div class="footer">
			<p>&copy; 2018. Medicine Picture Collection And Management System. </p>
		</div>

</body>
</html>