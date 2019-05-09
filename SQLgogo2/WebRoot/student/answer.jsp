
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SQLgogo自动测评系统</title>

 <link rel="stylesheet" type="text/css" href="<%=path %>/student/css/example3.css">
    <link href="<%=path %>/student/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=path %>/student/css/bootstrap/css/bootstrap.min.css">

<!-- 连接layui  二个-->
<link rel="stylesheet" href="<%=path %>/student/css/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
<link href="<%=path %>/student/css/style.css" rel="stylesheet">

<script src="<%=path %>/student/js_page/homework/answer.js"></script>
<script src="<%=path %>/student/js/jquery-3.3.1.min.js"></script>
<script src="<%=path %>/student/js/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=path %>/student/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="<%=path %>/student/js/layui/layui.css"  media="all">
<script src="<%=path %>/student/js/layui/layui.js" charset="utf-8"></script>


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
<body onload="LoadData();">
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
		<li  style=" margin-right: 10px; font-size: 15px;"><a href="/SQLgogo2/student/perInfo.jsp">个人主页</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="#">关于我们</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="/SQLgogo2/student/help.jsp">帮助</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="/SQLgogo2/student/changepwd.jsp">密码修改</a></li>
        <li  style=" margin-right: 10px; font-size: 15px;"><a href="javascript:void(0):" onclick="exit()">退出</a></li>

      </ul>

    </div>
</nav>
</div>

<div id="main" class="container" style="background-color:#d9d7d74f;">
	&lt&lt<a href="javascript:history.back(-1)" style="color:black;text-decoration:underline;">返回 </a>
	<div class="row clearfix"></div>
	
	<input type="hidden" id="subjectid" value=<%=(String)request.getParameter("subjectid") %> />
	<input type="hidden" id="dbname" value=<%=(String)request.getParameter("dbname") %> />
	<input type="hidden"  id="mypraid" value=<%=(String)request.getParameter("mypraid") %> />
	<input type="hidden"  id="myclassid" value=<%=(String)request.getParameter("myclassid") %> />
	
	<br><br>
	
	<!-- 库的列表 -->
	<div class="col-md-4 column" >
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
    <li class="layui-nav-item"><a  id="dbna" href="javascript:;"><%=(String)request.getParameter("dbname") %></a>
  		<dl class="layui-nav-child" id="mydl">  	
  		</dl>
   	</li>
  
</ul>

  </div>
	
	<!-- 答题模块 -->
 <div  class="col-md-8 column">
	<div style="margin-left: 300px;">
		<font size="5">答题</font>
		
	</div>
	<br>	
	<div>   
		            过程得分：<input id="proscore" type="text" style="width:40px;" >
		           结果得分：<input id="resscore" type="text" style="width:40px;" >
		           总分：<input id="score" type="text" style="width:40px;">
		           <br><br>
			题目：<span id="question"></span>
			<br><br><br>
			代码：
			<textarea id="mycode" name="resultsql" style="width: 700px; height: 180px;readonly:true;"></textarea>
			<div style="margin-left: 350px;">
				<button id="confirm" class="btn btn-info" onclick="confirm()">提交</button>
			</div>
			
			<div>
				<font size="3">结果：</font>
				<textarea id="sqlresult" name="result" style="width: 700px; height: 100px;readonly:true;"></textarea>
			</div>
		
			
	</div>
	</div>
	
</div>
</body>

</html>
<script>
layui.use(['element','layer','jquery'], function(){
  	var element = layui.element, //导航的hover效果、二级菜单等功能，需要依赖element模块
   	$=layui.jquery;
   //监听导航点击
  element.on('nav(demo)', function(elem){
    //layer.msg();
    //如果导航信息不是数据库名
    
    if(elem.text() != $("#dbna").text())
    window.open('./table.jsp?tab='+elem.text()+'&db='+$("#dbna").text(),"_blank","resizable=yes,width=600,height=400");
 
   });     
       
  });
</script>