<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
     <link rel="stylesheet" type="text/css"
	href="layui-v2.4.3/layui-v2.4.3/layui/css/layui.css" media="screen">
    <link rel="stylesheet" type="text/css" href="./css/example3.css">
    <link rel="stylesheet" type="text/css" href="./js_page/login/login.css">
    <link href="../student/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">

    <link href="../student/css/style.css" rel="stylesheet">
  
<script src="../student/js/bootstrap/js/bootstrap.min.js"></script>  
<script src="./js_page/login/login.js"></script>
<script type="text/javascript" src="layui-v2.4.3/layui-v2.4.3/layui/layui.all.js"></script>
</head>

<body onload="">
<jsp:include page="./nav.jsp"></jsp:include>
<div id="main" style="display: flex; flex-direction: column; align-items: center;background-color: #d9d7d74f;">
	<div id="login" style="display: flex;flex-direction: column;">
			<div  class="title1">One  for Enormous</div>
			<div class="title2">Drill Whereever,Accompany Whenever</div>
    <div id="login_part" class="login_part">
    	<div style="font-size: 20px;margin-top: 10px;">Login</div>
    	<div style="border:0.5px solid #d9d7d74f;width: 415px;height: 0px;margin-top: 10px;"></div>
    	<div id="login_user_name" class="login_user">
  			<input type="text" id="username" name="username" class="form-control" style="width: 300px;" placeholder="请输入用户名" aria-describedby="basic-addon1">
    	</div>
		  <div id="login_user_pws" class="login_user">
  			<input type="password" id="pwd" name="password" class="form-control" style="width: 300px;" placeholder="请输入密码" aria-describedby="basic-addon1">
    	</div>
     	<button type="submit" class="btn btn-default" style="width: 300px;
       	margin-top: 20px;background-color: #1b8dde;color: white;margin-bottom: 30px" onclick="confirm()">Login Now</button>
    </div>

</div>

<div id="end" class="end">
  <div id="about" class="end_msg" >
   <img src="../student/picture/about.png">
   <p>About Us</p>
  </div>
  <div id="help" class="end_msg" >
   <img src="../student/picture/help.png">
   <p style="padding-right: 6px;">Help</p>
  </div>
  <div style="border: 0.5px solid #c5c5c5;margin-left:140px;height: 101px;margin-top: 25px;">  </div>
  <div class="end_sentence">
    <p>We are witness</p>
    <p>It is the best time</p>
    <p>Strive for greatness</p>
    <p>For everyone who is looking the passage</p>
  </div>
</div>

</div>
</body>

</html>
