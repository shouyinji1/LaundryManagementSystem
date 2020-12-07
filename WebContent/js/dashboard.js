/* globals Chart:false, feather:false */


$(function(){
    $("#menu1").click(function() {
        $("a").removeClass('active');  // 删除其他li元素的样式
        $(this).addClass('active');	// 添加当前元素的样式
    });
    $("#menu2").click(function() {
        $("a").removeClass('active');  // 删除其他li元素的样式
        $(this).addClass('active');	// 添加当前元素的样式
    });
    $("#menu3").click(function() {
        $("a").removeClass('active');  // 删除其他li元素的样式
        $(this).addClass('active');	// 添加当前元素的样式
    });
    $("#menu4").click(function() {
        $("a").removeClass('active');  // 删除其他li元素的样式
        $(this).addClass('active');	// 添加当前元素的样式
    });
});

function loadWasher(){
	$.ajax({  
		url:"selectAllWasherServlet.do",//servlet文件的名称
		type:"GET",
		success:function(e){
			alert("servlet调用成功！");
		},
		error : function() {
			alert("异常请求！"+data.msg);
		}
	});
}


function updateUserInfo(){
	var data = $("#fm1").serialize(); 
	$.ajax({
			type:'post',  
			url:'updateUserInfo.do', 
			cache: false,
			data:data,  //重点必须为一个变量如：data
			dataType:'text', 
			success:function(res){      
				if(res=='yes'){
					  alert("修改成功！");
					  location.reload();
				}else if(res=='userIsExist'){
					alert("使用该新用户名的用户已存在");
				}else
					alert("修改失败！");
			},
			error:function(){ 
				 alert("请求失败")
			}
	})
}

function showModal(id){
	//打开隐藏的模态框
	$(id).modal();
	//设置模态框剧中
	$(id).on('show.bs.modal', function(){
		var $this = $(this);
		var $modal_dialog = $this.find('.modal-dialog');
		//设置为块级元素     inline 内联元素
		$this.css('display', 'block');
		$modal_dialog.css({'margin-top': Math.max(0, ($(window.parent).height() - $modal_dialog.height()) / 2) - 50 });
	});
} 

// 在模态窗口关闭后重置表单
$('.modal').on('hidden.bs.modal', function(){
    $(this).find('form')[0].reset();
});

(function () {
  'use strict'

  feather.replace()

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        'Sunday',
        'Monday',
        'Tuesday',
        'Wednesday',
        'Thursday',
        'Friday',
        'Saturday'
      ],
      datasets: [{
        data: [
          15339,
          21345,
          18483,
          24003,
          23489,
          24092,
          12034
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
})()
