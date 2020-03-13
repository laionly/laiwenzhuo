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
<form action="productlist" method="get">
  <table border="2" style="text-align:center">
 <tr>
  
  <th width="200px">商品名称</th>
  <th width="200px">商品价格</th>
  <th width="200px">折后价格</th>
  <th width="200px">商品类型</th>
  <th width="200px">删除操作</th>
  <th width="200px">修改操作</th>
 </tr>
 <c:forEach items="${products}" var="products">
   <tr>
    <td>${products.name}</td>
    <td>${products.price}</td>
    <td>${products.rprice}</td>
    <td>${products.product_type.typename}</td>
    <td><a href="deleteProduct?pid=${products.pid }">删除</a></td>
    <td><a href="updateproduct?pid=${products.pid }">修改</a></td>
   </tr>
   </c:forEach>
 </table>
</form>
</body>
</html>