<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <title>修改密码</title>
    
    <link rel="stylesheet" href="../assets/js/jquery-3.3.1.min.js">
	<link rel="stylesheet" href="../assets/js/moment-with-locales.min.js">
 	<link rel="stylesheet" type="text/css" href="../student/css/example3.css">
    <link href="../student/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../student/css/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
	<link href="../student/css/style.css" rel="stylesheet">


<script src="../student/js/jquery.min.js"></script>
<script src="../student/js/bootstrap/js/bootstrap.min.js"></script>
<script src="../student/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
   
    <script>
   		function exit(){
			if(window.confirm("确认要退出吗？")){
				window.open('login.jsp','_top')
			}else{
				return false;
			}
        }
   </script>
   
   
</head>
<body>
<div  id="header" class="header">
<nav class="navbar navbar-default" style="display: flex;
                                      flex-direction:row;
                                      width: 1536px;
                                       margin:10px; border:1px;
                                       background-color: white">


    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="font-size:50px; font-weight:bold; margin-right: 10px;     margin-right: 200px;
    margin-left: 180px; color: #3073f2cc;">SQLGoGo</a>
    </div>       <!--大标题组件-->



 <div>
      <ul class="nav navbar-nav">



        <li class="active" style="font-size: 20px;margin-right: 20px;"><a href="/SQLgogo2/student/main.jsp">欢迎您，<%=session.getAttribute("realname")%></a></li>
		<li  style=" margin-right: 10px; font-size: 15px;"><a href="perInfo.jsp">个人主页</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="#">关于我们</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="help.jsp">帮助</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="changepwd.jsp">密码修改</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="javascript:void(0):" onclick="exit()">退出</a></li>



        <!-- <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Me   <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>    下拉列表组件组件 -->
      </ul>



     <!--  <ul class="nav navbar-nav " style="margin-left: 100px; ">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul> -->
     <!-- <ul class="nav navbar-nav">
      <li  style=" margin-left:30px; font-size: 15px;"><a href="#">Login</a></li>
     </ul> -->

    </div>
</nav>
</div>
<div>
	<div align="center">
	<font size="4">修改密码</font><br>
	</div>
	<hr>
	<br>
	
	<div margin:20dp >
    <form  action ="../PwdChange" method="post">
    	<span>请输入原密码:</span> <br>  
    	<input type = "password"  name ="oldpwd" >
    	<br/><br>
    	<span>请输入新密码:</span> <br>  
    	<input type = "password"  name ="newpwd" >
    	<br/><br>
    	<span>请再次输入新密码:</span><br>
    	<input type = "password"  name ="confirm" ><br><br>
    	<input  type = "submit" value = "确认" >
    	</form>
    </div>
  </div>
  </body>
</html>