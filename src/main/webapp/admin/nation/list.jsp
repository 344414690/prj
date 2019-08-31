<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<div id="app">
<!-- 双向绑定，用来查找发送请求地址来查找nation -->			<!-- 传递按键的值 -->
<input type="text" name="nation" v-model="nation" @keyup="findByNation($event)" style="width:175px" >
<table bgcolor="#FFFFCC" width="175px">					
	<tr v-for="n in json" bgcolor="#FFFFFF">
		<td @click="select(n.nation)">{{n.nation}}</td>
	</tr>
</table>
</div>
<script>
	window.onload = function(){
	    var vm = new Vue({
	        el:'#app',
	        data:{
	            json:'',
	            nation:''
	   	    },
	        methods:{
	        	findByNation:function(event){
	            	this.$http({
	                	method:'post', //  请求方式
	                	url:'findByNation',// 请求地址
	                	emulateJSON:true, 
	                	params:{ // 参数
		                	nation:this.nation
	                	},	
	                }).then(function(res){
		                this.json = res.body;
		               	//当按键不等于Backspance的时候，才只能下列代码【解决删除不了的问题】
		                if(event.code != 'Backspace')
		                //判断如果有一个值得话，直接填充数据
		              	if(this.json.length == 1){
							this.nation = this.json[0].nation;
							this.json='';
			              	}
	                },
	                function(){
	                    console.log('请求失败处理');
	                });
	            },
	            	// 用来控制请求，并且把获取到的值显示到文本框中
	            select:function(nation){
					this.nation=nation;
					// 选完民族之后把json数据清空
					this.json = '';
		         }
	        }
	    });
	}
</script>
    
