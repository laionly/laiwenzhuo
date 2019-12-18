$(document).ready(function () {
    // setCookie('code', 201, 1)
    // setCookie('id',1,1)
    // setCookie('name', 'username', 1)
    // setCookie('password', 'password', 1)
    // setCookie('phone', 1231231123, 1)
    // setCookie('email', 'obj.emial', 1)
    // setCookie('address', 'obj.address', 1)
    // 这两句是判断用户是否处于登录状态的，原理是成功登录之后将名为code的cookie存入浏览器，getCookie获取，以此判断是否登录
        if (getCookie('code')== 200) {
            alert('您已成功登录，点击确定返回首页')
            window.location.href = "index.html"
        }else if(getCookie('code')==201){
            alert('您已成功登录，点击确定返回首页')
            window.location.href = "index.html"
        }
    // 用户登录按钮的点击事件
    $('#u').click(function () {        
        if ($('.denglu input[type=user]').val() == '') {
            alert('未填写用户名!')
        } else if ($('.denglu input[type=password]').val() == '') {
            alert('未填写密码!')
        } else if (($('.denglu input[type=user]').val().length < 1 || $(
                '.denglu input[type=user]').val().length > 15) ||
            $('.denglu input[type=password]').val().length > 9
        ) {
            alert('请按正确规则填写')
        } else if (($('.denglu input[type=user]').val().length >= 1 && $(
                '.denglu input[type=user]').val().length <= 15) &
            $('.denglu input[type=password]').val().length <= 9
        ) {
            var json = {//将input值封装成一个对象
                username: $('.denglu input[type=user]').val(),
                password: $('.denglu input[type=password]').val()
            }
            // 连接接口，传上面封装好的对象，然后将接口传回来的json转成object。
            $.post('http://192.168.19.52:8080/SportsMall/loginuser', json, function (data,status,xhr) {
                console.log(data)
                var obj = JSON.parse(data)  //把json转成object
                console.log(obj)  
                if (obj.code == 200) {  //返回的code值是200，就会进行以下操作：把传回来的东西存入Cookie里，方便修改个人信息界面打印数据
                    alert('用户登录成功，点击确定后返回首页')
                    setCookie('code', 200, 1)
                    setCookie('id',obj.id,1)
                    setCookie('name', obj.username, 1)
                    setCookie('password', obj.password, 1)
                    setCookie('phone', obj.phone, 1)
                    setCookie('email', obj.email, 1)
                    setCookie('address',obj.address, 1)
                    window.location.href = "index.html"
                } else {
                    alert('登录失败')
                }
            })
        }
    })

    //管理员登录按钮的点击事件
    $('#a').click(function () {         
        if ($('.denglu input[type=user]').val() == '') {
            alert('未填写用户名!')
        } else if ($('.denglu input[type=password]').val() == '') {
            alert('未填写密码!')
        } else if (($('.denglu input[type=user]').val().length < 1 || $(
                '.denglu input[type=user]').val().length > 15) ||
            $('.denglu input[type=password]').val().length > 9
        ) {
            alert('请按正确规则填写')
        } else if (($('.denglu input[type=user]').val().length >= 1 && $(
                '.denglu input[type=user]').val().length <= 15) &
            $('.denglu input[type=password]').val().length <= 9
        ) {
            var json = {   //将input值封装成一个对象
                username: $('.denglu input[type=user]').val(),
                password: $('.denglu input[type=password]').val()
            }
            // 连接接口，传上面封装好的对象，然后将接口传回来的json转成object。
            $.post('http://192.168.19.15:8080/SportsMall/loginadmin',json,function(data,status,xhr){    
                console.log(data)
                var obj = JSON.parse(data)  //把json转成object
                // console.log(obj)  这个obj就是将接口传回来的东西转成object对象，你想知道里面有什么就console.log
                if (obj.code == 201) {  //返回的code值是201，就会进行以下操作：把传回来的东西存入Cookie里，方便修改个人信息界面打印数据
                    alert('管理员登录成功，点击确定后返回首页')
                    setCookie('code', 201, 1)
                    setCookie('id',obj.id,1)
                    setCookie('name', obj.loginname, 1)
                    setCookie('password', obj.password, 1)
                    setCookie('phone', obj.phone, 1)
                    setCookie('email', obj.email, 1)
                    setCookie('text', obj.address, 1)
                    window.location.href = "index.html"
                } else {
                    alert('登录失败')
                } 
            })
        }
    })
    
    //登录表单失去焦点事件
    $('.denglu input[type=user]').blur(function () {
        $(this).css('border-color', '')
        if ($(this).val() == '') {
            $(this).css('border-color', 'red')
            $(this).attr('placeholder', '未填写用户名!')
        } else if ($(this).val().length < 1) {
            alert('用户名不得小于1个字符!')
            $(this).css('border-color', 'red')
        } else if ($(this).val().length > 15) {
            alert('用户名不得大于15个字符!')
            $(this).css('border-color', 'red')
        }
    })
    $('.denglu input[type=password]').blur(function () {
        $(this).css('border-color', '')
        if ($(this).val() == '') {
            $(this).css('border-color', 'red')
            $(this).attr('placeholder', '未填写密码!')
        } else if ($(this).val().length > 9) {
            alert('密码不得大于9个字符!')
            $(this).css('border-color', 'red')
        }
    })
})