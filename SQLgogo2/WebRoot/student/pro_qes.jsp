<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SQLgogo-Student</title>
 	<link rel="stylesheet" type="text/css" href="../student/css/example3.css">
    <link href="../student/css/style.css" rel="stylesheet">
    <link href="../student/js_page/pro_qes/pro_qes.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="layui-v2.4.3/layui-v2.4.3/layui/css/layui.css" media="screen">
    
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">
    <script src="../student/js/jquery-3.3.1.min.js"></script>
    
      <script src="../student/js_page/pro_qes/pro_qes.js"></script>
    <script src="../student/js/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layui-v2.4.3/layui-v2.4.3/layui/layui.all.js"></script>
</head>
<body  onload="load()">

<jsp:include page="./nav.jsp"></jsp:include>

	<div class="container-fluid main">
		<div id="contain" style="display:flex; flex-direction: column;justify-content: center;">
			<p style="font-size: 30px;font-weight: bold;color:#767070">向老师提问</p>

			<div>
				<p>1.问题名称：</p>
				<input class="form-control" aria-describedby="basic-addon1"
					style="width: 300px;" id="sub_name" type="text" placeholder="给问题加个标题">
			</div>

			<div id="prac_protray"
				style="display:flex;flex-dirction:row; margin-top:20px;">
				<div>
					<p>2.问题描述</p>
					<textarea id="textarea" class="form-control" rows="3" cols=""
						
						style="width: 500px;height: 164px;" placeholder="描述一下你的问题"></textarea>
				</div>
			</div>
			<div id="prac_class" style="margin-top:20px;">
				<button type="button" id="submit" class="btn btn-default"
					style="margin-left: 450px;background-color: #1e88e5;color: white;" onclick="submit()">提交</button>
			</div>
		  </div>
		</div>
</body>
</html>
