<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="generator" content="Jekyll v4.1.1">
		<title>洗衣房管理系统</title>

		<!-- Bootstrap core CSS -->
		<link href="bootstrap-4.5.3-dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">

		<style>
		  .bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		  }

		  @media (min-width: 768px) {
			.bd-placeholder-img-lg {
			  font-size: 3.5em;
			}
		  }
		</style>
		<!-- Custom styles for this template -->
		<link href="css/dashboard.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
			<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">${dashboardInfo.brand}</a>
			<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
			  <span class="navbar-toggler-icon"></span>
			</button>
			<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
			<li class="navbar px-0 dropdown"><a class="nav-link text-nowrap" href="#" data-toggle="dropdown">${user.name}</a>
			  <ul class="dropdown-menu dropdown-menu-md-right">
				<!-- <li><a class="dropdown-item" href="javascript:changeMenu('getUserInfo.do')"><i class="fa fa-cog fa-lg"></i>个人信息</a></li> -->
				<li><a class="dropdown-item" data-toggle="modal" data-target="#showUserInfoModal"><i class="fa fa-cog fa-lg"></i>个人信息</a></li>
				<li><a class="dropdown-item" href="javascript:showModal('#myModal')"><i class="fa fa-user fa-lg"></i>修改密码</a></li>
				<li><a class="dropdown-item" href="logoutServlet.do"><i class="fa fa-sign-out fa-lg"></i>退出登录</a></li>
			  </ul>
			</li>
		</nav>

		<div class="container-fluid">
		  <div class="row">
			<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
			  <div class="sidebar-sticky pt-3">
				<ul class="nav flex-column">
				  <li class="nav-item">
					<a class="nav-link active" href="#">
					  <span data-feather="home"></span>
					  洗衣机列表<span class="sr-only">(current)</span>
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="file"></span>
					  Orders
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="shopping-cart"></span>
					  Products
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="users"></span>
					  Customers
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="bar-chart-2"></span>
					  Reports
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="layers"></span>
					  Integrations
					</a>
				  </li>
				</ul>
		
				<h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
				  <span>Saved reports</span>
				  <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
					<span data-feather="plus-circle"></span>
				  </a>
				</h6>
				<ul class="nav flex-column mb-2">
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="file-text"></span>
					  Current month
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="file-text"></span>
					  Last quarter
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="file-text"></span>
					  Social engagement
					</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link" href="#">
					  <span data-feather="file-text"></span>
					  Year-end sale
					</a>
				  </li>
				</ul>
			  </div>
			</nav>
		
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div class="container">
				  <!-- <iframe class="embed-responsive-item" src="washerListServlet.do" scrolling="no"></iframe>-->
				  <iframe class="embed-responsive-item" src="${dashboardInfo.iframe_src}" onload="this.height=this.contentWindow.document.body.scrollHeight" width="100%" scrolling="no" frameborder="0"></iframe>
				</div>
			</main>
		  </div>
		</div>

		<div class="modal fade" id="showUserInfoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"><h4 class="modal-title">个人信息</h4></div>
				  <div class="modal-body">
				  <form id="fm1">
					<div class="form-group row form-inline">
						<label class="col-sm-3 control-label">用户ID：</label>
						<div class="col-sm-5"><input type="text" class="form-control" id="id" value="${user.id}" readonly="readonly"></div>
					</div>
					<div class="form-group row form-inline">
						  <label class="col-sm-3 control-label">用户名：</label>
						  <div class="col-sm-5">
							  <input type="text" class="form-control" id="username" name="username" value="${user.name}" >
						  </div>
					  </div>
					<div class="form-group row form-inline">
						  <label class="col-sm-3 control-label">用户级别：</label>
						  <div class="col-sm-5"><input type="text" class="form-control" id="level" readonly="readonly" value="${user.level}" ></div>
					</div>
					<div class="form-group row form-inline">
						  <label class="col-sm-3 control-label">电话号码：</label>
						  <div class="col-sm-5"><input type="text" class="form-control" id="tel" name="tel" value="${user.tel}" ></div>
					</div>
				  </form>
				  </div>
				  <div class="modal-footer">
					  <button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateUserInfo()">修改</button>
					  <button type="button" class="btn btn-success" data-dismiss="modal" onclick="#">返回</button>
				  </div>  
				</div>
			</div>
		</div>

		<!-- 模态框 -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<input type="hidden" name="userid" id="userid" value="${user.id}">
						用户名：<input type="text" id="name" name="name" value="${user.name}" readonly="readonly">			  	
					</div>
					<div class="modal-body">
						旧密码：<input type="text" id="oldpassword" name="oldpassword" >			  	
					</div>
					<div class="modal-body">
						新密码：<input type="text" id="newpassword" name="newpassword" >			  	
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" onclick="updatePassword()">确认修改</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		<script src="js/jquery-3.5.1.min.js"></script>
		<script src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
		<script src="js/dashboard.js"></script>
		<script type="text/javascript">
			function updatePassword(){
				var oldpassword=$("#oldpassword").val();
				var newpassword=$("#newpassword").val();
				if(oldpassword!='${user.password}'){
					alert("原始密码输入错误，请重试")
					return;
				}else{
					if(newpassword==null || newpassword==""){
						alert("新密码不能为空，请输入！")
						return;
					}else{
						$.ajax({
							type: "post",//方法类型
							url: "updatePassword.do" ,//url
							data: {id:$("#userid").val(),newpassword:newpassword},
							success: function (data) {
								if (data=="no") {
									alert("修改失败，请重试或联系管理员");
								}else{
									alert("修改成功！")
									window.location.href="logoutServlet.do";
								}
							},
							error : function() {
								alert("异常请求！");
							}
						}); 
					}
				}
			}
		</script>
    </body>
</html>
