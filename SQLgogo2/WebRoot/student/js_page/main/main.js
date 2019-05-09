
	
function load_main(){
	
	$.post('../QesServlet?status=tea_qes',(data)=>{
	         data = eval(`(${data})`)
	         console.log(data)
		 for(item of data){
		 $(".qes_part").append(` 
		                  <div class="qes_demo" id="tea_deom${item.teaQuestionId}">
								<div id="user" class="user">
									<div id="user_pic" class="user_pic">
										<a href="/SQLgogo2/student/tea_question.jsp?teaQes=${item.teaQuestionId}"> <img class="img-circle" src=${item.photo}
											style="width:80px; height: 80px;">
										</a>
									</div>
									<p class="user_name">${item.teaName}</p>
								</div>
								<div id="user_qes" class="user_qes">
									<div class="qes_name">${item.qesName}</div>
									<div class="qes_time">${item.addtime}</div>
									<div class="qes_state">
										关注量：<span id="mentions">${item.concern}</span>
									</div>
								</div>
							</div>`)   	
		    }    
	})
}