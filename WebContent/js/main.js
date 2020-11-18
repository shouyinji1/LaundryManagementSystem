(function () {
	"use strict";

	var treeviewMenu = $('.app-menu');

	// Toggle Sidebar
	$('[data-toggle="sidebar"]').click(function(event) {
		event.preventDefault();
		$('.app').toggleClass('sidenav-toggled');
	});

	// Activate sidebar treeview toggle
	$("[data-toggle='treeview']").click(function(event) {
		event.preventDefault();
		if(!$(this).parent().hasClass('is-expanded')) {
			treeviewMenu.find("[data-toggle='treeview']").parent().removeClass('is-expanded');
		}
		$(this).parent().toggleClass('is-expanded');
	});

	// Set initial active toggle
	$("[data-toggle='treeview.'].is-expanded").parent().toggleClass('is-expanded');

	//Activate bootstrip tooltips
	$("[data-toggle='tooltip']").tooltip();

})();

//删除洗衣机
function deleteById(id){
	$.ajax({
		type: "post",//方法类型
		url: "deleteByIdServlet.do" ,
		dataType:"text",
		async:true,
		data: {'id':id},
		success: function (data) {
			if (data=="no") {
				alert("删除失败！")
	 		}else{
	 			location.reload();
			}
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}

function addWasher(){
	window.location.href="toAddWasher.do";
}
function updateWasher(){
	window.location.href="updateWasher.do?id="+id;
}