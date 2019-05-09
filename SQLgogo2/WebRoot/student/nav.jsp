<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
%>

<!DOCTYPE>
<html>
 <head>
 <script src="./js/nav.js"></script>
 <script src="../student/js/jquery-3.3.1.min.js"></script>
 </head>
  <body>
<div  id="header" class="header">
<nav class="navbar navbar-default" style="display: flex;
                                      flex-direction:row;                                
                                       margin:10px; border:1px;
                                       background-color: white">
    <div class="navbar-header">
      <a class="navbar-brand" href="main.jsp" style="font-size:50px; font-weight:bold; margin-right: 10px;     margin-right: 200px;
    margin-left: 180px; color: #3073f2cc;">SQLGoGo</a>
    </div>       <!--大标题组件-->

 <div style="position: relative;left: 22%;">
      <ul class="nav navbar-nav">
        <li class="active" style="font-size: 20px;margin-right: 20px;">

		<li  style=" margin-right: 10px; font-size: 15px;"><a href="perInfo.jsp">个人主页</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="#">关于我们</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="help.jsp">帮助</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="#">密码修改</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="javascript:void(0):" onclick="exit()">退出</a></li>    
      </ul>
      <a href="perInfo.jsp"><img class="img-circle" id="nav_user_photo" src="" style="width:50px; height: 50px;"> </a>
    </div>
</nav>
</div>
  </body>
</html>
