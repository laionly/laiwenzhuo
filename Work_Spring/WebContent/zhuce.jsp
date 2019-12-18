<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页</title>
</head>
<body>
<form action="AddPersonServlet" method="get">
            <div class="zhuce">
                <span>用户注册</span>
                <p>用户名:</p>
                <input type="text" name="username" placeholder="请输入用户名(由1-15个字符组成)">

                <p>密码:</p>
                <input type="password" name="password" placeholder="请输入密码(不得大于9个字符)">
                
                <p>邮箱:</p>
                <input type="text" name="email" placeholder="请输入邮箱(不得大于20个字符)">

                <p>地址:</p>
                <input type="text" name="address" placeholder="请输入地址(不得大于20个字符)">
                <input type="submit" name="tijiao" value="注册" >
              <!--   <a href="#"><button class="button" type="button">注册</button></a> -->
            </div>
        </form>
</body>
</html>