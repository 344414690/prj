<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户管理</h3>
	<table border="1" width="100%" >
		<tr align="center">
			<td>uid</td>
			<td>uname</td>
			<td>roles</td>
			<td>upwd</td>
			<td>状态</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<c:forEach items="${list }" var="userinfo">
			<tr align="center">
				<td>${userinfo.uid }</td>
				<td>${userinfo.uname }</td>
				<td>${userinfo.roles }</td>
				<td>${userinfo.upwd }</td>
				<td>${userinfo.isdelete?'正常':'已删除'}</td><!-- 显示用户状态 -->
				<td><a href="${!userinfo.isdelete?'delete':'revoke' }?uid=${userinfo.uid}">
				<!-- 判断用户的状态，用来调用哪个方法  -->
				${userinfo.isdelete?'删除':'恢复'}</a></td>
				<td><a href="findById?uid=${userinfo.uid }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="goInput">Save</a>
</body>
</html>