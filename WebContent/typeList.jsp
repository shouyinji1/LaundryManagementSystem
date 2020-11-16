<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- jstl库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>洗衣机管理</title>
	<link href="bootstrap-4.5.3-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<style>
		body{
			padding:50px;
		}
	</style>
</head>
<body>

      <div class="app-title">
        <div>
          <h2>洗衣机列表</h2>
        </div>
      </div>
      <div class="row">
      	<div class="col-md-12">
      		<button class="btn btn-primary" type="button" onclick="toAdd()">添加</button>
      	</div>
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <table class="table table-hover table-bordered" id="sampleTable">
                <thead>
                  <tr>
                    <td>ID</td>
					<td>洗衣机名称</td>
					<td>洗衣机类型</td>
					<td>洗衣价格</td>
					<td>使用状态</td>
					<td>操作</td>
                  </tr>
                </thead>
                <tbody>
                <!-- el表达式-->
                <!-- varStatus  var的下标序号 -->
                <c:forEach items="${washer}" var="washer" varStatus="status">
					<tr>
						<td>${washer.id}</td>
						<td>${washer.name}</td>
						<td>${washer.type}</td>
						<td>${washer.price}</td>
						<td>${washer.status}</td>
						<td>
							<button class="btn btn-success" type="button" onclick="">修改</button>
							<button class="btn btn-danger" type="button" onclick="">删除</button>
						</td>
					</tr>	
				</c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    <script src="js/jquery-3.5.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>