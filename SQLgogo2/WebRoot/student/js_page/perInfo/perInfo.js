
function load2(){
	$.post("../PersonInfoServlet?status=check",(data)=>{
		try{
			 user = eval(`(${data})`).user;
		     console.log("user!!!!!!!::::",user)
		     var hostport=document.location.host;
 	    		 console.log("dfskljfs");
 	    		console.log(hostport);
		     $("#preview").attr("src","http://"+hostport+user.profile);
		     $("#name").val(user.realname);   
		     $("#email").val(user.e_mail);  
		     $("#student_id").text(user.username);
		     $("#major").text(user.major);
		     $("#class").text(user.classname);
		     
		     if(user.sex=="男"){
		     	$("input[name='sex']").get(0).checked=true; 
		     }else{
		     	$("input[name='sex']").get(1).checked=true; 
		     }
		}catch(e){
			 layer.msg('暂未登录！',{ offset: '350px' });
		}
		
  })
	
	
}

function imgPreview(fileDom) {
	
    //判断是否支持FileReader
    if(window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }
    //获取文件
    
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if(!imageType.test(file.type)) {
    	 layer.msg('请选择图片！',{ offset: '350px' });
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("preview");
        //图片路径设置为读取的图片  
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
    
    //ajax 上传后端
    var formData = new FormData(); 
    formData.append('photo', $('#fileId')[0].files[0]);  //添加图片信息的参数
    // formData.append('userid',user.id);  添加其他参数
    $.ajax({
        url: '/SQLgogo2/uploadFile',
        type: 'post',
        cache: false, //上传文件不需要缓存
        data: formData,
     processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头  "multipart/form-data;boundary="+Math.random()
        success: function (data) {
            console.log(data)
            layer.msg('头像更改成功！',{ offset: '350px' });
        },
        error: function (data) {
        	layer.msg('头像上传失败！',{ offset: '350px' });
        }
    })  
}

function preserve(){
	
	let sex = $("input:radio:checked").val();

	let name = $("#name").val();
	let email = $("#email").val()
	if( !(email.indexOf("@")!=-1 )){
		 layer.msg('邮箱格式不正确！',{ offset: '350px' });
		 return;
	}
	
	$.post("../PersonInfoServlet?status=change",{sex:sex,name:name,email:email},(data)=>{  
		    if(data=="ok"){
		    	layer.msg('保存成功！',{ offset: '350px' });
		    }else{
		    	layer.msg('服务器错误！',{ offset: '350px' });
		    }
	  })
	
}
$(document).ready(function(){

	$("#message").bind("click",function(){
		$("#message_part").css("display","flex")
		$("#to_teacher_part").css("display","none")
		$("#password_change_part").css("display","none")
		$("#bar").animate(
				{top: "38px"},"800"
				);
		
	})
	$("#password_change").bind("click",function(){
		$("#message_part").css("display","none")
		$("#to_teacher_part").css("display","none")
		$("#password_change_part").css("display","flex")
		
		$("#bar").animate(
				{top: "91px"},"800"
				);
	})
	$("#to_teacher").bind("click",function(){
		$("#message_part").css("display","none")
		$("#password_change_part").css("display","none")
		$("#to_teacher_part").css("display","flex")
		
		$("#bar").animate(
				{top: "144px"},"800"
				);
	})
	
	
	
	$("#pwd_modify_confirm").bind("click",function(){
		 let password_old = $("#password_old").val();
		 let password_new = $("#password_new").val();
		 let password_confirm = $("#password_confirm").val();
		 
		 if(!(password_new==password_confirm)){
			 layer.msg('两次新密码输入不一致！',{ offset: '350px' });
			 return;
		 }
		 
		  $.post("../pwd_modify",{password_old:password_old,password_new:password_new},function(data){
			  if(data=="old_none"){
				  layer.msg('原密码错误！',{ offset: '350px' });
				  return;
			  }else if(data=="modify_success"){
				  layer.msg('修改成功！',{ offset: '350px' });
				  setTimeout(function(){window.location.href="./login.jsp"},2000);
				  return;
			  }

		  });
	})
	
	$("#stu_tea_message_submit").bind("click",function(){
	  let message = $("#stu_tea_message").val();
	  if(message==""){
		  layer.msg('请输入内容！',{ offset: '350px' });
		  return;
	  }
	  $.post("../stu_tea_message",{stu_tea_message:message},function(data){
		   if(data=="message_success"){
			   layer.msg('提交成功！',{ offset: '350px' });
		   } 
	  });
	})
});
