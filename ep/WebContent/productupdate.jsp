<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="updateproduct" method="post" enctype="multipart/form-data" >
 <input type="hidden" name="pid" value="${product.pid}"><br>
商品名称:<input type="text" name="name" value="${product.name}"  /><br>
商品价格:<input type="text" name="price" value="${product.price}"  /><br>
折后价格:<input type="text" name="rprice" value="${product.rprice}"/><br>
商品图片:<img src="/ep/upload/${product.picture}">
       <input type="file" name="mf" /><br>
商品类型:<input type="text" name="product_type" value="${product.product_type.typename}"/><br>
        <input type="hidden" name="pt_id" value="${product.pt_id}"><br>
     <input type="hidden" name="picture" value="${product.picture}"><br>
<input type="submit" value="修改"><br>
 </form>
</body>
</html>