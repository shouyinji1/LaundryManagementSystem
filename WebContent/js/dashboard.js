/* globals Chart:false, feather:false */

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

function changeMenu(menuName){
	/* 获取 iframe  dom对象        修改src属性 */
	//document.getElementById("main").src=menuName;
	document.getElementsByClassName("embed-responsive-item")[0].src=menuName;
}

function updateUserInfo(){
	var data = $("#fm1").serialize(); 
	$.ajax({
			type:'post',  
			url:'toUpdateUserInfo.do', 
			cache: false,
			data:data,  //重点必须为一个变量如：data
			dataType:'text', 
			success:function(res){      
				if(res=='yes'){
					  alert("修改成功！");
					  location.reload();
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
