<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
</head>
<body>
	<form action="login" method="get">
		<div class="denglu">
			<span>登录</span>
			<p>用户名:</p>
			<input type="text" name="username" placeholder="请输入用户名">
			</p>
			<p>密码:</p>
			<input type="password" name="password" placeholder="请输入密码">
			<input type="submit" name="Submit" class="button" value="登录">
		</div>
	</form>
</body>
</html>