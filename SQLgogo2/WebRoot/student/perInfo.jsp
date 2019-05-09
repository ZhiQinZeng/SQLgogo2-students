
<%@ page language="java" import="javax.servlet.*" pageEncoding="utf-8"%>


<!DOCTYPE>
<html lang="en">
<head>
    <title>个人主页</title>
    <link href="../student/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="../student/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../student/js_page/perInfo/perInfo.css">
     <link rel="stylesheet" type="text/css" href="./js_page/login/login.css">
    
	<script src="../student/js/jquery-3.3.1.min.js"></script>
	<script src="../student/js/bootstrap/js/bootstrap.min.js"></script>
	<script src="../student/js_page/perInfo/perInfo.js"></script>
	<script type="text/javascript" src="layui-v2.4.3/layui-v2.4.3/layui/layui.all.js"></script>
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



    
<body onload="load2(),load()">
<jsp:include page="./nav.jsp"></jsp:include>
<div style="position: absolute;background-color: #eaeaea;height: 80%;width: 100%;display:flex;">
     <div id="bar"></div>
     <div id = "left-menu" class="left_ul" >
        <div id="message" class="left_li" style="border-top-left-radius: 5px;border-top-right-radius: 5px;">
           <p>我的资料</p>
        </div>
        <div id="password_change" class="left_li">
            <p>修改密码</p>
        </div>
        <div id="to_teacher" class="left_li" style="border-bottom-left-radius: 5px;border-bottom-right-radius: 5px;">
         <p>教师信箱</p>
        </div>
     </div>
    <div class="message_part" id="message_part" >
         <div class="message_main">
            <div id="head">
               <span style="letter-spacing: 50px;">头像</span>
              <img  class="img-circle" src="" id="preview" style="width:85px; height: 85px;left: -5px;position: relative;">
               <div class="btn btn-primary fileinput-button" id="choice_file" style="background-color:#008def;border-color:white" >
            <span>上传头像</span>
            <input type="file" id="fileId" style="opacity: 0;left: -7px;position: relative;top: -22px;width: 83px;" onchange="imgPreview(this)">
        </div>		
            </div>
            <div class="item">
             <span style="letter-spacing: 50px;">昵称</span>
               <input type="text" class="form-control" placeholder="Username" id="name" style="width: 40%;">
            </div>
            <div  class="item">
               <span style="letter-spacing: 50px;" >学号</span>
               <span  id="student_id"></span>
            </div>
            <div  class="item">
              <span style="letter-spacing: 8px;">专业名称</span>
              <span style="margin-left:40px" id="major">行为艺术</span>
            </div>
            <div  class="item">
               <span style="letter-spacing: 8px;">班级名称</span>
               <span  style="margin-left:40px" id="class">16软本二</span>
            </div>
            <div id="sex" class="item" style="margin-top: 25px;">
             <span style="letter-spacing: 50px;">性别</span>
               <input type="radio" name="sex" value="男"><span class="span_sex">男</span>
                <input type="radio" name="sex" style="margin-left:40px" value="女"><span class="span_sex">女</span>
            </div>
            <div  class="item">
                 <span style="letter-spacing: 8px;">邮箱地址</span>
                 <input type="email" class="form-control" placeholder="E-mail" id="email" style="width: 40%;margin-left: 40px;">
            </div>
            <button type="button" class="btn btn-primary" style="background-color:#008def;margin-left:128px;width: 40%;margin-top: 15px;border-color: white;" onclick="preserve();">保存资料</button>
         </div>
    </div>
    
    <div class="password_part" id="password_change_part" >
       <div style="position: relative;top: -90px;">
         <div class="item">
          <span style="color:red;position: relative;top: -8;right: 5px;">*</span> <input type="password" class="form-control" placeholder="请输入原密码" id="password_old" style="">
          </div>
          <div class="item">
          <span style="color:red;position: relative;top: -8;right: 5px;">*</span> <input type="password" class="form-control" placeholder="请输入新密码" id="password_new" style="">
          </div>
          <div class="item">
          <span style="color:red;position: relative;top: -8;right: 5px;">*</span> <input type="password" class="form-control" placeholder="确认密码"     id="password_confirm" style="">
          </div>
           <button type="button" id="pwd_modify_confirm" class="btn btn-primary pwd_modify_confirm" style="background-color:#008def;margin-left:5px;width: 201px;margin-top: 15px;">确认修改</button>
      </div>
    </div>
    
    <div class="to_teacher" id="to_teacher_part">
       <div style="position: relative;">
            <p style="font-size: 18px;position: relative;top: 50px;left: 20px;">请在下方输入要跟老师交流的信息:</p>
          <textarea name="" required lay-verify="required" id="stu_tea_message" placeholder="请输入" class="textarea"></textarea>
       <button type="button" class="btn btn-primary realname" id="stu_tea_message_submit">实名提交</button>
      </div>
      
    </div>
</div>
</body>
</html>