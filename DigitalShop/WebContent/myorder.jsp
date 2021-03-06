<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title></title>



<script type="text/javascript"
	src="ManagementSystem/framework/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="ManagementSystem/framework/bootstrap.min.js"></script>
<link rel="styleone" type="text/css"
	href="ManagementSystem/css/bootstrap.css">

<!-- preloader CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/preloader.css">

<!-- prettyPhoto CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/prettyPhoto.css">

<!-- slider-pro CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/slider-pro.css">

<!-- slick CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/slick.css">

<!-- font-awesome CSS -->
<link rel="stylesheet" type="text/css"
	href="assets/css/font-awesome.css">

<!-- Main Style CSS CSS -->
<link rel="stylesheet" type="text/css" href="assets/css/style.css">

<!-- Fonts -->
<link
	href='https://fonts.googleapis.com/css?family=Yantramanav:300,400,500,700,900'
	rel='stylesheet' type='text/css'>
</head>


<body>
	<!-- Header -->
	<header class="header home">
		<!-- top-bar -->
		<div class="topbar pt-15 pb-15 mb-35">
			<div class="container">
				<div class="top-bar">
					<div class="top-bar__left pull">
						<div class="top-bar-register">
							<c:if test="${!empty(sessionScope.user.username) }"><a href="FindUserbyid?userid=${sessionScope.user.userid }" style="color: white;">欢迎你${sessionScope.user.username }</a></c:if>
			        	<c:if test="${!empty(sessionScope.user.username) }"><a href="MyFoavorites?userid=${sessionScope.user.userid }" style="margin-left: 20px">我的收藏</a></c:if>
			        	<c:if test="${!empty(sessionScope.user.username) }"><a href="MyOrder?userid=${sessionScope.user.userid }" style="margin-left: 20px">我的订单</a></c:if>
			        	<c:if test="${!empty(sessionScope.user.username) }"><a href="UserLogout" style="margin-left: 20px">退出登录</a></c:if>
			        	<c:if test="${empty(sessionScope.user.username) }">
								<a class="top-bar__item" href="register.jsp"> <i
									class="fa fa-user-o" aria-hidden="true"></i> 注册
								</a>
							</c:if>
						</div>
						<div class="top-bar-account">
							<c:if test="${empty(sessionScope.user.username) }">
								<a class="top-bar__item" href="login.jsp"> <i
									class="fa fa-lock" aria-hidden="true"></i> 登录
								</a>
							</c:if>
							<div class="content-dropdown left">
								<div class="account-inner ">
									<div class="login-form-head">
										<span class="login-form-title">登录</span> <span
											class="pull-right"> <a class="register-link"
											href="register.jsp" title="Register">创建一个账号</a>
										</span>
									</div>
									<form action="UserLoginServelt" method="get">
										<p>
											<label>用户名 <span class="required">*</span></label> <input
												name="username" type="text" required=""
												placeholder="Username">
										</p>
										<p>
											<label>密码 <span class="required">*</span></label> <input
												name="password" type="password" required=""
												placeholder="Password">
										</p>
										<button type="submit" data-button-action=""
											class="btn btn-primary btn-block">登陆</button>
										<input type="hidden" name="action" value=""> <input
											type="hidden" id="security-login" name="security-login"
											value="97915018af"><input type="hidden" name="login"
											value="">
									</form>
									<div class="login-form-bottom">
										<a href="#" class="lostpass-link" title="Lost your password?">忘记密码</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="top-bar__right">
						<div class="header-language item-dropdown">
							<a href="#" class="top-bar__item">English <i
								class="fa fa-angle-down"></i>
							</a>
							<ul class="content-dropdown">
								<li class="active"><a href="#">English</a></li>
								<li><a href="#">French</a></li>
								<li><a href="#">German</a></li>
							</ul>
						</div>
						<div class="header-currency item-dropdown">
							<a href="#" class="top-bar__item">USD <i
								class="fa fa-angle-down"></i>
							</a>
							<ul class="content-dropdown">
								<li><a href="#"><span class="symbol">€</span>EUR</a></li>
								<li class="active"><a href="#"><span class="symbol">$</span>USD</a></li>
								<li><a href="#"><span class="symbol">£</span>GBP</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- /Container -->
		</div>
		<!-- /top-bar -->

		<!-- header-main -->
		<div class="header-main">
			<div class="container">
				<nav id="nav" class="navbar">
					<div class="nav-collapse">
						<span></span>
					</div>
					<div class="navbar-header">
						<!-- Logo -->
						<div class="navbar-brand">
							<a class="logo" href="index.jsp"><img
								src="assets/images/logo.png" alt=""></a>
						</div>
						<!-- /Logo -->
					</div>
					<!--  Main navigation  -->

					<div class="otf-flex-item"></div>

					<ul class="main-nav nav navbar-nav navbar-right">
						<li class="dropdown"><a href="index.jsp">主页</a></li>
						<li class="dropdown"><a href="FindAllProductServlet">商品</a></li>
						<li class="dropdown"><a href="about.html">关于我们</a></li>

					</ul>
					<!-- /Main navigation -->
					<div class="otf-flex-item"></div>
					<div class="site-header -icon">
						<!-- search -->
						<div class="site-header__search">
							<div class="ps-search-btn">
								<i class="fa fa-search" aria-hidden="true"></i>
							</div>
							<div class="ps-search">
								<div class="ps-search__content">
									<a class="ps-search__close" href="#"><span></span></a>
									<h3 class="search_title">输入商品关键字</h3>
									<form method="get" class="searchform" action="#">
										<div class="wiget-search input-group">
											<input name="s" maxlength="40"
												class="form-control input-search" type="text" size="20"
												placeholder="Searching..."> <span
												class="input-group-addon input-large btn-search"> <span
												class="fa fa-search"></span> <input type="submit" class="fa"
												value="">
											</span>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- cart -->
						<div class="site-header__cart item-dropdown">
							<a href="cart.html" class="site-header__cart-toggle"> 
							<!-- <span class="cartcount">3</span>  --><i class="fa fa-shopping-basket"
								aria-hidden="true"></i> <span class="cartcost"><span
									class="money" data-currency-usd="$0.00">$0.00</span></span>
							</a>
							<div class="widget_shopping_cart_content  content-dropdown">
								<div class="cart_list ">								
								    <div class="media widget-product">
								     <c:forEach items="${cart.map}" var="entry">
								      <div class="media-left">
									      <a href="ProductDetails" class="image pull-left">
										      <img src="Productimg/upload/${entry.value.product.listimg}"  width="180" height="150" alt=""> 
										  </a>
								      </div>
								      <div class="cart-main-content media-body">
									      	<h3 class="name">
										      <a href="product_single.html">
										      	${entry.value.product.name}
										      </a>
									      	</h3>
									     	 <p class="cart-item">
									      		<span class="quantity">${entry.value.count} × <span class="price-amount amount"><span class="price-currencySymbol"></span>￥${entry.value.product.price}</span></span>  
									      	 </p>
									      <a href="RemoveCartServlet?productid=${entry.value.product.productid }" class="remove" title="Remove this item">×</a>
								      </div>
								        <p class="total"><strong>总价:</strong>
								         <span class="price-amount amount">
								         <span class="price-currencySymbol"></span>￥${entry.value.price}</span>
								       </p>
								      </c:forEach>
								    </div>
								    <!-- <div class="media widget-product">
								      <div class="media-left">
									      <a href="product_single.html" class="image pull-left">
										      <img src="assets/images/product/product_3.jpg" alt=""> 
										  </a>
								      </div>
								      <div class="cart-main-content media-body">
									      <h3 class="name">
										      <a href="product_single.html">
										      	Gym Training Gloves
										      </a>
									      </h3>
									      <p class="cart-item">
									      <span class="quantity">2 × <span class="price-amount amount"><span class="price-currencySymbol">$</span>250.00</span></span>           </p>
									      <a href="#" class="remove" title="Remove this item">×</a>
								      </div>
								    </div>
								     <div class="media widget-product">
								      <div class="media-left">
									      <a href="product_single.html" class="image pull-left">
										      <img src="assets/images/product/product_3.jpg" alt=""> 
										  </a>
								      </div>
								      <div class="cart-main-content media-body">
									      <h3 class="name">
										      <a href="product_single.html">
										      	Gym Training Gloves
										      </a>
									      </h3>
									      <p class="cart-item">
									      <span class="quantity">2 × <span class="price-amount amount"><span class="price-currencySymbol">$</span>200.00</span></span>           </p>
									      <a href="#" class="remove" title="Remove this item">×</a>
								      </div>
								    </div> -->
								 </div>
								
								  <p class="buttons clearfix">
								  <a href="cart.jsp" class="btn view-cart btn-default btn-normal pull-right">查看购物车</a>
								  <a href="checkout.jsp" class="btn check-out btn-primary btn-normal pull-left">结算</a>
							 	 </p>
							</div>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<!-- /header-main -->
	</header>
	<!-- header-mobile -->
	<div class="header-mobile">
		<div class="header-mobile-top">
			<div class="top-bar">
				<div class="header-language item-dropdown">
					<a href="#" class="top-bar__item">English <i
						class="fa fa-angle-down"></i>
					</a>
					<ul class="content-dropdown">
						<li class="active"><a href="#">English</a></li>
						<li><a href="#">French</a></li>
						<li><a href="#">German</a></li>
					</ul>
				</div>
				<div class="header-currency item-dropdown">
					<a href="#" class="top-bar__item">USD <i
						class="fa fa-angle-down"></i>
					</a>
					<ul class="content-dropdown">
						<li><a href="#"><span class="symbol">€</span>EUR</a></li>
						<li class="active"><a href="#"><span class="symbol">$</span>USD</a></li>
						<li><a href="#"><span class="symbol">£</span>GBP</a></li>
					</ul>
				</div>
			</div>
			<div class="site-header -icon">
				<!-- search -->
				<div class="site-header__search">
					<div class="ps-search-btn">
						<i class="fa fa-search" aria-hidden="true"></i>
					</div>
					<div class="ps-search">
						<div class="ps-search__content">
							<a class="ps-search__close" href="#"><span></span></a>
							<h3 class="search_title">Enter your keyword</h3>
							<form method="get" class="searchform" action="#">
								<div class="wiget-search input-group">
									<input name="s" maxlength="40"
										class="form-control input-search" type="text" size="20"
										placeholder="Searching..."> <span
										class="input-group-addon input-large btn-search"> <span
										class="fa fa-search"></span> <input type="submit" class="fa"
										value="">
									</span>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--end search -->
			</div>
		</div>

		<nav class="navbar">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- logo -->
				<div class="navbar-brand">
					<a class="logo" href="index.jsp"><img
						src="assets/images/logo.png" alt=""> </a>
				</div>
				<!-- logo -->
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active dropdown"><a href="index.html"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Home <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="../index.html">Home 1</a></li>
							<li><a href="../v3/index.html">Home 3</a></li>
						</ul></li>
					<li class="dropdown"><a href="product_grid.html"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Product <span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="product_grid.html">Product grid</a></li>
							<li><a href="product_list.html">Product list</a></li>
							<li><a href="product_sidebar.html">Product sidebar</a></li>
							<li><a href="product_single.html">Product single</a></li>
						</ul></li>
					<li class="dropdown"><a href="#l" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Page<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="404.html">Page 404</a></li>
						</ul></li>
					<li class="dropdown"><a href="blog.html"
						class="dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">Blog<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="blog.html">Blog Grid</a></li>
							<li><a href="blog_list.html">Blog List</a></li>
							<li><a href="blog_single.html">Single Blog</a></li>
						</ul></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="footer-mobile-bar">
		<ul class="columns-2">
			<li class="my-account"><a class="my-accrount-footer"
				href="account.jsp"> <i class="fa fa-user-o" aria-hidden="true"></i>
			</a></li>
			<li class="cart"><a class="footer-cart-contents"
				href="cart.html" title="View your shopping cart"> <i
					class="fa fa-shopping-basket" aria-hidden="true"></i> <span
					class="count">1</span>
			</a></li>
		</ul>
	</div>
	<!-- /Header -->

	<!-- =====================================
    	==== Start breadcrumb -->
	<div class="breadcrumb">
		<!-- container -->
		<div class="container">
			<h1>我的订单</h1>
			<ol class="item-breadcrumb">
				<li><a href="index.jsp">主页</a></li>
				<li>我的订单</li>
			</ol>
		</div>
		<%-- <c:if test="${empty(user)}">
			<p style="display: block; text-align: center;">订单为空</p>
		</c:if>
		<div class="account-form" style="width: 1510px; margin-left: 189px;">
			<c:if test="${!empty(user)}">
				<div class="cBody">
					<table class="table table-bordered table-hover">
						<tr>
							<th col style="width: 50px">收件人</th>
							<th col style="width: 50px">详细地址</th>
							<th col style="width: 50px">电话号码</th>
							<th col style="width: 50px">商品数量</th>
							<th col style="width: 50px">总价</th>
							<th col style="width: 50px">下单时间</th>
						</tr>
						<c:forEach var="i" items="${user.orders }">
							<tr> 
								<td><a href="Order_detail?orderid=${i.orderid }">${i.name}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.address}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.phone}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.number}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.orderprice}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.ordertime}</a></td>
							</tr>
						</c:forEach>
					</table>




				</div>
			</c:if>
		</div> --%>
		
		<c:if test="${empty(orderlist.list)}">
			<p style="display: block; text-align: center;">订单为空</p>
		</c:if>
		<div class="account-form" style="width: 1510px; margin-left: 189px;">
			<c:if test="${!empty(orderlist.list)}">
				<div class="cBody">
					<table class="table table-bordered table-hover">
						<tr>
							<th col style="width: 50px">收件人</th>
							<th col style="width: 50px">详细地址</th>
							<th col style="width: 50px">电话号码</th>
							<th col style="width: 50px">商品数量</th>
							<th col style="width: 50px">总价</th>
							<th col style="width: 50px">下单时间</th>
						</tr>
						<c:forEach var="i" items="${orderlist.list }">
							<tr> 
								<td><a href="Order_detail?orderid=${i.orderid }">${i.name}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.address}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.phone}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.number}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.orderprice}</a></td>
								<td><a href="Order_detail?orderid=${i.orderid }">${i.ordertime}</a></td>
							</tr>
						</c:forEach>
					</table>




				</div>
			</c:if>
		<div class="pages" style="margin-left:10px;">
				<button class="layui-btn layui-btn-xs" style="float: left;margin-left:5px;" onclick="window.location.href='MyOrderServlet?pagenum=${orderlist.prePageNum}'">上一页</button>
				<form class="layui-form" style="float: left" action="MyOrderServlet" method="post">
					<font style="margin-left:5px;">当前页数</font>
					<input style="margin-left:0px;width:25px;" type="text" name="nowpage" value="${orderlist.pageNum}"/>
					<font style="margin-left:5px;">总页数${orderlist.totalPageNum}</font>
					<input class="layui-btn layui-btn-xs" type="submit" value="跳转"/>
				</form>
				<button style="margin-left:5px;" class="layui-btn layui-btn-xs" onclick="window.location.href='MyOrderServlet?pagenum=${orderlist.nextPageNum}'">下一页</button>
			</div>
		

		<!-- /container -->
	</div>
	<!-- =====================================
    	==== End breadcrumb -->


	<!-- =====================================
    	==== Start account -->
	<div class="page-account">
		<!-- 个人信息 -->

		<!-- /个人信息 -->
	</div>
	<!-- =====================================
    	==== End account -->

	<!-- =====================================================================
    	==== Start footer -->
	<footer class="site-footer site-footer-1 clearfix">

		<div class="site-footer__main">
			<div class="container">
				<div class="row">
					<div
						class="col-md-3 col-sm-6 col-xs-12 footer-block footer-1 text-center">
						<h3 class="widget-title">Quick Links</h3>
						<ul>
							<li><a href="about.html">About Us</a></li>
							<li><a href="contact.html">Contact Us</a></li>
							<li><a href="blog.html">Blog</a></li>
							<li><a href="account.html">My Account</a></li>
							<li><a href="product_grid.html">Shop</a></li>
							<li><a href="account.html">Register</a></li>
						</ul>
					</div>
					<div
						class="col-md-6 col-sm-6 col-xs-12 footer-block footer-center text-center">
						<img src="assets/images/logo.png" alt="">
						<p class="address">
							Office: 972 Sylvan Street South Angelina, NL S0B2V9<br /> Phone:
							(633) 497-1888 / (062) 109-9222<br /> Email: example.com
						</p>
						<ul class="social">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-google"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
						</ul>
					</div>
					<div class="col-md-3 col-sm-12 col-xs-12 footer-block footer-3">
						<h3 class="widget-title">OPENING TIME</h3>
						<ul>
							<li><span>Monday :</span> <span>9am - 5pm</span></li>
							<li><span>Tuesday :</span> <span>9am - 1pm</span></li>
							<li><span>Wendsday :</span> <span>9am - 5pm</span></li>
							<li><span>Thursday :</span> <span>9am - 1pm</span></li>
							<li><span>Friday :</span> <span>9am - 1pm</span></li>
							<li><span>Saturday - Sunday :</span> <span>closed</span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="site-footer__copyright">
			<div class="container">
				<div class="copyright pull-left">
					Copyright &copy; 2019.Company name All rights reserved.<a
						target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
				</div>
				<div class="payment pull-right">
					<img src="assets/images/payment.png" alt="">
				</div>
			</div>
		</div>
	</footer>
	<!-- =====================================================================
    	==== End slider -->

	<!-- Back to top -->
	<div id="back-to-top"></div>
	<!--/ Back to top -->

	<!-- =====================================================================
    	==== Start preloader -->
	<div id="preloader">
		<div class="preloader">
			<span></span> <span></span> <span></span> <span></span>
		</div>
	</div>
	<!-- =====================================================================
    	==== End preloader -->

	<!-- =====================================
    	====Start all js here -->

	<!-- jquery js-->
	<script src="assets/js/jquery.min.js"></script>

	<!-- bootstrap js-->
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- slick js-->
	<script src="assets/js/slick.min.js"></script>

	<!-- spritespin js view  360-->
	<script src="assets/js/spritespin.min.js"></script>

	<!-- jquery-ui js price -->
	<script src="assets/js/jquery-ui.min.js"></script>

	<!-- sliderPro js -->
	<script src="assets/js/jquery.sliderPro.min.js"></script>

	<!-- prettyPhoto js-->
	<script src="assets/js/jquery.prettyPhoto.js"></script>

	<!-- counterup js-->
	<script src="assets/js/jquery.waypoints.js"></script>
	<script src="assets/js/jquery.counterup.min.js"></script>

	<!-- main js-->
	<script src="assets/js/custom.js"></script>

	<!-- =====================================
    	==== End all js here -->

</body>
</html>