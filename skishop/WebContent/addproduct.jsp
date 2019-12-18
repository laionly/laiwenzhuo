<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品页</title>
</head>
<body>
<form action="ProductAddServlet" method="get">
商品id:<input name="id" type="text" ><br>
商品名称:<input name="name" type="text" ><br>
商品描述:<input name="description" type="text"><br>
商品图片:<input name="listimg" type="text"><br>
商品价格:<input name="prince" type="text"><br>
打折价:<input name="discountprince" type="text"><br>
<input type="submit" value="添加">
</form>
</body>
</html>