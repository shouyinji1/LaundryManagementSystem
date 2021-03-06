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
		url: "deleteById.adminServlet" ,
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

// 增加洗衣机页面跳转
function addWasher(){
	window.location.href="toAddWasher.adminServlet";
}

// 更新洗衣机页面跳转
function updateWasher(){
	window.location.href="updateWasher.adminServlet?id="+id;
}


//删除订单
function deleteOrderByID(id){
	$.ajax({
		type: "post",//方法类型
		url: "deleteOrderByID.adminServlet" ,
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

//删除用户
function deleteUserByID(id){
	$.ajax({
		type: "post",//方法类型
		url: "deleteUserByID.adminServlet" ,
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

//删除价目
function deletePriceByMode(mode){
	$.ajax({
		type: "post",//方法类型
		url: "deletePriceByMode.adminServlet" ,
		dataType:"text",
		async:true,
		data: {'mode':mode},
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

// 添加洗衣机页面跳转
function addPrice(){
	window.location.href="toAddPrice.adminServlet";
}