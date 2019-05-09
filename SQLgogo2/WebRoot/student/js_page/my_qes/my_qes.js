
	
function load_main(){
	var id = localStorage.getItem("userId");
	$.post('../QesServlet?status=stu_qes',{id:id},(data)=>{
	         data = eval(`(${data})`)
	         console.log(data)
		 for(item of data){
		 $(".qes_part").append(` 
		                  <div class="qes_demo" id="tea_deom${item.studentsNumber}">
								<div id="user" class="user">
									<div id="user_pic" class="user_pic">
										<a href="/SQLgogo2/student/stu_question.jsp?stuQes=${item.questionId}"> <img class="img-circle" src=${item.filepath}
											style="width:80px; height: 80px;">
										</a>
									</div>
									<p class="user_name">${item.studentName}</p>
								</div>
								<div id="user_qes" class="user_qes">
									<div class="qes_name">${item.title}</div>
									<div class="qes_time">${item.addtime}</div>
									<div class="qes_state">
										关注量：<span id="mentions">${item.concern}</span>
									</div>
								</div>
							</div>`)   	
		    }    
	})
}