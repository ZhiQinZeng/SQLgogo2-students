 var user = localStorage.getItem("user")
 var user_id =  eval(`(${user})`).user.id;
 console.log(user_id)

function submit(){
	
	let title = $("#sub_name").val();
	let protray = $("#textarea").val();
	let stuId = user_id;
	let now = Date();
	console.log(now)
	
	$.post('../QesServlet?status=propose',{title:title,protray:protray,user_id:user_id},(data)=>{
		console.log(data)
		if(data=="done"){
			 layer.msg('提交成功！',{ offset: '350px' });
			 setTimeout(()=>{history.go(-1)},1500);
		}else if(data=="date_decline"){
			 layer.msg('每天只能提交一次问题！',{ offset: '350px' });
		}else{
			 layer.msg('提交失败，请稍后再试！',{ offset: '350px' });
		}
	})
}