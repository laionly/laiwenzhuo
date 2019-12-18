$(document).ready(function () {
    if (getCookie('code') == 200) {        //200是用户登录
        $('.icon-gouwuche').click(function(){
            window.location.href="ShowCartServlet"
        })
        $('.icon-icon-user').hover(function () {
            $('.yonghu1').css('display', 'block') //登出和个人信息框
        })
        $('.yonghu1').hover(function () {
            $('.yonghu1').css('display', 'block')
        }, function () {
            $('.yonghu1').css('display', 'none')
        })
    } else if (getCookie('code') == 201) {  //201是管理员登录
        alert('管理员用户不开放购物车功能')
        window.location.href = "index.html"
        $('.header-wrap').css('display','none')
        $('.header1-wrap').css('display','block')
        
        $('.icon-icon-user').hover(function () {
            $('.yonghu2').css('display', 'block') //登出和个人信息框
        })
        $('.yonghu2').hover(function () {
            $('.yonghu2').css('display', 'block')
        }, function () {
            $('.yonghu2').css('display', 'none')
        })
    } else {  //如果没有获取到Cookie值，也就是没登录成功，样式为以下
        alert('请先登录')
        window.location.href = "login.html"
        $('.header-wrap').css('display','block')
        $('.header1-wrap').css('display','none')
        $('.icon-gouwuche').click(function(){
            alert('您还未登录，请先登录')
            window.location.href="login.html"
        })
        $('.icon-icon-user').hover(function () {
            $('.yonghu').css('display', 'block') //登录和注册
        })
        $('.yonghu').hover(function () {
            $('.yonghu').css('display', 'block')
        }, function () {
            $('.yonghu').css('display', 'none')
        })
    }

    // 用户导航的登出和个人信息
    $('.yonghu1 a').eq(0).click(function () {
        clearCookie('code')
        clearCookie('id')
        clearCookie('name')
        clearCookie('password')
        clearCookie('phone')
        clearCookie('email')
        clearCookie('text')
        alert('成功注销')
        window.location.href = "index.html"
    })
    $('.yonghu1 a').eq(1).click(function () {
        window.location.href = "personal.html"
    })

    // 管理员导航的登出和个人信息
    $('.yonghu2 a').eq(0).click(function () {
        clearCookie('code')
        clearCookie('id')
        clearCookie('name')
        clearCookie('password')
        clearCookie('phone')
        clearCookie('email')
        clearCookie('text')
        alert('成功注销')
        window.location.href = "index.html"
    })
    $('.yonghu2 a').eq(1).click(function () {
        window.location.href = "personal.html"
    })
})