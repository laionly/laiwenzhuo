<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户页</title>
</head>
<body>
<!-- <form action="UserUpdateServlet" method="get"> -->
<form action="UserUpdate4Servlet" method="get">
<input type="hidden" name="id" value="${user.id}"/><br>
<input type="hidden" name="email" value="${user.email}"/><br>
姓氏:<input type="text" name="surname" value="${user.surname}"/><br>
名称:<input type="text" name="name" value="${user.name}"/><br>
密码:<input type="text" name="password" value="${user.password}"/><br>
<input type="submit" value="修改个人信息">
</form>

</body>
</html>