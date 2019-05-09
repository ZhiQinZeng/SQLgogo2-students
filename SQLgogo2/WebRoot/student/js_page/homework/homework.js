function exit(){
			if(window.confirm("确认要退出吗？")){
				window.open('login.jsp','_top')
			}else{
				return false;
			}
  }



function loadData(){
	
	$.ajax({
    	url:'../HomeworkServlet?pageNum=1',
    	type:'get',
    	async: false,
    	success:function(res){			
			res = eval(`(${res})`);   //这是将字符串转成对象的语句。
		     totalPage = res.totalPage;
		     $('#mytotalPage').val(res.totalPage);
		     $('.zxfinput').val(res.pageNum);
		     /*$('#classname').val(res.classname);*/
		     if(res.list == null){
		    	 $("#mytbody").append("没有练习哦！");
		     }else{
		    	 var a = 1;
			     for(let item of res.list){
			    
			    	 $("#mytbody").append(`<tr>
		                
		                <td>${a++}</td>
		                <td>${item.practiceName}</td>
		                <td>${item.dbname}</td>
		                <td>${item.publishDay}</td>
		                <td>${item.deadline}</td>
		                <td>
		                	<a href="workshow.jsp?praid=${item.practiceId}&dbname=${item.dbname}&classid=${res.classid}">进入</a> &nbsp
							
							
		                </tr>`)		   	   
			     
				     }
			     }			     
	    	},
	    	error:function(){
			      layer.msg("error！");
		    }
	});
	
	
	//翻页
	$(".zxf_pagediv").createPage({		    
			pageNum: $('#mytotalPage').val(),
			current: 1,
			backfun: function(data) {
				console.log($(".current").text());//回调
				var pageNum = $(".current").text(); 
				$.ajax({
			    	url:'../HomeworkServlet?pageNum='+pageNum,
			    	type:'get',
			    	async: false,
			    	success:function(res){
			    		res = eval(`(${res})`);   //这是将字符串转成对象的语句。			    		console.log(res+"2222");
			    		$('.zxfinput').val(res.pageNum);
			    		$("#mytbody").html("");
			    		/*$('#classname').val(res.classname);*/
			    		if(res.list == null){
					    	 $("#mytbody").append("没有练习哦！");
					     }else{
					    	 var a = 1;
						     for(let item of res.list){
						    
						    	 $("#mytbody").append(`<tr>
					                
					                <td>${a++}</td>
					                <td>${item.practiceName}</td>
					                <td>${item.dbname}</td>
					                <td>${item.publishDay}</td>
					                <td>${item.deadline}</td>
					                <td>
					                	<a href="workshow.jsp?praid=${item.practiceId}&dbname=${item.dbname}&classname=${res.classname}">进入</a> &nbsp
										
										
					                </tr>`)		   	   
						     
						     }
					     }
			    	}
				});
			}
		});
	
}
        