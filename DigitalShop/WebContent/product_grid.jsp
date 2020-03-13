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
				            <a class="top-bar__item" href="register.jsp">
				            	<i class="fa fa-user-o" aria-hidden="true"></i>
				            	注册
				            </a>
				            </c:if>
				        </div>
			            <div class="top-bar-account">
			            <c:if test="${empty(sessionScope.user.username) }">
				            <a class="top-bar__item" href="login.jsp">
				            	<i class="fa fa-lock" aria-hidden="true"></i>
				            	登录
				            </a>
				            </c:if>
			            	<div class="content-dropdown left">
								<div class="account-inner ">
									<div class="login-form-head">
										<span class="login-form-title">登录</span> <span
											class="pull-right"> <a class="register-link"
											href="account.html" title="Register">创建一个账号</a>
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
						<li class="dropdown active"><a href="index.jsp">主页</a></li>
						<li class="dropdown"><a href="FindAllProductServlet">商品</a></li>
						<li class="dropdown"><a href="about.jsp">关于我们</a></li>
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
						     	<h3 class="search_title">请输入商品关键字</h3>
						        <form method="get" class="searchform" action="SearchProductnameServlet">
									<div class="wiget-search input-group">
									 <input name="name" maxlength="40" class="form-control input-search"  type="text" size="20" placeholder="Searching..."> 
									 <span class="input-group-addon input-large btn-search"> 
									 	<!-- <span class="fa fa-search"></span> -->
										<input type="submit" class="fa" value="搜索"> 
									 </span>
									</div>
								</form>
						      </div>
						    </div>
							
						</div>
						<!-- cart -->
						<div class="site-header__cart item-dropdown">
							<a href="cart.jsp" class="site-header__cart-toggle"> <!-- <span class="cartcount">3</span> -->
								<i class="fa fa-shopping-basket" aria-hidden="true"></i> <span
								class="cartcost"><span class="money"
									data-currency-usd="$0.00">$0.00</span></span>
							</a>

							<div class="widget_shopping_cart_content  content-dropdown">
								<div class="cart_list ">
									<div class="media widget-product">

										<c:forEach items="${cart.map}" var="entry">
											<div class="media-left">
												<a href="ProductDetails" class="image pull-left"> <img
													src="Productimg/upload/${entry.value.product.listimg}"
													width="180" height="150" alt="">
												</a>
											</div>
											<div class="cart-main-content media-body">
												<h3 class="name">
													<a href="product_single.html">
														${entry.value.product.name} </a>
												</h3>
												<p class="cart-item">
													<span class="quantity">${entry.value.count} × <span
														class="price-amount amount"><span
															class="price-currencySymbol"></span>￥${entry.value.product.price}</span></span>
												</p>
												<a
													href="RemoveCartServlet?productid=${entry.value.product.productid }">×</a>
											</div>
											<p class="total">
												<strong>总价:</strong> <span class="price-amount amount">
													<span class="price-currencySymbol"></span>￥${entry.value.price}
												</span>
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
									<a href="cart.jsp"
										class="btn view-cart btn-default btn-normal pull-right">查看购物车</a>
									<a href="checkout.jsp"
										class="btn check-out btn-primary btn-normal pull-left">结算</a>
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
					<a class="logo" href="index.html"><img
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
				href="account.html"> <i class="fa fa-user-o" aria-hidden="true"></i>
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
			<h1>商品</h1>
		</div>
		<!-- /container -->
	</div>
	<!-- =====================================
    	==== End breadcrumb -->


	<!-- =====================================
    	====Start archive-product -->
	<div class="archive-product">
		<!-- Container -->
		<div class="container">
			<!-- product-shorting -->
			<div
				class="product-shorting d-flex align-items-center justify-content-between">
				<div class="grid-list-view">
					<ul class="nav tabs-area">
						<li class="active"><a data-toggle="tab" href="#grid-view">
								<i class="fa fa-th"></i>
						</a></li>

					</ul>
					<span class="show-items">Showing 1 to 9</span>
				</div>
				<div class="toolbar-sorter">
					<select name="orderby" class="orderby">
						<option value="menu_order" selected="selected">Default
							sorting</option>
						<option value="popularity">Sort by popularity</option>
						<option value="rating">Sort by average rating</option>
						<option value="date">Sort by newness</option>
						<option value="price">Sort by price: low to high</option>
						<option value="price-desc">Sort by price: high to low</option>
					</select>
				</div>
			</div>
			<!--/product-shorting -->


			<!-- tab-content -->
			<div class="tab-content">
				<div id="grid-view" class="tab-pane fade in active">
					<div class="product products-grid">
						<div class="row row-products">

							<!-- ===================================== 商品项  =======================-->
							<c:if test="${!empty list}">
								<c:forEach items="${list}" var="p">
							
							
								<div class="col-md-4 col-sm-6">

									<div class="product-block" data-publish-date="">
										<div class="product-image product_1">
											<div class="product-thumbnail">
												<a href="ProductDetails?productid=${p.productid}"
													title=""> <img src="Productimg/upload/${p.listimg}">
												</a>
											</div>
												<!-- <div class="tawcvs-swatches color_selector" data-attribute_name="attribute_pa_color">
	                        					<span class="swatch swatch-color swatch-blue" title="Blue" data-value="blue">Blue</span>
	                        					<span class="swatch swatch-color swatch-orange" title="Orange" data-value="orange">orange</span>
	                        					<span class="swatch swatch-color swatch-purple" title="Purple" data-value="purple">Purple</span>
	                        					</div> -->
											<div class="product-actions">

												<c:if test="${p.collect!=0}">
													<a
														href="CollectDeleteServlet?productid=${p.productid}&cid=${p.collect}&flag=0&pagenum=${product.pageNum}"
														data-id="" class="btn wishlist product-quick-whistlist"
														title="取消收藏"> <i class="fa fa-heart"
														style="color: red"></i>
													</a>
												</c:if>
												<c:if test="${p.collect==0}">
													<a
														href="CollectAddServlet?productid=${p.productid}&flag=0&pagenum=${product.pageNum}"
														data-id="" class="btn wishlist product-quick-whistlist"
														title="添加收藏"> <i class="fa fa-heart-o"></i>
													</a>
												</c:if>

												<a href="" data-id=""
													class="btn product-quick-view btn-quickview"
													title="Quickview"> <i class="fa fa-eye"></i>
												</a> <a href="" data-id=""
													class="btn product-quick-compare btn-compare"
													title="Compare"> <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div>
										<!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating=""> <span
												class="star-rating"> <i class="fa fa-star-o"></i> <i
													class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
													class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
											</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="ProductDetails?productid=${p.productid}" title="">
													${p.name} </a>
											</h4>
											<div class="product-price">
												<span class="amout"> <span class="money"
													data-currency-usd="">￥${p.price}</span>
												</span> <a href="CartServlet?productid=${p.productid}"
													class="add_to_cart_button">添加购物车</a>
											</div>

										</div>
										<!-- /.product-meta -->
									</div>
									
								</div>
							</c:forEach>
							
							</c:if>
							
							<!-- ==================== -->
							
							<c:if test="${empty list}">
								<c:forEach items="${product.list}" var="p">
							
							
								<div class="col-md-4 col-sm-6">

									<div class="product-block" data-publish-date="">
										<div class="product-image product_1">
											<div class="product-thumbnail">
												<a href="ProductDetails?productid=${p.productid}"
													title=""> <img src="Productimg/upload/${p.listimg}">
												</a>
											</div>
												<!-- <div class="tawcvs-swatches color_selector" data-attribute_name="attribute_pa_color">
	                        					<span class="swatch swatch-color swatch-blue" title="Blue" data-value="blue">Blue</span>
	                        					<span class="swatch swatch-color swatch-orange" title="Orange" data-value="orange">orange</span>
	                        					<span class="swatch swatch-color swatch-purple" title="Purple" data-value="purple">Purple</span>
	                        					</div> -->
											<div class="product-actions">

												<c:if test="${p.collect!=0}">
													<a
														href="CollectDeleteServlet?productid=${p.productid}&cid=${p.collect}&flag=0&pagenum=${product.pageNum}"
														data-id="" class="btn wishlist product-quick-whistlist"
														title="取消收藏"> <i class="fa fa-heart"
														style="color: red"></i>
													</a>
												</c:if>
												<c:if test="${p.collect==0}">
													<a
														href="CollectAddServlet?productid=${p.productid}&flag=0&pagenum=${product.pageNum}"
														data-id="" class="btn wishlist product-quick-whistlist"
														title="添加收藏"> <i class="fa fa-heart-o"></i>
													</a>
												</c:if>

												<a href="" data-id=""
													class="btn product-quick-view btn-quickview"
													title="Quickview"> <i class="fa fa-eye"></i>
												</a> <a href="" data-id=""
													class="btn product-quick-compare btn-compare"
													title="Compare"> <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div>
										<!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating=""> <span
												class="star-rating"> <i class="fa fa-star-o"></i> <i
													class="fa fa-star-o"></i> <i class="fa fa-star-o"></i> <i
													class="fa fa-star-o"></i> <i class="fa fa-star-o"></i>
											</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="ProductDetails?productid=${p.productid}" title="">
													${p.name} </a>
											</h4>
											<div class="product-price">
												<span class="amout"> <span class="money"
													data-currency-usd="">￥${p.price}</span>
												</span> <a href="CartServlet?productid=${p.productid}"
													class="add_to_cart_button">添加购物车</a>
											</div>

										</div>
										<!-- /.product-meta -->
									</div>
									
								</div>
							</c:forEach>
							
							</c:if>
							
							<!-- ===================================== 商品项  =======================-->
						</div>
					</div>

				</div>
			</div>
			<!-- /tab-content -->

			<!-- pagination -->
			<c:if test="${empty list}">
				<div>
					<a href="FindAllProductServlet?pagenum=1">首页</a> <a
						href="FindAllProductServlet?pagenum=${product.prePageNum}">上一页</a>
					第<span>${product.pageNum}</span>页 <a
						href="FindAllProductServlet?pagenum=${product.nextPageNum}">下一页</a>
					<a href="FindAllProductServlet?pagenum=${product.totalPageNum}">尾页</a>
				</div>
			</c:if>

			<!-- /pagination -->
		</div>
	</div>
	<!-- =====================================
    	====End archive-product -->


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
							<li><a href="about.jsp">About Us</a></li>
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
						<h3 class="widget-title">ABOUT us</h3>
						<ul>

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

	<!-- Preloader -->
	<div id="preloader">
		<div class="preloader">
			<span></span> <span></span> <span></span> <span></span>
		</div>
	</div>
	<!-- /Preloader -->

	<!-- ================================================================
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

	<!-- ================================================================
    	==== End all js here -->

</body>
</html>