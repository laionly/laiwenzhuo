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
                    <a class="top-bar__item" href="account.html">
                      <i class="fa fa-user-o" aria-hidden="true"></i>
                      Register
                    </a>
                </div>
                  <div class="top-bar-account">
                    <a class="top-bar__item" href="account.html">
                      <i class="fa fa-lock" aria-hidden="true"></i>
                      login
                    </a>
                    <div class="content-dropdown left">
                <div class="account-inner ">
                    <div class="login-form-head">
                        <span class="login-form-title">Sign in</span>
                        <span class="pull-right">
                        <a class="register-link" href="#" title="Register">Create an Account</a>
                       </span>
                    </div>
                    <form class="opal-login-form-ajax" data-toggle="validator">
                        <p>
                        <label>Username or email <span class="required">*</span></label>
                        <input name="username" type="text" required="" placeholder="Username">
                        </p>
                        <p>
                        <label>Password <span class="required">*</span></label>
                        <input name="password" type="password" required="" placeholder="Password">
                        </p>
                        <button type="submit" data-button-action="" class="btn btn-primary btn-block">Login</button>
                        <input type="hidden" name="action" value="">
                        <input type="hidden" id="security-login" name="security-login" value="97915018af"><input type="hidden" name="login" value="">
                    </form>
                    <div class="login-form-bottom">
                          <a href="#" class="lostpass-link" title="Lost your password?">Lost your password?</a>
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
            <li class="dropdown">
              <a href="index.jsp">Home</a>
                <ul class="dropdown-menu">
                     <li><a href="../index.jsp">Home 1</a></li>
                    <li><a href="../v3/index.jsp">Home 3</a></li>
                 </ul>
            </li>
                <li class="dropdown">
                  <a href="#">Product</a>
                  <ul class="dropdown-menu">
                      <li><a href="product_grid.html">
                      Product grid</a>
                      </li>
                      <li><a href="product_list.html">Product list</a></li>
                        <li><a href="product_sidebar.html">Product sidebar</a></li>
                        
                      <li><a href="product_single.html">Product single</a></li>
                    </ul>
                </li>
                  <li class="dropdown"><a href="about.html">About</a></li>
                  <li class="dropdown">
                    <a href="#">Pages</a>
                    <ul class="dropdown-menu">
                      <li><a href="faq.html">FAQ</a>
                      </li>
                        <li><a href="contact.html">Contact</a></li>
                      <li><a href="404.html">Page 404</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                    <a href="#">Blog</a>
                    <ul class="dropdown-menu">
                      <li><a href="blog.html">Blog Grid</a>
                      </li>
                        <li><a href="blog_list.html">Blog List</a></li>
                      <li><a href="blog_single.html">Single Blog</a></li>
                    </ul>
                  </li>
                  <li><a href="contact.html">Contact</a></li>
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
              <!-- cart -->
                <div class="site-header__cart item-dropdown">
					        <a href="cart.jsp" class="site-header__cart-toggle">
					          	<!-- <span class="cartcount">3</span> -->
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
								  <a href="#" class="btn check-out btn-primary btn-normal pull-left">结算</a>
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
        <!--end search -->
        </div>
      </div>
    
    <nav class="navbar">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- logo -->
          <div class="navbar-brand">
            <a class="logo" href="index.jsp"><img src="assets/images/logo.png" alt=""> </a> 
          </div>
          <!-- logo -->
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li class="active dropdown">
                  <a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Home <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="../index.jsp">Home 1</a></li>
                    <li><a href="../v3/index.jsp">Home 3</a></li>
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
    </nav>
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
			<h1>Cart</h1>
			<ol class="item-breadcrumb">
	            <li><a href="index.jsp">Home</a></li>
	            <li>Cart</li>     
            </ol>
		</div>
		<!-- /container -->
   	</div>
   <!-- =====================================
      ==== End breadcrumb -->


	<!-- =====================================
      ==== Start checkout-form-->
	<div class="checkout-form">
		<!-- container -->
		<div class="container">
			<!-- Row -->
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <form action="AddOrderServlet" method="get">
                        <h3>结算明细</h3>
                        <div class="row">
                            <div class="col-md-12 mb-30">
                                <label for="c_country">国家 <span class="required">*</span></label>
                                <select id="c_country">
                                    <option value="1">Select a country</option>    
                                    <option value="2">bangladesh</option>    
                                    <option value="3">Algeria</option>    
                                    <option value="4">Afghanistan</option>    
                                    <option value="5">Ghana</option>    
                                    <option value="6">Albania</option>    
                                    <option value="7">Bahrain</option>    
                                    <option value="8">Colombia</option>    
                                    <option value="9">Dominican Republic</option>    
                                </select>    
                            </div>
                          
                            <div class="col-lg-6 mb-30">
                            
                                <label for="b_f_name">姓名 <span>*</span></label>
                                <input id="name" name="name" type="text">    
                            </div>
                           <!--  <div class="col-lg-6 mb-30">
                                <label for="b_name">Last Name  <span>*</span></label>
                                <input id="b_name" type="text"> 
                            </div>
                            <div class="col-md-12 mb-30">
                                <label for="b_c_name">Company Name</label>
                                <input id="b_c_name" type="text">     
                            </div> -->
                            <div class="col-md-12 mb-30">
                                <label>收货地址<span>*</span></label>
                                <input id="address" name="address" placeholder="Street address" type="text">     
                            </div>
                           <!--  <div class="col-md-12 mb-30">
                                <input placeholder="Apartment, suite, unit etc. (optional)" type="text">     
                            </div>  -->
                            <!-- <div class="col-md-12 mb-30">
                                <label for="b_city">Town / City <span>*</span></label>
                                <input id="b_city" placeholder="Town / City" type="text">     
                            </div>
                            <div class="col-lg-6 mb-30">
                                <label for="f_name">State / County  <span>*</span></label>
                                <input id="f_name" type="text">    
                            </div>  -->
                           <!--  <div class="col-lg-6 mb-30">
                                <label for="b_zip">Product/ Number <span>*</span></label>
                                <input id="number" name="number" placeholder="Postcode / Zip" id="b_zip" type="text">    
                            </div>  -->
                            <div class="col-lg-6 mb-30">
                                <label for="b_email">邮箱地址<span>*</span></label>
                                <input id="email" name="email" type="text">    
                            </div> 
                             <div class="col-lg-6 mb-30">
                                <label> 电话 <span>*</span></label>
                                <input id="phone" name="phone" placeholder="Phone Number" type="text">    
                            </div>
                           
                            <div class="col-md-12 mb-30">
                                <input id="b_c_account" type="checkbox" data-target="createp_account">
                                <label class="righ_1" for="b_c_account" data-toggle="collapse" data-target="#collapseOne" aria-controls="collapseOne">Create an account?</label>
                                
                                <div id="collapseOne" class="collapse" data-parent="#accordion">
                                    <div class="card-body1">
                                       <p>Create an account by entering the information below. If you are a returning customer please login at the top of the page.</p>
                                        <label for="b_a_password">Account password   <span>*</span></label>
                                        <input id="b_a_password" type="text">  
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 mb-30">
                                <input id="b__m__0account" type="checkbox" data-target="createp_account">
                                <label class="righ_1" for="b__m__0account" data-toggle="collapse" data-target="#collapsetwo" aria-controls="collapseOne">Ship to a different address?</label>
                                
                               <!--  <div id="collapsetwo" class="collapse" data-parent="#accordion">
                                   <div class="row">
                                        <div class="col-md-12 mb-30">
                                            <label for="b_country">Country <span class="required">*</span></label>
                                            <select id="b_country">
                                                <option value="1">Select a country</option>    
                                                <option value="2">bangladesh</option>    
                                                <option value="3">Algeria</option>    
                                                <option value="4">Afghanistan</option>    
                                                <option value="5">Ghana</option>    
                                                <option value="6">Albania</option>    
                                                <option value="7">Bahrain</option>    
                                                <option value="8">Colombia</option>    
                                                <option value="9">Dominican Republic</option>    
                                            </select>    
                                        </div>
                                        <div class="col-lg-6 mb-30">
                                            <label for="n_f_name">姓名 <span>*</span></label>
                                            <input id="name" name="name" type="text">    
                                        </div>
                                        <div class="col-lg-6 mb-30">
                                            <label for="b__name">Last Name  <span>*</span></label>
                                            <input id="b__name" type="text"> 
                                        </div>
                                        <div class="col-md-12 mb-30">
                                            <label for="c_n_name">公司名称</label>
                                            <input id="c_n_name" type="text">     
                                        </div>
                                        <div class="col-md-12 mb-30">
                                            <label>收货地址 <span>*</span></label>
                                            <input type="text" id="name" name="address" placeholder="Street address" >     
                                        </div>
                                        <div class="col-md-12 mb-30">
                                            <input placeholder="Apartment, suite, unit etc. (optional)" type="text">     
                                        </div> 
                                        <div class="col-md-12 mb-30">
                                            <label for="b_t_city">Town / City <span>*</span></label>
                                            <input id="b_t_city" placeholder="Town / City" type="text">     
                                        </div>
                                        <div class="col-lg-6 mb-30">
                                            <label for="s_f_name">State / County  <span>*</span></label>
                                            <input id="s_f_name" type="text">    
                                        </div> 
                                         <div class="col-lg-6 mb-30">
                                            <label for="b_p_zip">Postcode / Zip <span>*</span></label>
                                            <input placeholder="Postcode / Zip" id="b_p_zip" type="text">    
                                        </div> 
                                        <div class="col-lg-6 mb-30">
                                            <label for="b_n_email">邮箱地址<span>*</span></label>
                                            <input id="name" name="email" type="text">    
                                        </div> 
                                         <div class="col-lg-6 mb-30">
                                            <label>电话 <span>*</span></label>
                                            <input id="phone" name="phone" placeholder="Phone Number" type="text">    
                                        </div>
                                    </div>
                                </div> -->
                            </div>
                            <div class="col-md-12">
                                <div class="order-notes">
                                     <label for="order_note">Order Notes</label>
                                    <textarea id="order_note" placeholder="Notes about your order, e.g. special notes for delivery."></textarea>
                                </div>    
                            </div>     	    	    	    	    	    	    
                        </div>
                           <div class="order-button">
                                <button type="submit" class="btn-primary">下订单</button>                        
                            </div>    
                    </form>    
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="coupon-form-two mb-30">
                         <h3>coupon code</h3>
                         <p>Enter your coupon code if you have one</p> 
                         <form action="#">
                             <input placeholder="Coupon code" type="text">
                             <input value="Apply" type="submit" class="btn-primary">
                         </form>  
                    </div> 
                    <div class="order-wrapper">
                   
                        <h3>您的订单</h3>                     
                        <div class="order-table table-responsive mb-30">
                         
                            <table>
                                <thead>
                                    <tr>
                                        <th class="product-name">商品</th>
                                        <th class="product-total">价格</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                 <c:forEach items="${cart.map }" var="c">
                                    <tr>
                                        <td class="product-name"> ${c.value.product.name}<strong> × ${c.value.count}</strong></td>
                                        <td class="amount">￥${c.value.price}</td>
                                    </tr>
                                     <!-- <tr>
                                        <td class="product-name">  Vestibulum dictum magna	 <strong> × 1</strong></td>
                                        <td class="amount"> $50.00</td>
                                    </tr> --> 
                                     </c:forEach>   
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th>购物车小计</th>
                                        <td>￥${cart.price}</td>
                                    </tr>
                                    <tr>
                                        <th>合计订单</th>
                                        <td><strong>￥${cart.price}</strong></td>
                                    </tr>
                                </tfoot>
                            </table> 
                           
                        </div>
                        <div class="payment-method">
                           <div class="panel-default">
                                <a class="righ_10" data-toggle="collapse" data-target="#collapsethree" aria-controls="collapseOne">银行转账</a>

                                <div id="collapsethree" class="collapse" data-parent="#accordion">
                                    <div class="card-body2">
                                       <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                                    </div>
                                </div>
                            </div> 
                            <div class="panel-default">
                                <a class="righ_10" data-toggle="collapse" data-target="#collapsefour" aria-controls="collapseOne">支付宝</a>

                                <div id="collapsefour" class="collapse" data-parent="#accordion">
                                    <div class="card-body2">
                                       <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                                    </div>
                                </div>
                            </div> 
                            <div class="panel-default">
                                <a class="righ_10" data-toggle="collapse" data-target="#collapsefive" aria-controls="collapseOne"> 贝宝</a>

                                <div id="collapsefive" class="collapse" data-parent="#accordion">
                                    <div class="card-body2">
                                       <p>Make your payment directly into our bank account. Please use your Order ID as the payment reference. Your order won’t be shipped until the funds have cleared in our account.</p>
                                    </div>
                                </div>
                            </div>
                           
                        </div>    
                    </div>  
                </div>
            </div> 
            <!-- Row -->
        </div>
		<!-- /container -->
	</div>
	<!-- =====================================
      ==== End checkout-form -->


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
               <li><a href="about.html">About Us</a></li>
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