<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="header">
   <br>
   <br>
   <br>
   <h1>欢迎进入后台管理系统</h1>
 </div>
 <div id="navigtaor">
    <ul>
      <li><a>商品管理</a>
        <ul>
         <li><a href="toaddproduct" target="center">添加商品</a></li>                                                                                                                                                                                                                           
         
         <li><a href="productlist" target="center">查询商品</a></li>
        </ul>
      </li>
      
      <li><a>类型管理</a>
        <ul>
         <li><a href="addtotype" target="center">添加类型</a></li>
         <li><a href="todelettype" target="center">删除类型</a></li>
        </ul>
      </li>
      
      
      <li><a>用户管理</a>
         <ul>
           <li><a href="finduser" target="center">查看用户</a></li>
         </ul>
      </li>
      
      <li><a>订单管理</a>
        <ul>
           <li><a href="findorder" target="center">查看用户订单</a></li>
        </ul>
      </li>
      <li><a href="exit">安全退出</a></li>
    </ul>
 </div>
</body>
</html>