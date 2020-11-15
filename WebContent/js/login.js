/**
 * 
 */

function toLogin(){
	var form=$('form').serializeArray();
	if(form[0].value=="" || form[1].value=="")	//如果账户或密码为空，退出函数
		return;

	$.ajax({
		type: "post",//方法类型
		url: "LoginServlet" ,
		dataType:"text",
		async:true,
		data: form,
		success: function (data) {
			if (data=="no") {
				alert("登录失败，请正确填写信息");
	 		}else{
				window.location.href="DashboardServlet";
			}
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}