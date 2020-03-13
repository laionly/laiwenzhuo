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
  <th width="200px">类型ID</th>
  <th width="200px">类型名称</th>
  <th width="200px">删除操作</th>
 </tr>
 <c:forEach items="${producttype}" var="producttype">
   <tr>
    <td>${producttype.ptid}</td>
    <td>${producttype.typename}</td>
    <td><a href="deleteProductType?ptid=${producttype.ptid }">删除</a></td>
   </tr>
   </c:forEach>
 </table>

</body>
</html>