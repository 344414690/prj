<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<form method="post" action="save">
		uname:<input type="text" name="uname" value="${info.uname }"><br />
		upwd:<input type="text" name="upwd" value="${info.upwd }"><br />
		请选择您的角色:
		<c:forEach items="${roles }" var="r">
			<input type="checkbox" name="chk" value="${r.rid }">${r.rname }
		</c:forEach><br/>
		<input type="submit" value="增加">
	</form>
</body>
</html>