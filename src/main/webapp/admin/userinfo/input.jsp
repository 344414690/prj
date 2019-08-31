<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		/* 循环要修改的用户的角色  被选定回填角色数据  */
			<c:forEach items="${info.roles }" var="r">
				$("input[name=chk][value=${r.rid}]").attr("checked","checked")
			</c:forEach>
		});
</script>
</head>
<body>
	<!--  提交表单，如果info不为空则去修改页面，如果为空则去增加页面 -->
	<form method="post" action="${info==null?'save':'update' }">
		<!-- 修改用户的时候必须要用到用户的id  -->
		<input type="hidden" name="uid" value="${info.uid }">
		<!-- 修改用户的时候回填用户的name -->
		uname:<input type="text" name="uname" value="${info.uname }"><br />
		<!-- 修改用户的时候回填用户的pwd -->
		upwd:<input type="text" name="upwd" value="${info.upwd }"><br />
		请选择您的角色:
		<c:forEach items="${roles }" var="r">
			<input type="checkbox" name="chk" value="${r.rid }">${r.rname }
		</c:forEach><br/>
		<!--  提交表单，如果info不为空则去修改页面，如果为空则去增加页面 -->
		<input type="submit" value="${info==null?'增加':'修改' }">
	</form>
</body>
</html>