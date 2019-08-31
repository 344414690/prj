<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body >
<h3>日志查看</h3>
<div id="app">
	uname:<input type="text" name="uname" v-model="uname">
	action：<input type="text" name="action" v-model="action">
	<button type="submit" @click="get()">查询</button>
		<table border="1" width="800">
			<tr align="center">
				<td>序号</td>
				<td>用户id</td>
				<td>用户姓名</td>
				<td>操作行为</td>
				<td>操作时间</td>
			</tr>
				<tr v-for="log in json.logList" align="center">
					<td>{{log.logid }}</td>
					<td>{{log.uid }}</td>
					<td>{{log.uname }}</td>
					<td>{{log.action}}</td>
					<td>{{log.actiontime}}</td>
				</tr>
		</table>
		<table border="1" width="800">
			<tr align="center">
				<td><button @click="first()">首页</button></td>
				<td><button @click="before()">上一页</button></td>
				<td><button @click="next()">下一页</button></td>
				<td><button @click="end()">末页</button></td>
				<td>第<input id="pageNow" type="text" name="pageNow" size="1" v-model="pageNow">页</td>
				<td>一页<input type="text" name="limit" size="1" v-model="limit">条</td>
				<td>{{json.page.pageNow}}/共{{json.page.pageCount}}页</td>
				<td>共 {{json.page.count}}条记录</td>
				<td><input type="button" @click="get()" value="跳转"></td>
			</tr>
		</table>
</div>
</body>
</html>
<script>
window.onload = function(){
    var vm = new Vue({
        el:'#app',
        data:{
            json:'',
            pageNow:1,// 当前页
            limit:10,// 显示多少数据
            uname: '',
            action:''
        },
        mounted:function(){// 请求网站就调用该方法
        	this.get();
        },
        methods:{ // 函数体
            get:function(){ 
            	this.$http({
                	method:'post',// 发送post请求
                	url:'findJSON',//请求 findJSON方法
                	emulateJSON:true, // post有中文必须要改变请求格式
                	params:{// 请求的时候传递参数
                		pageNow:this.pageNow, // 赋值
                		limit:this.limit,// 赋值
                		uname:this.uname,
                		action:this.action,
                	}// 参数列表
                }).then(function(res){
					this.json = res.body;
            	},function(){
            		console.log('请求失败处理');
                });
            },// get函数
            first:function(){
				this.pageNow = 1;
				this.get();
            },
           	next:function(){
				this.pageNow = paseInt(this.pageNow)+1;
				this.get();
            },
            before:function(){
				this.pageNow = paseInt(this.pageNow)-1;
				this.get();
            },
            end:function(){
				this.pageNow = this.json.page.pageCount;
				this.get();
            }
        } // method函数框
    });// Vue框
}// 加载框
</script>

