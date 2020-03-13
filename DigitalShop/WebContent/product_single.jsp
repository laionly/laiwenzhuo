<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

	<!-- Main Style CSS CSS -->
	<link rel="stylesheet" type="text/css" href="assets/css/style.css">

	 <!-- Fonts --> 
	<link href='https://fonts.googleapis.com/css?family=Yantramanav:300,400,500,700,900' rel='stylesheet' type='text/css'>
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
							<a href="#" class="top-bar__item">English
								<i class="fa fa-angle-down"></i>
							</a>
							<ul class="content-dropdown">
								<li class="active"><a href="#">English</a></li>
								<li><a href="#">French</a></li>
								<li><a href="#">German</a></li>
							</ul>
						</div>
						<div class="header-currency item-dropdown">
							<a href="#" class="top-bar__item">USD
								<i class="fa fa-angle-down"></i>
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
							<a class="logo" href="index.jsp"><img src="assets/images/logo.png" alt=""></a> 
						</div>
						<!-- /Logo -->
					</div>
					<!--  Main navigation  -->

					<div class="otf-flex-item"></div>
					
					<ul class="main-nav nav navbar-nav navbar-right">
						<li class="dropdown active">
							<a href="index.jsp">主页</a>
						</li>
			         	<li class="dropdown">
			         		<a href="FindAllProductServlet">商品</a>
			         	</li>
			         	<li class="dropdown"><a href="about.jsp">关于我们</a></li>
					</ul>
					<!-- /Main navigation -->
					<div class="otf-flex-item"></div>
					<div class="site-header -icon">
						<!-- ====== 商品查询 =========== -->
							<div class="site-header__search">
				            <div class="ps-search-btn">
				              	 <i class="fa fa-search" aria-hidden="true"></i>
				            </div>
				            <div class="ps-search">
						     <div class="ps-search__content">
						     	<a class="ps-search__close" href="#"><span></span></a>
						     	<h3 class="search_title">请输入商品编号或商品关键字</h3>
						        <form method="get" class="searchform" action="SearchProductnameServlet">
									<div class="wiget-search input-group">
									 <input name="name" maxlength="40" class="form-control input-search"  type="text" size="20" placeholder="Searching..."> 
									 <span class="input-group-addon input-large btn-search"> 
									 	<span class="fa fa-search"></span>
										<input type="submit" class="fa" value=""> 
									 </span>
									</div>
								</form>
						      </div>
						    </div>
						</div>
							<!-- cart -->
				      	<div class="site-header__cart item-dropdown">
					        <a href="cart.html" class="site-header__cart-toggle">
					          <!-- 	<span class="cartcount">3</span> -->
					           <i class="fa fa-shopping-basket" aria-hidden="true"></i>
					            <span class="cartcost"><span class="money" data-currency-usd="$0.00">$0.00</span></span>
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
	<!-- <div class="header-mobile">
		<div class="header-mobile-top">
	        <div class="top-bar">
				<div class="header-language item-dropdown">
					<a href="#" class="top-bar__item">English
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="content-dropdown">
						<li class="active"><a href="#">English</a></li>
						<li><a href="#">French</a></li>
						<li><a href="#">German</a></li>
					</ul>
				</div>
				<div class="header-currency item-dropdown">
					<a href="#" class="top-bar__item">USD
						<i class="fa fa-angle-down"></i>
					</a>
					<ul class="content-dropdown">
						<li><a href="#"><span class="symbol">€</span>EUR</a></li>
						<li class="active"><a href="#"><span class="symbol">$</span>USD</a></li>
						<li><a href="#"><span class="symbol">£</span>GBP</a></li>
					</ul>
				</div>
			</div>
			<div class="site-header -icon">
				search
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
									 <input name="s" maxlength="40" class="form-control input-search" type="text" size="20" placeholder="Searching..."> 

									 <span class="input-group-addon input-large btn-search"> 
									 	<span class="fa fa-search"></span>
									 	<input type="submit" class="fa" value=""> 
									 </span>
									</div>
								</form>
						    </div>
					    </div>
					</div>
				end search -->
		    </div>
	    </div>
		
		<!-- <nav class="navbar">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      logo
		      <div class="navbar-brand">
		      	<a class="logo" href="index.html"><img src="assets/images/logo.png" alt=""> </a> 
		      </div>
		      logo
		    </div>

		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      	<ul class="nav navbar-nav">
			        <li class="active dropdown">
			          	<a href="index.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Home <span class="caret"></span></a>
			          	<ul class="dropdown-menu">
				          	<li><a href="../index.html">Home 1</a></li>
				            <li><a href="../v3/index.html">Home 3</a></li>
			         	</ul>
		       		</li>
			        <li class="dropdown">
			          	<a href="product_grid.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Product <span class="caret"></span></a>
			          	<ul class="dropdown-menu">
				          	<li><a href="product_grid.html">Product grid</a></li>
			            	<li><a href="product_list.html">Product list</a></li>
			                <li><a href="product_sidebar.html">Product sidebar</a></li>
			            	<li><a href="product_single.html">Product single</a></li>
			         	</ul>
		       		</li>
		       		<li class="dropdown">
			          	<a href="#l" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Page<span class="caret"></span></a>
			          	<ul class="dropdown-menu">
				            <li><a href="faq.html">FAQ</a></li>
					        <li><a href="404.html">Page 404</a></li>
			         	</ul>
		       		</li>
		       		 <li class="dropdown">
			          	<a href="blog.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Blog<span class="caret"></span></a>
			          	<ul class="dropdown-menu">
				            <li><a href="blog.html">Blog Grid</a></li>
			                <li><a href="blog_list.html">Blog List</a></li>
			            	<li><a href="blog_single.html">Single Blog</a></li>
			         	</ul>
		       		</li>
		       		<li><a href="contact.html">Contact</a></li>
		      	</ul>
		    </div>
		</nav> -->
	</div>
	<div class="footer-mobile-bar">
		<ul class="columns-2">
			<li class="my-account">
				<a class="my-accrount-footer" href="account.html">
					<i class="fa fa-user-o" aria-hidden="true"></i>
				</a>          
			</li>
			<li class="cart">
				<a class="footer-cart-contents" href="cart.html" title="View your shopping cart">
					<i class="fa fa-shopping-basket" aria-hidden="true"></i>
					<span class="count">1</span>
				</a>
			</li>
		</ul>
    </div>
	<!-- /Header -->

	
	<!-- =====================================
    	==== Start breadcrumb -->
   	<div class="breadcrumb">
   		<!-- container -->
		<div class="container">
			<h1>Sport Standard Edition</h1>
			<ol class="item-breadcrumb">
	            <li><a href="index.html">Home</a></li>
	            <li><a href="product_grid.html">Audio</a></li>
	            <li>Sport Standard Edition</li>     
            </ol>
		</div>
		<!-- /container -->
   	</div>
    <!-- =====================================
    	==== End breadcrumb -->


	<!-- =====================================
    	==== Start single-product -->
	<div class="single-product">
		<!-- Container -->
		<div class="container">
			<!-- Row -->
			<div class="row">
				<div class="product-info">
					<div class="col-md-6">
						<div class="row">
						
	                        <ul class="featuredPostSlider col-md-10 col-sm-11">
			                     <li>
			                        <img class="product-featured-image product_selector_1" src="Productimg/upload/${product.listimg}" alt="">
			                    </li>
			                    <!--  <li>
			                        <img class="product-featured-image" src="assets/images/product_single/product_single_2.jpg" alt="">
			                    </li>		                     
			                    <li>
			                        <img class="product-featured-image" src="assets/images/product_single/product_single_3.jpg" alt="">
			                    </li>
			                     <li>
			                        <img class="product-featured-image" src="assets/images/product_single/product_single_1.jpg" alt="">
			                    </li>
			                     <li>
			                        <img class="product-featured-image" src="assets/images/product_single/product_single_5.jpg" alt="">
			                    </li>  -->
	                   		</ul>
		                    <div id="slick-page">
			                    <div class="pagerNavigation pagerNavigationTop">
			                        <span class="top"><i class="fa fa-angle-up"></i></span>                        
			                    </div>                    
			                    <div class="slick-pager">
			                      	<a data-slide-index="1" href="javascript:void(0)">    
			                      	  <img class="product-featured-image" src="Productimg/upload/${product.listimg}" alt="">                   
			                      	</a>
			                      	<!-- <a data-slide-index="3" href="javascript:void(0)">    
			                      	  <img class="product-featured-image" src="assets/images/product_single/product_single_2.jpg" alt="">                   
			                      	</a>
			                      	<a data-slide-index="4" href="javascript:void(0)">    
			                      	  <img class="product-featured-image" src="assets/images/product_single/product_single_3.jpg" alt="">                   
			                      	</a>
			                      	<a data-slide-index="5" href="javascript:void(0)">    
			                      	  <img class="product-featured-image" src="assets/images/product_single/product_single_1.jpg" alt="">                   
			                      	</a>
			                      	<a data-slide-index="6" href="javascript:void(0)">    
			                      	  <img class="product-featured-image" src="assets/images/product_single/product_single_5.jpg" alt="">                   
			                      	</a> -->
			                      
			                    </div>
			                    <div class="pagerNavigation pagerNavigationBottom">                        
			                        <span class="bottom"><i class="fa fa-angle-down"></i></span>
			                    </div>
			                </div>
			                 
		                </div>
			 		</div>
			 		<div class="col-md-6">
						<div class="product-meta clearfix">
							<span class="product-rating" data-rating="">
								<span class="star-rating">
									<i class="fa fa-star-o"></i>
									<i class="fa fa-star-o"></i>
									<i class="fa fa-star-o"></i>
									<i class="fa fa-star-o"></i>
									<i class="fa fa-star-o"></i>
								</span>
							</span>
							<!-- end rating -->
							<h4 class="product-name">
								<a href="#" title="">${product.name}</a>
							</h4><!-- /.product-product -->

							<div class="product-price">
								<span class="amout">
									<span><span class="money" data-currency-usd="$150.00">￥${product.price}</span></span>
								</span>
							</div><!-- /.product-price -->
							<div class="excerpt">
							 ${product.description}
						       <!--  Revolutionary multi-touch interface. iPod touch features the same multi-touch screen
								technology as iPhone. Pinch to zoom in on a photo. Scroll through your songs and videos
								with a flick. Flip throug..   
								<ul>
									<li>Fits true to size. Take your normal size</li>
									<li>This jersey is designed for a close fit with a stretch finish</li>
									<li>Model wears a M</li>
									<li>Model measures: chest 38"/ 96cm, height 6'1"/ 185cm</li>
								</ul>    -->        
						    </div>

                            <table class="variations">
                            	<tbody>
                            		
                            		<tr>
                            			<td class="label"><label>Size:</label></td>
                            			<td class="value">
                            				<div class="tawcvs-swatches" id="size_selector" data-attribute_name="attribute_pa_size">
                            					<span class="swatch swatch-label swatch-l" title="L" data-value="l">L</span>
                            					<span class="swatch swatch-label swatch-m" title="M" data-value="m">M</span>
                            					<span class="swatch swatch-label swatch-s" title="S" data-value="s">S</span>
                            					<span class="swatch swatch-label swatch-xl" title="XL" data-value="xl">XL</span>
                            				</div>
                            			</td>
                            		</tr>
                            		<tr>
                            			<td class="label"><label>Color:</label></td>
                            			<td class="value">
                            				<div class="tawcvs-swatches color_selector" data-attribute_name="attribute_pa_color">
                            					<span class="swatch swatch-color swatch-blue" title="Blue" data-value="blue">Blue</span>
                            					<span class="swatch swatch-color swatch-green" title="Green" data-value="green">Green</span>
                            					<span class="swatch swatch-color swatch-orange" title="orange" data-value="orange">orange</span>
                            					<span class="swatch swatch-color swatch-purple" title="Purple" data-value="purple">Purple</span>
                            					<span class="swatch swatch-color swatch-red" title="Red" data-value="red">Red</span>
                            				</div>
                            			</td>
                            		</tr>
                            	</tbody>
                            </table>

						    <div class="product-footer">
								<form action="#" class="add-to-cart" method="post" enctype="multipart/form-data">
									<input class="cart-qty-box" type="number" name="qtybutton" value="0">
									<input type="hidden" name="id" value="">
								</form>
								<a href="CartServlet?productid=${product.productid }" class="btn btn-primary">添加购物车<i class="fa fa-shopping-bag" aria-hidden="true"></i></a>
								<div class="product-actions">
									
									<c:if test="${collect!=0}">
										<a href="CollectDeleteServlet?productid=${product.productid}&cid=${collect}&flag=1" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
											<i class="fa fa-heart" style="color:red"></i>
										</a>
									</c:if>
									<c:if test="${collect==0}">
										<a href="CollectAddServlet?productid=${product.productid}&flag=1" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
											<i class="fa fa-heart-o"></i>
										</a>
									</c:if>

									<a href="" data-id="" class="btn product-quick-compare btn-compare" title="Compare">
									    <i class="fa fa-retweet"></i>
									</a>
								</div>
							</div>
							<div class="social-sharing">
								<h6 class="text-uppercase">Share:</h6>
                                <a class="facebook social-icon" href="#"><i class="fa fa-facebook"></i></a>
                                <a class="twitter social-icon" href="#"><i class="fa fa-twitter"></i></a>
                                <a class="pinterest social-icon" href="#"><i class="fa fa-pinterest"></i></a>
                                <a class="gplus social-icon" href="#"><i class="fa fa-google-plus"></i></a>
                                <a class="linkedin social-icon" href="#"><i class="fa fa-linkedin"></i></a>
							</div>
						</div><!-- /.product-meta -->
			 		</div>
			 	</div>
			 	<!-- product-tab-description -->
			 	<div class="col-md-12 product-description-tabs">
	                <ul class="nav">
					    <li class="active"><a data-toggle="tab" href="#tab_description">Description</a></li>
					    <li><a data-toggle="tab" href="#tab_information">Additional information</a></li>
					    <li><a data-toggle="tab" href="#tab_reviews">Review (${count })</a></li>
					</ul>
					<div class="tab-content">
					    <div id="tab_description" class="tab-pane fade in active">
					      	In a urna a ipsum lacinia fermentum id nec est. Ut eleifend neque at rutrum malesuada. Aenean dignissim rhoncus felis, sed varius eros elementum vitae. Donec vitae molestie tellus. Mauris mollis vestibulum condimentum. Curabitur eu nibh vitae ante rhoncus auctor tincidunt vitae ligula. Morbi tempus sit amet risus a scelerisque. Duis eget condimentum nibh, sit amet tincidunt lacus. Quisque vel diam suscipit neque bibendum viverra in eu nisi.
					      	<p>
					      	In a urna a ipsum lacinia fermentum id nec est. Ut eleifend neque at rutrum malesuada. Aenean dignissim rhoncus felis, sed varius eros elementum vitae. Donec vitae molestie tellus. Mauris mollis vestibulum condimentum. Curabitur eu nibh vitae ante rhoncus auctor tincidunt vitae ligula. Morbi tempus sit amet risus a scelerisque. Duis eget condimentum nibh, sit amet tincidunt lacus. Quisque vel diam suscipit neque bibendum viverra in eu nisi.
					      </p>
					      <p>
					      	In a urna a ipsum lacinia fermentum id nec est. Ut eleifend neque at rutrum malesuada. Aenean dignissim rhoncus felis, sed varius eros elementum vitae. Donec vitae molestie tellus. Mauris mollis vestibulum condimentum. Curabitur eu nibh vitae ante rhoncus auctor tincidunt vitae ligula. Morbi tempus sit amet risus a scelerisque. Duis eget condimentum nibh, sit amet tincidunt lacus. Quisque vel diam suscipit neque bibendum viverra in eu nisi.
					      	</p>
					      
					    </div>
					    <div id="tab_information" class="tab-pane fade">
					      	In a urna a ipsum lacinia fermentum id nec est. Ut eleifend neque at rutrum malesuada. Aenean dignissim rhoncus felis, sed varius eros elementum vitae. Donec vitae molestie tellus. Mauris mollis vestibulum condimentum. Curabitur eu nibh vitae ante rhoncus auctor tincidunt vitae ligula. Morbi tempus sit amet risus a scelerisque. Duis eget condimentum nibh, sit amet tincidunt lacus. Quisque vel diam suscipit neque bibendum viverra in eu nisi.
					      	In a urna a ipsum lacinia fermentum id nec est. Ut eleifend neque at rutrum malesuada. Aenean dignissim rhoncus felis, sed varius eros elementum vitae. Donec vitae molestie tellus. Mauris mollis vestibulum condimentum. Curabitur eu nibh vitae ante rhoncus auctor tincidunt vitae ligula. Morbi tempus sit amet risus a scelerisque. Duis eget condimentum nibh, sit amet tincidunt lacus. Quisque vel diam suscipit neque bibendum viverra in eu nisi.
					    </div>
					     
					    <div id="tab_reviews" class="tab-pane fade">
				            <div class="rattings-wrapper">
				            
				             <c:forEach items="${list }" var="p">
				            	<div class="review-ratting">
                                    <div class="star-author-all">
                                        <div class="ratting-author">
                                       
                                            <h3>${p.user.username}</h3>
                                            <%-- <input ${p.productid}> --%>
                                        </div>
                                        
                                    </div>

                                    <div class="reviews_content clearfix">${p.appraise }
                                  <%--  <div type="hidden" name="productid" value="${productid }"></div> --%>
                                    <div  ><a href="DelProductReviews?aid=${p.aid }&productid=${product.productid}&name=${p.user.username}" style="color:red;float:rihgt; font-size:15px" >删除评论</a> </div>
                                    </div>
                                    
                                </div>
                              	</c:forEach>
                              	</div>
				<%-- <div class="pages" style="margin-left:10px;">
				<button class="layui-btn layui-btn-xs" style="float: left;margin-left:5px;" onclick="window.location.href='ProductList?pagenum=${pagelist.prePageNum}'">上一页</button>
				<form class="layui-form" style="float: left;" action="ProductReviewPageServlet" method="get">
					<font style="margin-left:5px;">当前页数</font>
					<input style="margin-left:0px;width:25px;" type="text" name="nowpage" value="${pageNum}"/>
					<font style="margin-left:5px;">总页数${totalPageNum}</font>
					<input class="layui-btn layui-btn-xs" type="submit" value="跳转"/>
				</form>
				<button style="margin-left:5px;" class="layui-btn layui-btn-xs" onclick="window.location.href='ProductList?pagenum=${pagelist.nextPageNum}'">下一页</button>
			</div> --%>
		 </div>
				            </div>
					        
				              
				               <form class="form-product-review" action="AddProductReviews" method="post">
			                    <div class="form-group">
			                   		<input type="hidden" name="productid" value="${product.productid }"> 
			                    	<label class="control-label" for="comment">评价</label>
			                    	<textarea id="comment" class="form-control" name="appraise" cols="45" rows="8" aria-required="true"></textarea>
			                    </div>
				                <div class="row">
				                   
				                    <div class="form-submit col-md-12">
										<input name="submit" type="submit" id="submit" class="btn btn-primary" value="提交"/>
									</div>
									
				                </div>
				             </form>
					    </div>    
					</div>
			 	</div>
			 	<!--/product-tab-description -->
			 
	 		</div>
	 	</div>
	</div>
	<!-- =====================================
    	==== End single-product -->

	<!-- =====================================
    	==== Start up-sells -->
	<div class="up-sells pt-20">
		<!-- Container -->
		<div class="container">
			<!-- Row -->
			<div class="row">
				<div class="col-md-12">
					<div class=" up-sells_content pt-30">
						<h3 class="theme-heading">You May Also Like</h3>
						<div class="product products-grid">
							<div class="owl-carousel owl-theme" data-pagination="true" data-nav="flase" data-items="3" data-large="3" data-medium="3" data-smallmedium="2" data-extrasmall="1" data-verysmall="1" data-autoplay="true">
			            		<div class="item">
			            			<div class="product-block" data-publish-date="">
										<div class="product-image ">
											<div class="product-thumbnail">
												<a href="product_single.html" title="">
													<img class="product-featured-image" src="assets/images/product/product_4.jpg" alt="">
												</a>
											</div>
											<div class="product-actions">
												<a href="#" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
												<i class="fa fa-heart-o"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-view btn-quickview" title="Quickview">
												    <i class="fa fa-eye"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-compare btn-compare" title="Compare">
												    <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div><!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating="">
												<span class="star-rating">
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="product_single.html" title="">
													Sport Standard edition
												</a>
											</h4>
											<div class="product-price">
												<span class="amout">
													<span class="money" data-currency-usd="$700.00">$700.0</span>
												</span>
												<a href="product_single.html" class="add_to_cart_button">Add to Cart</a>
											</div>
										</div><!-- /.product-meta -->
									</div>
			            		</div>
			            		<div class="item">
			            			<div class="product-block" data-publish-date="">
										<div class="product-image ">
											<div class="product-thumbnail">
												<a href="product_single.html" title="">
													<img class="product-featured-image" src="assets/images/product/product_1.jpg" alt="">
												</a>
											</div>
											<div class="product-actions">
												<a href="#" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
												<i class="fa fa-heart-o"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-view btn-quickview" title="Quickview">
												    <i class="fa fa-eye"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-compare btn-compare" title="Compare">
												    <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div><!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating="">
												<span class="star-rating">
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="product_single.html" title="">
													Casual Premium edition
												</a>
											</h4>
											<div class="product-price">
												<span class="amout">
													<span class="money" data-currency-usd="$700.00">$700.0</span>
												</span>
												<a href="product_single.html" class="add_to_cart_button">Add to Cart</a>
											</div>
										</div><!-- /.product-meta -->
									</div>
			            		</div>
			            		<div class="item">
			            			<div class="product-block" data-publish-date="">
										<div class="product-image ">
											<div class="product-thumbnail">
												<a href="product_single.html" title="">
													<img class="product-featured-image" src="assets/images/product/product_5.jpg" alt="">
												</a>
											</div>
											<div class="product-actions">
												<a href="#" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
												<i class="fa fa-heart-o"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-view btn-quickview" title="Quickview">
												    <i class="fa fa-eye"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-compare btn-compare" title="Compare">
												    <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div><!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating="">
												<span class="star-rating">
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="product_single.html" title="">
													Gold Limited edition
												</a>
											</h4>
											<div class="product-price">
												<span class="amout">
													<span class="money" data-currency-usd="$700.00">$700.0</span>
												</span>
												<a href="product_single.html" class="add_to_cart_button">Add to Cart</a>
											</div>
										</div><!-- /.product-meta -->
									</div>
			            		</div>
			            		<div class="item">
			            			<div class="product-block" data-publish-date="">
										<div class="product-image ">
											<div class="product-thumbnail">
												<a href="product_single.html" title="">
													<img class="product-featured-image" src="assets/images/product/product_6.jpg" alt="">
												</a>
											</div>
											<div class="product-actions">
												<a href="#" data-id="" class="btn wishlist product-quick-whistlist" title="Add to whistlist">
												<i class="fa fa-heart-o"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-view btn-quickview" title="Quickview">
												    <i class="fa fa-eye"></i>
												</a>
												<a href="" data-id="" class="btn product-quick-compare btn-compare" title="Compare">
												    <i class="fa fa-retweet"></i>
												</a>
											</div>
										</div><!-- /.product-image -->
										<div class="product-meta">
											<span class="product-rating" data-rating="">
												<span class="star-rating">
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
													<i class="fa fa-star-o"></i>
												</span>
											</span>
											<!-- end rating -->
											<h4 class="product-name">
												<a href="product_single.html" title="">
													Casual Premium edition
												</a>
											</h4>
											<div class="product-price">
												<span class="amout">
													<span class="money" data-currency-usd="$700.00">$700.0</span>
												</span>
												<a href="product_single.html" class="add_to_cart_button">Add to Cart</a>
											</div>
										</div><!-- /.product-meta -->
									</div>
			            		</div>
			            	</div>
					 	</div>
					 </div>
		 		</div>
	 		</div>
	 	</div>
	</div>
	<!-- =====================================
    	==== End up-sells -->

  <!-- =====================================================================
    	==== Start footer -->
	<footer class="site-footer site-footer-1 clearfix">
    	<div class="site-footer__top">
    		<div class="container">
	    		<div class="newsletter text-white">
		    	    <h3>Subscribe Newsletter</h3>
					<p class="newsletter-description">Sign up to receive 15% off your first order! </p>
					<form action="#" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" target="_blank" class="form-horizontal">
						<div class="newsletter-form">
						<input type="email" value="" placeholder="Email address" name="EMAIL" id="mail" aria-label="email@example.com">
						<input type="submit" class="btn" name="subscribe" id="subscribe" value="">
						</div>
					</form>
				</div>
			</div>
		</div>
    	<div class="site-footer__main">
	    	<div class="container">
	    		<div class="row">
			    	<div class="col-md-3 col-sm-6 col-xs-12 footer-block footer-1 text-center">
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
			    	<div class="col-md-6 col-sm-6 col-xs-12 footer-block footer-center text-center">
			    		<img src="assets/images/logo.png" alt="">
			    		<p class="address">Office: 972 Sylvan Street South Angelina, NL S0B2V9<br/>
							Phone: (633) 497-1888 / (062) 109-9222<br/>
							Email: example.com
						</p>
						<ul class="social">
							<li>
								<a href="#"><i class="fa fa-facebook"></i></a>
							</li>
							<li>
								<a href="#"><i class="fa fa-twitter"></i></a>
							</li>
							<li>
								<a href="#"><i class="fa fa-google"></i></a>
							</li>
							<li>
								<a href="#"><i class="fa fa-instagram"></i></a>
							</li>
							<li>
								<a href="#"><i class="fa fa-pinterest"></i></a>
							</li>
						</ul>
			    	</div>
			    	<div class="col-md-3 col-sm-12 col-xs-12 footer-block footer-3">
			    		<h3 class="widget-title">OPENING TIME</h3>
		    			<ul>
		    				<li>
		    					<span>Monday :</span>
		    					<span>9am - 5pm</span>
		    				</li>
		    				<li>
		    					<span>Tuesday :</span>
		    					<span>9am - 1pm</span>
		    				</li>
		    				<li>
		    					<span>Wendsday :</span>
		    					<span>9am - 5pm</span>
		    				</li>
		    				<li>
		    					<span>Thursday :</span>
		    					<span>9am - 1pm</span>
		    				</li>
		    				<li>
		    					<span>Friday :</span>
		    					<span>9am - 1pm</span>
		    				</li>
		    				<li>
		    					<span>Saturday - Sunday :</span>
		    					<span>closed</span>
		    				</li>
		    			</ul>
			    	</div>
			    </div>
		    </div>
	   </div>
	   <div class="site-footer__copyright">
	   		<div class="container">
	    		<div class="copyright pull-left">
	        		Copyright &copy; 2019.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
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
			<span></span>
			<span></span>
			<span></span>
			<span></span>
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