<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
	$.ajaxSetup({ // 设置ajax全局变量
	  global: true,// 全局设置
	  type: "POST",// 全局请求都是post
	  async: false,// 关闭异步请求
	  cache:false // 关闭缓存
	});
	
	var ps; // 声明变量ps存放省
	var cs;// 声明变量ps存放市

	$(function(){
		$.ajax({// 发起ajax请求
			   url: "findAll",// 访问那个方法
			   dataType:"json",// 返回的数据类型
			   success: function(msg){// success是返回的信息，msg是返回的数据
					ps = msg;
				    fillP();
			   }
		});
	});

 	function fillP(){// 省
	 	$.each(ps,function(i,item){ 
 	 		$("#p").append("<option value="+i+">"+item.pname+"</option>")
 	 	 	}); 
	 	 	fillC(0);// 为了开始显示数据
 	 	}

	function fillC(index){// 市
		$("#c").empty();
 	 	cs = ps[index].citys;
 	 	$.each(cs,function(i,item){
 	 		$("#c").append("<option value="+i+">"+item.cname+"</option>")
 	 	 	});
 	 	fillZ(0);// 为了开始显示数据
 	 	}
	function fillZ(index){// 区
		$("#z").empty();
		var zs = cs[index].zones;
 	 	$.each(zs,function(i,item){
 	 		$("#z").append("<option value="+i+">"+item.zname+"</option>")
 	 	 	});
 	 	} 
</script>

省
<SELECT id="p" NAME="" onchange="fillC(this.value)">
</SELECT>
市
<SELECT id="c" NAME="" onchange="fillZ(this.value)">
</SELECT>
区
<SELECT id="z" NAME="">
</SELECT>