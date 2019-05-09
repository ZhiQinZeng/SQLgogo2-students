
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
   
	<link rel="stylesheet" href="../student/js/moment-with-locales.min.js">
	
 <link rel="stylesheet" type="text/css" href="../student/js_page/homework/homework.css">
	 <link rel="stylesheet" type="text/css" href="../student/css/bootstrap/css/bootstrap.min.css">

<script type="text/javascript" src="../student/js_page/homework/homework.js"></script>

<link rel="stylesheet" href="../student/js/layui/layui.css"  media="all">
<script src="../student/js/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/student/js/jquery-3.3.1.min.js"></script>
 <script type="text/javascript" src="../student/jquerypage/js/zxf_page.js"></script>
 <link rel="stylesheet" type="text/css" href="../student/jquerypage/css/zxf_page.css"/>


</head>
<body onload="load(),loadData();">

<jsp:include page="./nav.jsp"></jsp:include>
<div id="main" class="main" style="background-color:#d9d7d74f;">
	
    <br><br>
	<div align="center">
		<font size="5">查看题库</font>
		
	</div>
	
	<table class="layui-table" id="table">
       <thead>
	      <tr>
	         <td >序号</td>
	         <td>作业名称</td>
	         <td>操作库名</td>
	         <td>发布时间</td>
	         <td>截止时间</td>	         
	         <td style="padding-left: 55px;">操作</td>
	      </tr>
       </thead>
       <tbody id="mytbody">
       </tbody>
     </table>
      <!-- 分页 -->
	<div class="zxf_pagediv"></div>

	<input type="hidden" id="mytotalPage">
	<a href="javascript:history.back(-1)" style="color:black;text-decoration:none;"><button type="button" class="btn btn-default" style="background-color: #ffb22b;float:right;outline:none;width: 175px;color:white;">返回</button> </a>
</div>
</body>
</html>
