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

//取消选择洗衣机
function withdrawOrderByWasherID(id){
	$.ajax({
		type: "post",//方法类型
		url: "withdrawOrderByWasherID.normalUserServlet" ,
		dataType:"text",
		async:true,
		data: {'id':id},
		success: function (data) {
			if (data=="no") {
				alert("退选失败！")
	 		}else{
	 			location.reload();
			}
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}

function updateOrder(id){
	window.location.href="toUpdateOrder.normalUserServlet?id="+id;
}

//删除订单
function deleteOrderByID(id){
	$.ajax({
		type: "post",//方法类型
		url: "deleteOrderByID.normalUserServlet" ,
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