/**
 * 
 */

function toLogin(){
	var form=$('form').serializeArray();
	var username=form[0].value;
	var password=form[1].value;
	var level=form[2].value;
	if(username=="" || password=="")	//如果账户或密码为空，退出函数
		return
	//html  json  text   xml
	$.ajax({
		type: "post",//方法类型
		url: "LoginServlet" ,
		dataType:"text",
		async:true,
		data: {"username":username,"password":password,"level":level},
		success: function (data) {
			if (data=="no") {
				alert("登录失败，请正确填写信息");
	 		}else{
				alert("登录成功")
				//跳转到首页
			}
		},
		error : function() {
			alert("异常请求！");
		}
	});
}