<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页</title>
</head>
<body>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
function checkUsername(username) {
    if(username==""||username==null) {
        alert("用户名为空");
        return;
    }
    $.ajax({
        url:"CheckUsernameServlet",
        type:"get",
        dataType:"json",
        data:{
            username:username
        },
        success:function(data){
        	console.log(data.status);
            if(data.status==0) {
                alert("用户名已存在！");
            }
        }
    });
}
</script>
<form action="AddUserServlet" method="get">
            <div class="zhuce">
                <span>用户注册</span>
                <p>用户名:</p>
                <input type="text" name="username" id="username" placeholder="请输入用户名(由1-15个字符组成)" onblur="checkUsername(this.value)">

                <p>密码:</p>
                <input type="password" name="password" placeholder="请输入密码(不得大于9个字符)">
                
                <p>邮箱:</p>
                <input type="text" name="email" placeholder="请输入邮箱(不得大于20个字符)">

                <p>地址:</p>
                <input type="text" name="address" placeholder="请输入地址(不得大于20个字符)">
                <input type="submit" name="tijiao" value="注册" >
            </div>
        </form>
</body>
</html>