<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" style="text-align:center">
 <tr>
  <th width="200px">用户ID</th>
  <th width="200px">用户名</th>
  <th width="200px">用户密码</th>
  <th width="200px">用户地址</th>
  <th width="200px">用户邮箱</th>
  <th width="200px">删除用户</th>
 </tr>
 <c:forEach items="${users}" var="users">
   <tr>
    <td>${users.uid}</td>
    <td>${users.username}</td>
    <td>${users.password}</td>
    <td>${users.address}</td>
    <td>${users.phone}</td>
    <td>${users.email}</td>
    <td><a href="deleteuser?uid=${users.uid }">删除</a></td>
   </tr>
   </c:forEach>
 </table>
</body>
</html>