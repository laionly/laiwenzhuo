<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>商城</title>
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473987_kibfmjoe139.css">
    <link rel="stylesheet" type="text/css" href="css/shoplist.css">
    <script src="jquery-2.2.4.min.js"></script>
    <script src="js/cookie.js"></script>
    <script src="js/shoplist.js"></script>

</head>

<body>
    <!-- header顶部导航-用户 -->
    <div class="header">
        <!-- 包裹左右模块的div -->
        <div class="header-wrap">
            <!-- 顶部导航左模块 -->
            <div class="header-left">
                <div class="menu">
                    <ul>
                        <li><a href="index.html">首页</a></li>
                        <li><a id="shopplist-1" href="ProductListServlet">商城</a></li>
                        <li><a href="ShowCartServlet">去购物车</a></li>
                        <!-- <li><a href="">经验交流</a></li> -->
                        <li><a href="lianxi.html">联系我们</a></li>
                    </ul>
                </div>
            </div>
            <!-- 顶部导航右模块 -->
            <div class="header-right">
                <ul>
                    <li class="iconfont icon-icon-user"><a href=""></a></li>
                    <li class="iconfont icon-gouwuche"><a href=""></a></li>
                </ul>
            </div>
            <!-- 划过图标出现div -->
            <div class="yonghu">
                <div class="yonghubg"></div>
                <a href="login.html"><button>登录</button></a>
                <a href="zhuce.html"><button>注册</button></a>
            </div>
            <!-- 登出和个人信息 -->
            <div class="yonghu1">
                <div class="yonghubg1"></div>
                <a href="#"><button>登出</button></a>
                <a href="#"><button>信息</button></a>
            </div>
        </div>
    </div>

    <!-- header顶部导航-管理员——————————————————————————————————————————————————————————————————————————————————— -->
    <div class="header1">
        <!-- 包裹左右模块的div -->
        <div class="header1-wrap">
            <!-- 顶部导航左模块 -->
            <div class="header1-left">
                <div class="menu1">
                    <ul>
                        <li><a href="index.html">首页</a></li>
                        <li><a id="shopplist-2" href="ProductListServlet">商城</a></li>
                        <li><a href="AdminAllListServlet">管理员列表</a></li>
                        <li><a href="UserAllListServlet">用户列表</a></li>
                        <li><a href="ProductAllListServlet">商品列表</a></li>
                    </ul>
                </div>
            </div>
            <!-- 顶部导航右模块 -->
            <div class="header1-right">
                <ul>
                    <li class="iconfont icon-icon-user"><a href=""></a></li>
                    <!-- <li class="iconfont icon-gouwuche"><a href=""></a></li> -->
                </ul>
            </div>
            <!-- 划过用户图标出现的div -->
            <div class="yonghu">
                <div class="yonghubg"></div>
                <a href="login.html"><button>登录</button></a>
                <a href="zhuce.html"><button>注册</button></a>
            </div>
            <!-- 登录后更改信息 -->
            <div class="yonghu2">
                <div class="yonghubg2"></div>
                <a href="#"><button>登出</button></a>
                <a href="#"><button>信息</button></a>
            </div>
        </div>
    </div>
    <!-- —————————————————————————————————————————————————————————————————————————————————————————————————————— -->
 
    <div class="middle">
        <div class="nav">
            <ul>
                <li>
                    <a id="bsk" href="#">篮球</a>
                    <a id="ftb" href="#">足球</a>
                    <a id="yumao" href="#">羽毛球</a>
                    <a id="bingpang" href="#">兵乓球</a>
                </li>
            </ul>
        </div>
        <ul class="box">
        <c:forEach items="${product_zq }" var="p">
            <li><a href="ProductParticularServlet?id=${p.id}"><img src="images/足球/${p.listimg}" width="300px" height="300">
                    <p><span>价格：￥${p.discountprice}</span><del>￥${p.price}</del><span style="color: #000000;">${p.name }</span></p>
                </a></li>
                
                </c:forEach> 
                
        </ul>
        <ul class="box1">
        <c:forEach items="${product_lq }" var="p">   
            <li><a href=""><img src="images/篮球/${p.listimg}" width="300px" height="300">
                    <p><span>价格：￥${p.discountprice}</span><del>￥${p.price}</del><span style="color: #000000;">${p.name }</span></p>
                </a></li>
                </c:forEach>
        </ul>
        <ul class="box2">
        <c:forEach items="${product_zq }" var="p">
            <li><a href=""><img src="images/足球/${p.listimg}" width="300px" height="300">
                    <p><span>价格：￥${p.discountprice}</span><del>￥${p.price}</del><span style="color: #000000;">${p.name }</span></p>
                </a></li>
                </c:forEach>
                
        </ul>
        <ul class="box3">
        <c:forEach items="${product_ymq }" var="p">
            <li><a href=""><img src="images/羽毛球/${p.listimg}" width="300px" height="300">
                    <p><span>价格：￥${p.discountprice}</span><del>￥${p.price}</del><span style="color: #000000;">${p.name }</span></p>
                </a></li>
                </c:forEach>

        </ul>
        <ul class="box4">
        <c:forEach items="${product_ppq }" var="p">
            <li><a href=""><img src="images/兵乓球/${p.listimg}" height="300">
                    <p><span>价格：￥${p.discountprice}</span><del>￥${p.price}</del><span style="color: #000000;">${p.name }</span></p>
                </a></li>
                </c:forEach>
        </ul>
    </div>


    <!-- 底部导航 -->
    <div class="footer">
        <div class="footer-wrap">
            <div class="row">
                <div class="footer-ul">
                    <ul>
                        <h4>商品</h4>
                        <li><a href="#">篮球</a></li>
                        <li><a href="#">足球</a></li>
                        <li><a href="#">羽毛球</a></li>
                    </ul>
                </div>
                <div class="footer-ul">
                    <ul>
                        <h4>关于</h4>
                        <li><a href="#">价格</a></li>
                        <li><a href="#">质量</a></li>
                        <li><a href="#">保障
                            </a></li>
                    </ul>
                </div>
                <div class="footer-ul">
                    <ul>
                        <h4>客户支持</h4>
                        <li><a href="lianxi.html">联系我们</a></li>
                        <li><a href="#">订单跟踪</a></li>
                        <li><a href="personal.html">个人信息</a></li>
                    </ul>
                </div>
                <div class="footer_bottom">
                    <div class="copy">
                        <p>世纪之歌小组.</p>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>

</html>