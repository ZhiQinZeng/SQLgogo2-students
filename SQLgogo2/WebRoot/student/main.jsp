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
    <link href="./css/style.css" rel="stylesheet">
    <link href="./js_page/main/main.css" rel="stylesheet">
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">
    <script src="../student/js/jquery-3.3.1.min.js"></script>
    <script src="./js_page/main/main.js"></script>
    <script src="../student/js/bootstrap/js/bootstrap.min.js"></script>
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
<body onload="load(),load_main()">

<jsp:include page="./nav.jsp"></jsp:include>
<div id="main" style="background-color:#d9d7d74f;">
   
<div id="pics" style="display: flex;justify-content: center;align-content: center; ">
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="height: 250px;width: 1200px;margin: 20px; ">
   <!-- Indicators -->
   <ol class="carousel-indicators" style="    margin-bottom: -20px;">
       <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
       <li data-target="#carousel-example-generic" data-slide-to="1"></li>
       <li data-target="#carousel-example-generic" data-slide-to="2"></li>
   </ol>
   <!-- Wrapper for slides -->
   <div class="carousel-inner" role="listbox" style="border-radius: 5px;">
       <div class="item active">
           <img src="../student/picture/slide_1.jpg" style="height: 250px;">
           <div class="carousel-caption">
               <h1>CarouselOne Topic</h1>
               <p>First Introduce</p>
           </div>
       </div>
       <div class="item">
           <img src="../student/picture/slide_2.jpg"  style="height: 250px;">
           <div class="carousel-caption">
               <h1>CarouselTwo Topic</h1>
               <p>Second Introduce</p>
           </div>
       </div>
       <div class="item">
          <img src="../student/picture/slide_3.jpg" style="height: 250px;">
           <div class="carousel-caption">
               <h1>CarouselThree Topic</h1>
               <p>Third Introduce</p>
           </div>
       </div>
   </div>
   <!-- Controls -->
   <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
       <span class="glyphicon glyphicon-chevron-left"></span>
       <span class="sr-only">Previous</span>
   </a>
   <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
       <span class="glyphicon glyphicon-chevron-right"></span>
       <span class="sr-only">Next</span>
   </a>
    
</div>


</div>

<div style="display: flex;flex-direction: row;">

<div class="list-group" style=" margin-left: 160px;
    margin-top: 20px;">
  <a href="#" class="list-group-item active" style="    width: 182px;">
          首页
  </a>
  
  <a href="perInfo.jsp" class="list-group-item">个人主页</a>
  <a href="homework.jsp" class="list-group-item">我的练习</a>
  <!-- <a href="#" class="list-group-item">题库</a> -->
  
  
  <a href="pro_qes.jsp" class="list-group-item">提出问题</a>
  <a href="my_qes.jsp" class="list-group-item">我的提问</a>
  <!-- <a href="#" class="list-group-item">Class Regulate</a> -->
</div>

<div style="display: flex;flex-direction: column;">
     

  <div id="qes" class="qes">
   <div class="qes_part">
    

  
   </div>
  </div>

</div>
</div>
</div>
</body>
</html>
