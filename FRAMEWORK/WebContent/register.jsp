<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/registerUser.do" method="post">
		用户名：<input type="text">
		密码：<input type="text">
		<input type="submit" value="提交">
		<input type="reset" value="重置"> 
	</form>
</body>
</html>