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
	<table border="2" style="text-align: center">
		<tr>
			<th width="100px">所属用户ID</th>
			<th width="100px">所属用户名</th>
			<th width="100px">订单金额</th>
			<th width="100px">下单时间</th>
			<th width="100px">用户地址</th>
			<th width="100px">用户电话</th>
			<th width="100px">用户真实姓名</th>
			<th width="100px">订单详情</th>
		</tr>
		<c:forEach items="${orderbases}" var="ob">
			<tr>
				<td>${ob.user.uid}</td>
				<td>${ob.user.username}</td>
				<td>${ob.amount}</td>
				<td>${ob.orderdate}</td>
				<td>${ob.address}</td>
				<td>${ob.phone}</td>
				<td>${ob.name}</td>
			    <td><a href="orderitem?oderbase_id=${ob.orid}">查看详情</a></td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>