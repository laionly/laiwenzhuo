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
			<th width="100px">商品数量</th>
			<th width="100px">商品名称</th>
			<th width="100px">商品价格</th>
			<th width="100px">商品折后价</th>
		</tr>
		   <c:forEach items="${orderitems}" var="orderitems">
			<tr>
				<td>${orderitems.shopnum}</td>
				<td>${orderitems.productname}</td>
				<td>${orderitems.price}</td>
				<td>${orderitems.rprice}</td>
			</tr>
	       </c:forEach>
	</table>
</body>
</html>