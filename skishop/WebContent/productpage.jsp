<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实现分页</title>
</head>
<body>
<table border=2 align="center">
	<tr align="center">
		<td>商品名称</td>
		<td>商品描述</td>
		<td>商品价格</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${page.list}" var="product">
		<tr align="center">
			<td>${product.name }</td>
			<td>${product.description}</td>
			<td>${product.prince }</td>
			<td>操作</td>
		</tr>
	</c:forEach>
	<tr>
	<td colspan="3">
	<a href="productpage?pageNum=1">首页</a>
	<a href="productpage?pageNum=${page.prePageNum}">上一页</a>
	<a href="productpage?pageNum=${page.nextPageNum}">下一页</a>
	<a href="productpage?pageNum=${page.totalPageNum}">末页</a>
	一共有${page.totalCount}条数据,当前是第${page.pageNum}页
	</td>
	</tr>
	</table>
</body>
</html>