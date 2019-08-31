<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<h3>日志查看</h3>
<form action="findAll" method="post">
uname:<input type="text" name="uname" value="${log.uname }">
action：<input type="text" name="action" value="${log.action }">
<button type="submit">查询</button>
	<table border="1" width="800">
		<tr align="center">
			<td>序号</td>
			<td>用户id</td>
			<td>用户姓名</td>
			<td>操作行为</td>
			<td>操作时间</td>
		</tr>
		<c:forEach items="${logList }" var="log">
			<tr align="center">
				<td>${log.logid }</td>
				<td>${log.uid }</td>
				<td>${log.uname }</td>
				<td>${log.action }</td>
				<td><fmt:formatDate value="${log.actiontime }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>
	<table border="1" width="800">
		<tr align="center">
			<td><a href="javascript:first(1)">首页</a></td>
			<td><a href="javascript:before(${page.pageNow - 1 })">上一页</a></td>
			<td><a href="javascript:next(${page.pageNow + 1},${page.pageCount })">下一页</a></td>
			<td><a href="javascript:end(${page.pageCount})">末页</a></td>
			<td>跳转到<input id="pageNow" type="text" name="pageNow" size="1" value="${page.pageNow }">页</td>
			<td>一页<input type="text" name="limit" size="1" value="${page.limit }">条</td>
			<td>${page.pageNow } / 共${page.pageCount }页</td>
			<td>共 ${page.count }条记录</td>
			<td><button type="submit">Go</button></td>
		</tr>
	</table>
</form>
</body>
</html>
<script>
	function first(pageNow){
		document.getElementById("pageNow").value = pageNow;
		document.forms[0].submit();
	}
	
	function before(pageNow){
		if(pageNow != 0){
			document.getElementById("pageNow").value = pageNow;
		}else{
			document.getElementById("pageNow").value = 1;
		}
		document.forms[0].submit();
	}
	
	function next(pageNow,pageCount){
		if(pageNow < pageCount){
			document.getElementById("pageNow").value = pageNow;
		}else{
			document.getElementById("pageNow").value = pageCount;
		}
		document.forms[0].submit();
	}
	
	function end(pageCount){
		document.getElementById("pageNow").value = pageCount;
		document.forms[0].submit();
	}
</script>
