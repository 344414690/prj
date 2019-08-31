<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>js/easyui/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$.ajaxSetup({ // 设置ajax全局变量
		  global: true,// 全局设置
		  async: false,// 关闭异步请求
		  cache:false // 关闭缓存
		});
	$(function(){
		$('#dg').datagrid({   
		    url:'findAll',  // 发送请求 
		    fitColumns:true, // 设置为true将自动使列适应表格宽度
		    striped:true,// 设置为true将交替显示行背景。
		    pagination:true,//显示分页工具栏
		    pageSize:20,// 默认显示页数
		    toolbar: '#tb',// 工具栏
		    title:'学生管理',// 标题
		    columns:[[   
		        {field:'stid',checkbox:'checkbox',title:'编号',width:100,align:'center'},   
		        {field:'stname',title:'学生姓名',width:100,align:'center'},   
		        {field:'stsex',title:'性别',width:100,align:'center',formatter: function(value,row,index){
						if(value){
							return '男'; 
						}else {
							return '女 ';
						} 
		          	} 
		        },  
		        {field:'score',title:'成绩',width:100,align:'center',styler: function(value,row,index){
					if (value < 30){
						return 'color:red';
					}
				}
			        },
		        {field:'operate',title:'操作',width:100,align:'center',formatter: function(value,row,index){
						var btn = "<a id=\"btn\" href=\"javascript:deleteItem("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-remove'\">删除</a>";
						btn +="<a id=\"btn\" href=\"javascript:findById("+row.stid+")\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-edit'\">编辑 </a>"
						return btn;
					}
			    }     
		    ]],
		    onLoadSuccess: function(index,field,value){ // 渲染机制 
					$('.easyui-linkbutton').linkbutton({  
				});  
			}
		});  
	})
	
	// 删除函数
	function deleteItem(stid){
		$.messager.confirm('Confirm','是否删除?',function(r){  // 删除弹窗 
		    if (r){   
		    $.getJSON("delete",{stid:stid},function(json){// 发送json删除学生，并返回json数据
			    	$.messager.show({
			    		title:'删除',
			    		msg:json.msg,// 显示消息
			    		timeout:5000,
			    		showType:'slide'
			    	});
					$('#dg').datagrid('reload'); // 删完重新刷新页面
				});   
		    }   
		}); 
	}
	// 批量删除函数
	function deleteBatch(){
		var stidString = "";
		var selections = $('#dg').datagrid('getSelections');  // 获取到所有被选中的对象
		for(var i = 0;i < selections.length;i++){// 循对象
				stidString = selections[i].stid;// 取到每个对象的ID
				if(i < selections.length -1)// 给每个对象拼接逗号
				stidString += ",";
			}
		$.messager.confirm('Confirm','是否删除?',function(r){  // 删除弹窗 
		    if (r){   
		    $.getJSON("deleteBatch",{stidString:stidString},function(json){// 发送json删除学生，并返回json数据
			    	$.messager.show({
			    		title:'删除',
			    		msg:json.msg,// 显示消息
			    		timeout:5000,
			    		showType:'slide'
			    	});
					$('#dg').datagrid('reload'); // 删完重新刷新页面
				});   
		    }   
		}); 
	}
	// 修改数据
	function findById(stid){//  传递参数stid用来找到student对象
		$('#ff').form('clear');	// 从URL加载 		
		$('#win').window('open');  // open a window 
			$.getJSON("findById",{stid:stid},function(json){
				$('#ff').form('load',json);	// 从URL加载
				 var sex = json.stsex?0:1;
				$("input[name=stsex][value="+sex+"]").prop('checked','true');
			});
	}
	// 弹窗
	function openForm(stid){ 
			$('#ff').form('clear');// 每次打开增加就清空内容
			$('#win').window('open'); 
			$("input[name=stsex][value=0]").prop('checked','true');
	}
	// 增加学生
	function dosave(){
		var stid = $("#stid").val();// 获取到学生的id
		var path = "save";// 定义请求路径
		if(stid!=null&&stid!=""&&stid!=undefined){
				path ="update";// 
			}
			$('#ff').form('submit', {   
			    url:path,   // 请求地址
			    onSubmit: function(){  
			    },   
			    success:function(data){   
			       var json = eval("("+data+")")//转换json格式
			       $.messager.show({
			    		title:'删除',
			    		msg:json.msg,// 显示消息
			    		timeout:5000,
			    		showType:'slide'
			    	});
			       $('#win').window('close'); 
					$('#dg').datagrid('reload'); 
			    }   
			});  
		}
</script>
</head>
<body>
<table id="dg"></table> 
<div id="tb">
<a href="javascript:deleteBatch()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">批量删除</a>
<a href="javascript:openForm()" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true">增加</a>
</div>
<div id="win" class="easyui-window" title="增加学生" style="width:600px;height:400px"  
        data-options="iconCls:'icon-save',modal:true,closed:true" > 
        <h3 align="center">学生管理</h3> 
<form id="ff" method="post">  
	<input type="hidden" name="stid" id="stid">
    <div align="center">  
        <label for="stname">学生姓名:</label>  
        <input class="easyui-validatebox" type="text" name="stname" data-options="required:true" />  
    </div>  
    <div align="center">  
        <label for="stsex">学生性别:</label> 
        <input type="radio" value="0" name="stsex" >男 <input type="radio" value="1" name="stsex">女
    </div>  
    <div align="center">  
        <label for="score">学生成绩:</label>  
        <input class="easyui-numberbox" type="text" name="score" data-options="required:true" />  
    </div>
    <div align="center">  
    	<input type="button" onclick="dosave()" value="保存">
    </div>
</form>  
</div> 
</body>
</html>