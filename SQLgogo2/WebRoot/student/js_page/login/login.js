
function confirm(){
    $.post("../Login",{username:$("#username").val(),password:$("#pwd").val()},function(data){
	      if(data=='null'){
	      layer.msg('账号或密码不能为空！',{ offset: '350px' });
	      }else if(data=="error"){
	      layer.msg('用户名或密码错误',{ offset: '350px' });
	      }else{
	    	  localStorage.setItem("user",data)
	    	 data = eval(`(${data})`);
	    	 layer.msg('登录成功！',{ offset: '350px' });
	    	setTimeout(function(){window.location.href="./main.jsp"},2000); 
	      }
	     
	});
    
}