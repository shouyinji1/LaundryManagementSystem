<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>添加洗衣价目</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">	<style>
	body{
		padding:50px;
	}
	</style>
</head>
<body>
      <div class="app-title">
        <div>
          <p>洗衣价目添加</p>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">价目管理</li>
          <li class="breadcrumb-item active"><a href="#">洗衣价目添加</a></li>
        </ul>
      </div>
      <div class="col-md-6">
      	<form id="myform">
          <div class="tile">
            <h3 class="tile-title">添加</h3>
            <div class="tile-body">
              <div class="form-horizontal">
				<div class="form-group row">
					<label class="control-label col-md-3">洗衣模式：</label>
					<div class="col-md-8">
						<input name="mode" id="mode" class="form-control" type="text" placeholder="请输入洗衣模式">
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-3">洗衣价格：</label>
					<div class="col-md-8">
						<input name="price" id="price" class="form-control" type="text" placeholder="请输入洗衣价格">
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label col-md-3">洗衣时长：</label>
					<div class="col-md-8">
						<input name="duration" id="duration" class="form-control" type="text" placeholder="请输入洗衣时长">
					</div>
				</div>
              </div>
            </div>
            <div class="tile-footer">
              <div class="row">
                <div class="col-md-8 col-md-offset-3">
                  <button class="btn btn-primary" type="button" id="submitBtn">
                  	提交
                  </button>
                  <button class="btn btn-primary" type="button" id="retBtn">
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
			//匿名函数，没有名字的方法
			$("#submitBtn").click(function(){
				var data = $("#myform").serialize(); 
				$.ajax({
						type:'post',  
						url:'addPrice.adminServlet', 
						cache: false,
						data:data,  //重点必须为一个变量如：data
						dataType:'text', 
						success:function(res){
							if(res=='yes'){
								window.location.href="priceList.adminServlet";
							}else if(res=='priceIsExist'){
									alert("该价目已存在");
							}else if(res=="no"){
								alert("系统异常，新增数据失败，3秒后跳回页面");
								setTimeout("location.href='priceList.adminServlet'",3000);
							}
						},
						error:function(){ 
							 alert("请求失败")
						}
				})
			});
			$("#retBtn").click(function(){
				window.location.href="priceList.adminServlet";
			})
		}) 
	</script>
</body>
</html>