	 var thisURL = document.URL; 	
	 var getval =thisURL.split('?')[1]; 
	 var qes_id = getval.split('&')[0].split('=')[1];
	 
	 var s = 1;
	 var a = new Array();
	 var k = 0;

function load_qes(){
		 $.post('../QesServlet?status=tea_qes_detail',{id:qes_id},(data)=>{
				
				 let tea_qes = eval(`(${data})`).tea_qes;
				console.log(tea_qes)
				$(".qes_name").text(tea_qes.qesName);
				$("#qes_portray").text(tea_qes.questionProtray);
				$("#mentions").text(tea_qes.concern);
				$(".user_name").text(tea_qes.teaName);
				let unixTimestamp = new Date( tea_qes.addtime )
				let addTime = unixTimestamp.toLocaleString();
				$(".qes_time").text(addTime);
				$("#tea_photo").attr("src",tea_qes.photo);
			})
	 }
	 
$(document).ready(function() {
	var E = window.wangEditor
	var editor1 = new E('#div1', '#div2') // 两个参数也可以传入 elem 对象，class 选择器

	
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
	editor1.customConfig.menus = [
		'head',
		'bold',
		'italic',
		'underline',
		'emoticon', // 表情
		'code' , // 插入代码
		'undo' // 撤销
	]

	editor1.create()
})