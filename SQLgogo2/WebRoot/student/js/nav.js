
function load(){ 
     $.post("../PersonInfoServlet?status=check",(data)=>{
 		try{
 			 if(data=="null"){
 	    		 
 	    	 }else{
 	    		 localStorage.setItem("user",data);
 	    		 user = eval(`(${data})`).user;
 	    		 console.log(user);
 	    		 var hostport=document.location.host;
 	    		 
 	    		 $("#nav_user_photo").attr("src","http://"+hostport+user.profile);
 	    	
 	    	 }
 		}catch(e){
 			 layer.msg('暂未登录！',{ offset: '350px' });
 			 setTimeout(function(){window.location.href="./login.jsp"},1500);
 		}
    	
  })
}
