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

<script src="js/jquery.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/main.js"></script>
<link href="css/style_regist.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
</head>
<body>

		<div class="main">
			<h1>医学图像收集与管理系统</h1>
			<form onsubmit ="return true">
			<div class="input_form">
					<input id="account" type="text" value="邮箱" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '邮箱';}" required="">
					<select id="question" type="text" value="密保问题" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '密保问题';}" required="" style="margin-top: 1.5em;outline: none;border: 1px solid #999;background: none;border-radius: 25px;-webkit-border-radius: 100px;-moz-border-radius: 25px;-o-border-radius: 25px;-ms-border-radius: 25px;padding: 15px 10px;width: 100%;font-size: 1em;color: #999;text-align: center;font-family: 'Raleway', sans-serif;">
						<option value="0">密保问题</option>
						<option value="1">小学就读于哪里？</option>
						<option value="2">初中就读于哪里？</option>
						<option value="3">高中就读于哪里？</option>
						<option value="4">大学就读于哪里？</option>
						<option value="5">我的第一辆车是什么？</option>
						<option value="6">我的初恋是谁？</option>
						<option value="7">我是男是女？</option>
					</select>
					<input id="answer" type="text" value="密保回答" onfocus="this.value = '';this.type = 'text';" onblur="if (this.value == '') {this.type = 'text';this.value = '密保回答';}" required=""  style="margin-top: 1.5em;">
			</div>
			<div class="ckeck-bg">
				<div class="checkbox-form">
					<div class="check-left">

					</div>
					<div class="check-right" style="width: 100%;">
							<input type="submit" value="找回密码" style="width: 100%;" onclick="findUser()">
					</div>
					<div class="clearfix" style="text-align: center;margin-top: 1.5em;">
						<a href="${pageContext.request.contextPath }/toRegistUser.action">注册账号</a> | <a href="${pageContext.request.contextPath }/toLogin.action">登 陆</a>
					 </div>
				</div>

				</form>
			</div>
		</div>
		<div class="footer">
			<p>&copy; 2018. Medicine Picture Collection And Management System. </p>
		</div>
 <script type="text/javascript">
      $(window).on('load', function() {
          $('.myplusgallery').plusGallery();
      });
      function findUser(){
          var account = $("#account").val();
          var question = $("#question").val();
          var answer = $("#answer").val();
        
          
          $.ajax({
            url: "${pageContext.request.contextPath}/findUser.action",
            type: "post",
            async : false,
            data: JSON.stringify({
              account : account,
              question : question,
              answer : answer}),
            contentType : "application/json;charset=UTF-8",
            dataType : "json",
            success : function(data){
            if(data == 'NoUser'){
                alert("无此用户");
            }else if(data != null){
                alert("密码为：" + data);
                window.location.href = '${pageContext.request.contextPath}/index.jsp';
             }else{
                 alert("信息错误");
             }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){  
                alert("找回失败" + XMLHttpRequest.readyState + XMLHttpRequest.status + XMLHttpRequest.responseText);
            }  
          })
        }
      function check(){
          var account = $("#account").val();
          var password = $("#password").val();
          if(account == "" || password == ""){
            alert("账号密码不能为空");
            return false;
          }
          
          return true;
      }
     </script>
</body>
</html>