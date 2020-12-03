<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>创建订单</title>
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
          <p>创建订单</p>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item active"><a href="#">创建订单</a></li>
        </ul>
      </div>
      <div class="col-md-6">
      	<form action="createOrder.normalUserServlet" method="post" id="myform">
          <div class="tile">
            <h3 class="tile-title">创建订单</h3>
            <div class="tile-body">
              <div class="form-horizontal">
                <div class="form-group row">
                  <label class="control-label col-md-3">用户ID：</label>
                  <div class="col-md-8">
                  	<input name="userID" id="userID" class="form-control" value="${user.id}" readonly="readonly"> 
                  </div>
                </div>
                <div class="form-group row">
                  <label class="control-label col-md-3">用户名：</label>
                  <div class="col-md-8">
                  	<input name="username" id="username" class="form-control" value="${user.name}" readonly="readonly"> 
                  </div>
                </div>
                <div class="form-group row">
                  <label class="control-label col-md-3">电话号码：</label>
                  <div class="col-md-8">
                  	<input name="tel" id="tel" class="form-control" value="${user.tel}" readonly="readonly"> 
                  </div>
                </div>
                <div class="form-group row">
                  <label class="control-label col-md-3">设备ID：</label>
                  <div class="col-md-8">
                  	<input name="washerID" id="washerID" class="form-control" value="${washer.id}" readonly="readonly"> 
                  </div>
                </div>
				<div class="form-group row">
					<label class="control-label col-md-3">设备名称：</label>
					<div class="col-md-8">
						<input name="washerName" id="washerName" class="form-control" type="text" value="${washer.name}" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-3">设备位置：</label>
					<div class="col-md-8">
						<input name="location" id="location" class="form-control" type="text" value="${washer.location}" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-3">洗衣方式：</label>
					<div class="col-md-8">
						<select class="form-control" id="mode" name="mode">
							<c:forEach items="${prices}" var="price">
								<option value="${price.mode}">${price.mode}:${price.price}元，时长${price.duration}分钟</option>
							</c:forEach>
						</select>
					</div>
				</div>
              </div>
            </div>
            <div class="tile-footer">
              <div class="row">
                <div class="col-md-8 col-md-offset-3">
                  <button class="btn btn-primary" type="button" id="submitBtn">提交</button>
                  <button class="btn btn-primary" type="button" onclick="javascript:window.location.href='washerList.normalUserServlet'" id="retBtn">返回</button>
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