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
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">洗衣房管理</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
		<li class="navbar px-0 dropdown"><a class="nav-link text-nowrap" href="#" data-toggle="dropdown">Sign out</a>
		  <ul class="dropdown-menu dropdown-menu-md-right">
			<li><a class="dropdown-item" href="#"><i class="fa fa-cog fa-lg"></i>个人信息</a></li>
			<li><a class="dropdown-item" href="#"><i class="fa fa-user fa-lg"></i>修改密码</a></li>
			<li><a class="dropdown-item" href="#"><i class="fa fa-sign-out fa-lg"></i>退出登录</a></li>
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
			  <iframe class="embed-responsive-item" src="washerListServlet.do" onload="this.height=this.contentWindow.document.body.scrollHeight" width="100%" scrolling="no" frameborder="0"></iframe>

			</div>
	    </main>
	  </div>
	</div>
	<script src="js/jquery-3.5.1.min.js"></script>
	<script src="bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script src="js/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <script src="js/dashboard.js"></script></body>
</html>
