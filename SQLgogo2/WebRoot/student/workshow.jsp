
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SQLgogo自动评测系统</title>
 
	 <%-- <link rel="stylesheet" href="<%=path %>/student/js/moment-with-locales.min.js"> --%>
     <link rel="stylesheet" type="text/css" href="<%=path %>/student/js_page/homework/workshow.css">
	 <link rel="stylesheet" type="text/css" href="<%=path %>/student/css/bootstrap/css/bootstrap.min.css">

	<script type="text/javascript" src="<%=path %>/student/js_page/homework/workshow.js"></script>
	<link rel="stylesheet" href="<%=path %>/student/js/layui/layui.css"  media="all">
	<script src="<%=path %>/student/js/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="<%=path %>/student/js/jquery-3.3.1.min.js"></script>
	<%-- <script type="text/javascript" src="<%=path %>/student/jquerypage/js/zxf_page.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/student/jquerypage/css/zxf_page.css"/>
 --%>
</head>
<body onload="LoadData();">
<jsp:include page="./nav.jsp"></jsp:include>
<div id="main" style="background-color:#d9d7d74f;">
	&lt&lt<a href="javascript:history.back(-1)" style="color:black;text-decoration:underline;">返回 </a>
    <br><br>
	<div align="center">
		<font size="5">查看练习</font>
		<hr>
	</div>
	
	<input type="hidden"  id="mydbname" value=<%=(String)request.getParameter("dbname") %> />
	<input type="hidden"  id="mypraid" value=<%=(String)request.getParameter("praid") %> />
	<input type="hidden"  id="myclassid" value=<%=(String)request.getParameter("classid") %> />
	
	<table class="layui-table" id="table">
       <thead>
	      <tr>
	         <td >序号</td>
	         <td><div class="wrap">题目</div></td>
	         <td>总分</td>
	         <td>代码分数</td>
	         <td>结果分数</td>
	             
	         <td style="padding-left: 55px;">操作</td>
	      </tr>
       </thead>
       <tbody id="mytbody">
       </tbody>
     </table>
      <!-- 分页 -->
	<div class="zxf_pagediv"></div>

	<input type="hidden" id="mytotalPage">	
</div>
</body>
<style>
	.wrap{
		overflow: hidden;
        -o-text-overflow: ellipsis;
        text-overflow: ellipsis;
        width:240px; 
        white-space:nowrap;display:block;
	}
</style>
</html>