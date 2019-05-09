function exit(){
			if(window.confirm("确认要退出吗？")){
				window.open('login.jsp','_top')
			}else{
				return false;
			}
  }


  

function LoadData(){
	var subjectid = $('#subjectid').val();
	var dbname = $('#dbname').val();
	var mypraid = $('#mypraid').val();
	$.ajax({
    	url:'../AnswerServlet?method=gettable',
    	type:'post',
    	data:{
    		"subjectid":subjectid,
    		"dbname":dbname,
    		"mypraid":mypraid
    	},
    	async: false,
    	success:function(res){	
    		res = eval(`(${res})`);   //这是将字符串转成对象的语句。
    		console.log(res)
    		for(var i = 0;i<res.length;i++){
    			if(i == res.length-2){
    				$("#question").html("");
    				$("#question").append(`${res[i]}`);
    			}else if(i == res.length-1){
    				if(res[i] == null){
    					$("#proscore").val(0);
        				$("#resscore").val(0);
        				$("#score").val(0);
        				$("#mycode").val(" ");
    				}else{
	    				$("#proscore").val(`${res[i].pro_score}`);
	    				$("#resscore").val(`${res[i].res_score}`);
	    				$("#score").val(`${res[i].score}`);
	    				$("#mycode").val(`${res[i].code}`);
    				}
    			}else {
    				$("#mydl").append(`<dd><a>${res[i]}</a></dd>`);    	
    			} 
    		}
    		layui.use('element', function() { 
    			var element = layui.element; 
    			element.init();
    		})
    	},
	    	
    	error:function(){
		      layer.msg("error！");
	    }
	});
}
	
function confirm(){
	var mysqlcode = $('#mycode').val();
	var dbname = $('#dbname').val();
	var subjectid = $('#subjectid').val();
	var mypraid = $('#mypraid').val();
	var myclassid = $('#myclassid').val();
	
	
	if(mysqlcode == null || mysqlcode == ""){
		layer.msg("代码不能为空！");
	}
	else{
		$.ajax({
	    	url:'../AnswerServlet?method=code',
	    	type:'post',
	    	data:{
	    		"mysqlcode":mysqlcode,
	    		"dbname":dbname,
	    		"subjectid":subjectid,
	    		"mypraid":mypraid,
	    		"myclassid":myclassid
	    	},
	    	async: false,
	    	success:function(res){	
	    		if(res == "errorsql"){
	    			layer.msg("您的代码不合法，请写查询语句！");
	    		}else{
	    			res = eval(`(${res})`);	    		
	    			$('#proscore').val(res.proscore);
		    		$('#resscore').val(res.resscore);
		    		$('#score').val(res.total);
		    		$('#sqlresult').val(res.result);
	    		}
	    	},
	    	error:function(){
			      layer.msg("error！");
		    }
		});
	}
}	
	

        