function exit(){
			if(window.confirm("确认要退出吗？")){
				window.open('login.jsp','_top')
			}else{
				return false;
			}
  }



function LoadData(){
	var dbname = $('#mydbname').val();
	var praid = $('#mypraid').val();
	
	var mypraid = $('#mypraid').val();
	var myclassid = $('#myclassid').val();
	$.ajax({
    	url:'/SQLgogo2/WorkshowServlet',
    	type:'post',
    	data:{
    		"pageNum":1,
    		"dbname":dbname,
    		"praid":praid,
    		
    	},
    	async: false,
    	success:function(res){			
			res = eval(`(${res})`);   //这是将字符串转成对象的语句。
		     totalPage = res.totalPage;
		     $('#mytotalPage').val(res.totalPage);
		     $('.zxfinput').val(res.pageNum);
		     if(res.list == null){
		    	 $("#mytbody").append("还没有作业哦！")
		     }else{
		    	 var a = 1;
			     for(let item of res.list){		    
			    	 $("#mytbody").append(`<tr>	                
		                <td>${a++}</td>
		                <td>${item.subjectName}</td>
		                <td>${item.set_score}</td>
		                <td>${item.setpro_score}</td>
		                <td>${item.setres_score}</td>
		                
		                <td><a href="answer.jsp?subjectid=${item.subjectId}&dbname=${dbname}&mypraid=${mypraid}&myclassid=${myclassid}">答题</a> &nbsp
													
		                </tr>`)		   	   
			     
				     }
			     }
	    	},
	    	error:function(){
		      layer.msg("error！");
	    	}
	});
	
	
	/*//翻页
	$(".zxf_pagediv").createPage({		    
			pageNum: $('#mytotalPage').val(),
			current: 1,
			backfun: function(data) {
				console.log($(".current").text());//回调
				var pageNum = $(".current").text(); 
				$.ajax({
			    	url:'/SQLgogo2/WorkshowServlet',
			    	type:'post',
			    	data:{
			    		"pageNum":pageNum,
			    		"dbname":dbname,
			    		"praid":praid,
			    		
			    	},
			    	async: false,
			    	success:function(res){
			    		res = eval(`(${res})`);   //这是将字符串转成对象的语句。			    		console.log(res+"2222");
			    		$('.zxfinput').val(res.pageNum);
			    		$("#mytbody").html("");
			    		var a = 1;
			    		if(res.list == null){
					    	 $("#mytbody").append("还没有作业哦！")
					     }else{
					    	 var a = 1;
						     for(let item of res.list){		    
						    	 $("#mytbody").append(`<tr>	                
					                <td>${a++}</td>
					                <td>${item.subjectName}</td>
					                <td>${item.set_score}</td>
					                <td>${item.setpro_score}</td>
					                <td>${item.setres_score}</td>
					                
					                <td><a href="answer.jsp?subjectid=${item.subjectId}&dbname=${dbname}&mypraid=${mypraid}&myclassid=${myclassid}">答题</a> &nbsp
																
					                </tr>`)		   	   
						     
						     }
					     }
			    	}
				});
			}
		});*/
	
}
        