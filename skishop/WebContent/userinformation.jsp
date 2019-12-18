<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
<c:forEach items="${users }" var="u">
<div>
姓氏:<span>${u.surname}</span><br>
名称:<span>${u.name}</span><br>
邮箱:<span>${u.email}</span><br>
密码:<span>${u.password}</span><br>
<span><a href="UserUpdate3Sevlet?id=${u.id}">修改</a></span>
<span><a href="Userdelete2Servlet?id=${u.id}">删除</a></span>
<%-- <span><a href="UserUpdate2Servlet?email=${u.email}">修改</a></span> --%>
<%-- <span><a href="UserDeleteServlet?email=${u.email}">删除</a></span> --%>
</div>
</c:forEach>
</body>
</html>