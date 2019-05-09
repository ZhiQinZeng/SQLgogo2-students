<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
	 <link href="./css/style.css" rel="stylesheet">
    <link href="./js_page/my_qes/my_qes.css" rel="stylesheet">
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">
    <script src="../student/js/jquery-3.3.1.min.js"></script>
    <script src="./js_page/my_qes/my_qes.js"></script>
    <script src="../student/js/bootstrap/js/bootstrap.min.js"></script>

  </head>
  
  <body onload="load(),load_main()">
   
<jsp:include page="./nav.jsp"></jsp:include>

<div id="main" style="background-color:#d9d7d74f;height: 80%;    padding-left: 296px;">
<div class="my_qes">
<p style="    margin-bottom: 0px;    font-size: 40px;font-family: fantasy;color: #5d5d5d;">我的提问</p>
<a href="javascript:history.back(-1)" style="color:black;text-decoration:none;"><button type="button" class="btn btn-default" style="    background-color: #ffb22b;
    outline: none;
    width: 175px;
    margin-left: 37px;
    color: white;
    margin-right: 79px;
   ">返回</button> </a>
    </div>
<div id="qes" class="qes">
   <div class="qes_part">
    

  
   </div>
  </div>
</div>
  </body>
</html>
