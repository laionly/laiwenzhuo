<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>购物车</title>
        <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1493843_jx3cr7mqjfp.css"/>
        <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473987_kibfmjoe139.css">
        <link rel="stylesheet" type="text/css" href="css/showcart.css">
        <script src="jquery-2.2.4.min.js"></script>
        <script src="js/cookie.js"></script>
		<script src="js/checklogin-showcart.js"></script>
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
                        <li><a href="ProductListServlet">商城</a></li>
                        <li><a id="showcart-1" href="ShowCartServlet">去购物车</a></li>
                        <li><a href="lianxi.html">联系我们</a></li>
                    </ul>
                </div>
            </div>
            <!-- 顶部导航右模块 -->
            <div class="header-right">
                <ul>
                    <li class="iconfont icon-icon-user"><a href=""></a></li>
                    <!-- <li class="iconfont icon-gouwuche"><a href=""></a></li> -->
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

    <!-- header顶部导航-管理员 -->
    <div class="header1">
        <!-- 包裹左右模块的div -->
        <div class="header1-wrap">
            <!-- 顶部导航左模块 -->
            <div class="header1-left">
                <div class="menu1">
                    <ul>
                        <li><a href="index.html">首页</a></li>
                        <li><a href="ProductListServlet">商城</a></li>
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
<div class="middle">
		<table border="" cellspacing="0" cellpadding="0" style="margin: 0 auto;text-align: center;">
			<tr>
				<td colspan="5"style="background-color: bisque;">购物车列表</td>
				<c:if test="${empty(cart.map) }">您还没购任何商品</c:if>
			</tr>	
   <c:if test="${!empty(cart.map) }"> 
  
			<tr style="background-color: yellow;">
				<td>商品名称</td>
				<td>单价/元</td>
				<td>数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cart.map}" var="entry">
			<tr>
				<td>${entry.value.product.name}</td>
				<td>${entry.value.product.discountprice}</td>
				<td>${entry.value.count}</td>
				<td>${entry.value.price}</td>
				<td><a href="deleteItem?id=${entry.value.product.id}">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2">总价</td>
				<td colspan="2">${cart.price}</td>
				<td>清空购物车</td>
			</tr>
			
			</c:if>
			<tr>
				<td colspan="5"><a href="UserAddOrderServlet"><button id="btn">提交订单</button></a></td>
			</tr>
		</table>
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