// 登录
function toLogin(){
	var form=$('form').serializeArray();
	if(form[0].value=="" || form[1].value==""){	//如果账户或密码为空，退出函数
		alert("用户名或密码不能为空");
		return;
	}

	$.ajax({
		type: "post",//方法类型
		//url: "LoginServlet" ,
		url: "loginServlet.do" ,
		dataType:"text",
		async:true,
		data: form,
		success: function (data) {
			if (data=="no") {
				alert("登录失败，请正确填写信息");
	 		}else{
				window.location.href="dashboardServlet.do";
			}
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}

// 注册
function toRegister(){
	var form=$('form').serializeArray();
	if(form[0].value=="" || form[1].value==""){	//如果账户或密码为空，退出函数
		alert("用户名或密码不能为空");
		return;
	}

	$.ajax({
		type: "post",//方法类型
		url: "registerServlet.do" ,
		dataType:"text",
		async:true,
		data: form,
		success: function (data) {
			if (data=="no") {
				alert("注册失败");
	 		}else{
				alert("注册成功");
				window.location.href="login.html";
			}
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}