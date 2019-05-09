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
    <title>帮助</title>
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
<div style="position: absolute;left: 350px;top: 200px">
    <strong>联系我们</strong>
    <br/>
    <br/>
    <div style="font-size: 13px">
        北京城市学院软件创新大赛项目，SQLgogo自动评测系统！
        作者班级:16级软本2班
        <br/>
        预期成果:
        <br/>
        我们将开发一套学生作业自动测评网站，分为老师端和教师端两个网页，老师端 可以实现 <br/>
        1.教师端登录，练习发布功能 <br/>
        2.学生测评结果查询功能 <br/>
        3.题库的上传，维护功能 <br/>
        4.学生登录操作网页的信息记录日志功能 <br/>
        5.系统模块个人主页，帮助， <br/>
        6.教师，学生互相问答 <br/>
        关于，退出等。 <br/>
        学生端可以实现: <br/>
        1.学生端登入 <br/>
        2.学生练习结果 上传，自动测评 <br/>
        3.下载题库 <br/>
        4.学生，教师互相问答 <br/>
        <BR/>
应用情况:
        <BR/>
        应用于全国各大高校，提高数据库老师的教学效率和学生的学习效率，使得老师 <br/>
        不必花大部分精力在作业批改上面， 转而把更多精力投入到研究备课，和与学生 <br/>
        的交 流当中，提高师生的学习时间利用率。 学生可以通过此平台更加方便的学习， <br/>
        不懂的 问题可以通过在线答疑得到及时有效的解决， 通过各种优秀作业可以学习到 <br/>
        各种不同 的思路，拓展学生思维。而且此应用面向全国学习此课程的学生，面对面很广。 <br/>
    </div>
    <br/>
    <div style="font-size: 13px">请通过以下方式联系我们：）</div>
    <br>

    <div style="font-size: 13px">wechat:18210915622</div>
    <br/>
    <div style="font-size: 13px">违法和不良信息举报：010-82716601</div>

    <br/>

</div>
</body>
</html>
