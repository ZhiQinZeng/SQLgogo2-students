	 var thisURL = document.URL; 	
	 var getval =thisURL.split('?')[1]; 
	 var stu_id = getval.split('&')[0].split('=')[1];
	 
	 var s = 1;
	 var a = new Array();
	 var k = 0;

function load_qes(){
		 $.post('../QesServlet?status=stu_qes_detail',{id:stu_id},(data)=>{
				
				 let stu_qes = eval(`(${data})`).stu_qes;
				console.log(stu_qes)
				$(".qes_name").text(stu_qes.title);
				$("#qes_portray").text(stu_qes.questionProtray);
				$("#mentions").text(stu_qes.concern);
				$(".user_name").text(stu_qes.studentName);
				let unixTimestamp = new Date( stu_qes.addtime )
				let addTime = unixTimestamp.toLocaleString();
				$(".qes_time").text(addTime);
				$("#tea_photo").attr("src",stu_qes.filepath);
			})
	 }
	 
$(document).ready(function() {
	
	$("#comment").click(function() {
		if (s % 2 == 1) {
			$("#comment").html("收起");
			$("#submit").css("display", "");
			$("#submit").css("opacity", 0.1);
			$("#submit").animate(
				{
					left : '90px',
					opacity : '1'
				}, "slow");
			s++;
		} else {
			$("#comment").html("回复");
			$("#submit").animate(
				{
					left : "0px",
					opacity : '0',
				}, "slow", function() {
					$("#submit").css("display", "none");
				});

			s++;
		}
	});

})