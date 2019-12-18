<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单列表</title>
		<link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473987_kibfmjoe139.css">
		<link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473973_wmm1qnjhr1.css" />
		<link rel="stylesheet" type="text/css" href="css/orderlist.css"/>
		<script src="jquery-2.2.4.min.js"></script>
		<script src="js/cookie.js"></script>
		<script src="js/orderlist.js"></script>
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
                        <li><a href="ShowCartServlet">去购物车</a></li>
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
	
		<div class="box">
			<h2 style="text-align: center;">确认订单</h2>
			<div class="adrress">
			
				<p class="user">${order.user.username }<span>${order.user.phone }</span></p>
				<p class="logo"><span class="iconfont icon-dizhi"></span>
				${order.user.address}
					
				</p>
			</div>
			<p class="qingdan">商品清单1件</p>
				<c:forEach items="${order.orderItems}" var="entry"> 
			<div class="tu">
			
				<img src="images/足球/${entry.product.listimg }"width="120px"height="120px">
				<span class="head">${entry.product.name}</span>
				<li>商品单价￥${entry.product.price}
				<br>
				<p>折扣价 <span>${entry.product.discountprice}</span></p>
				<span style="color: #000000;float: right;">商品数量x${entry.count}</span>
				</li>
			</div>
			<div class="xingxi">
				<p>订单编号：${entry.id}</p>
				<p>商品总价 <span>${entry.price}</span></p>
				<%-- <p>订单总价 <span>${order.price}</span></p> --%>
				
				<button>确认提交</button>
				<a href="index.html"><button>返回</button></a>
			
			
			<%-- </c:forEach> --%>
			</div>
			</c:forEach>
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