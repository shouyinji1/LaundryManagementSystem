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
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Company name</a>
	  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
	  	<span class="navbar-toggler-icon"></span>
	  </button>
	  <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
	  <ul class="navbar-nav px-3">
	    <li class="nav-item text-nowrap">
	      <a class="nav-link" href="#">Sign out</a>
	    </li>
	  </ul>
	</nav>

	<div class="container-fluid">
	  <div class="row">
	    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
	      <div class="sidebar-sticky pt-3">
	        <ul class="nav flex-column">
	          <li class="nav-item">
	            <a class="nav-link active" href="#">
	              <span data-feather="home"></span>
	              Dashboard <span class="sr-only">(current)</span>
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
	
	      <h2>Section title</h2>
	      <div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>项目 </th>
						<th>名称 </th>
						<th>电话 </th>
						<th>公司 </th>
						<th>完成度 </th>
						<th>任务</th>
						<th>时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">0.52/1.561</span></td>
						<td>20%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">6,9</span></td>
						<td>40%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">3,1</span></td>
						<td>75%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">4,9</span></td>
						<td>18%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">6,9</span></td>
						<td>40%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">0.52/1.561</span></td>
						<td>20%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">4,9</span></td>
						<td>18%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">0.52/1.561</span></td>
						<td>20%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">6,9</span></td>
						<td>40%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">3,1</span></td>
						<td>75%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">4,9</span></td>
						<td>18%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">6,9</span></td>
						<td>40%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>1</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">0.52/1.561</span></td>
						<td>20%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
					<tr>
						<td>4</td>
						<td>王者农药</td>
						<td>天美工作室</td>
						<td>(86) 1234 5678</td>
						<td>企鹅公司</td>
						<td><span class="pie">4,9</span></td>
						<td>18%</td>
						<td>2017.11.11</td>
						<td>
							<button class="btn btn-success btn-xs" type="button">查看</button>
							<button class=" btn btn-danger btn-xs" type="button">删除</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	    </main>
	  </div>
	</div>
	<script src="js/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <script src="js/dashboard.js"></script></body>
</html>
