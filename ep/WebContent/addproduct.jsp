<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>

 <form action="addproduct" method="post" enctype="multipart/form-data" >
  商品名称:<input type="text" name="name" /><br/>
  
  商品价格:<input type="text"  name="price" /><br/>
  
  折后价格:<input type="text"  name="rprice" /><br/>
  
  商品图片:<input type="file" name="picture" ><br/>
 
 商品类型:
       
         <select name="pt_id">
          <c:forEach items="${producttype}" var="producttype">
           <option value="${producttype.ptid}">${producttype.typename}</option>
            </c:forEach>  
         </select>
          
  <input type="submit" value="添加">
  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
 </form>
</body>
</html>