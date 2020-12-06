<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- jstl库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/page-tags" prefix="p"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>我的订单</title>
	<!-- <link href="bootstrap-4.5.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"> -->
	<link href="css/main.css" rel="stylesheet" type="text/css">
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
		  <h2>我的订单</h2>
		</div>
		<ul class="app-breadcrumb breadcrumb side">
			<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
			<li class="breadcrumb-item">订单管理</li>
			<li class="breadcrumb-item active"><a href="#">类型管理</a></li>
		</ul>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <table class="table table-hover table-bordered" id="sampleTable">
                <thead>
                  <tr>
                    <td>No.</td>
					<td>订单编号</td>
					<td>洗衣机编号</td>
					<td>洗衣模式</td>
					<td>订单生成时间</td>
                  </tr>
                </thead>
                <tbody>
                <!-- el表达式-->
                <!-- varStatus  var的下标序号 -->
                <c:forEach items="${page.data}" var="order" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${order.id}</td>
						<td>${order.washerID}</td>
						<td>${order.mode}</td>
						<td>${order.generatedTime}</td>
						<td>
							<button class="btn btn-success" type="button" onclick="updateOrder(${order.id})">修改</button>
							<button class="btn btn-danger" type="button" onclick="deleteOrderByID(${order.id})">退选</button>
						</td>
					</tr>	
				</c:forEach>
                </tbody>
              </table>
              <p:page action="orderList.normalUserServlet" />
            </div>
          </div>
        </div>
      </div>
    <script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script src="js/normalUser.js"></script>
</body>
</html>