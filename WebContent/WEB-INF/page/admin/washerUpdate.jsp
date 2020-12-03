<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">	
	<style>
		body{
		padding:50px;
		}
	</style>
</head>
<body>
      <div class="app-title">
        <div>
          <p>洗衣机信息修改</p>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item active"><a href="#">信息修改</a></li>
        </ul>
      </div>
      <div class="col-md-6">
      	<form action="updateWasherById.adminServlet" method="post" id="myform">
          <div class="tile">
            <h3 class="tile-title">修改</h3>
            <div class="tile-body">
              <div class="form-horizontal">
                <div class="form-group row">
                  <label class="control-label col-md-3">设备ID：</label>
                  <div class="col-md-8">
                  	<input name="id" id="id" class="form-control" value="${washer.id}" readonly="readonly"> 
                  </div>
                </div>
				<div class="form-group row">
					<label class="control-label col-md-3">设备名称</label>
					<div class="col-md-8">
						<input name="name" id="name" class="form-control" type="text" value="${washer.name}">
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-3">设备位置</label>
					<div class="col-md-8">
						<input name="location" id="location" class="form-control" type="text" value="${washer.location}">
					</div>
				</div>
              </div>
            </div>
            <div class="tile-footer">
              <div class="row">
                <div class="col-md-8 col-md-offset-3">
                  <button class="btn btn-primary" type="button" id="submitBtn">
                  	保存
                  </button>
                   <button class="btn btn-primary" type="button" onclick="javascript:window.location.href='washerList.adminServlet'" id="retBtn">
                  	返回
                  </button>
                </div>
              </div>
            </div>
          </div>
         </form>
     </div>
	<script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		 $(function(){
			//匿名函数   没有名字的方法
			$("#submitBtn").click(function(){
				//验证表单项是否为空
				//var washerName = $("#washerName").val();
				//if(washerName==null || washerName==""){
				//	alert("装备名称不能为空");
				//	//鼠标聚焦到指定的输入框中
				//	$("#washerName").focus();
				//	return false;
				//}
				//提交表单
				$("#myform").submit();
			});
		}) 
	</script>
</body>
</html>