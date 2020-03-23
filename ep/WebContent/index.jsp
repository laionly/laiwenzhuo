<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Dagon</title>
    <link rel="shortcut icon" type="image/x-icon" href="${ctx}/assets/images/favicon.png"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/fonts/flaticon/flaticon.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/pe-icon-7-stroke.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/chosen.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap"
          rel="stylesheet">
</head>
<body class="index-opt-1">
<div class="wrapper">
    <form id="block-search-mobile" method="get" class="block-search-mobile">
        <div class="form-content">
            <div class="control">
                <a href="#" class="close-block-serach"><span class="icon flaticon-close"></span></a>
                <input type="text" name="search" placeholder="Search" class="input-subscribe">
                <button type="submit" class="btn search">
                    <span><i class="flaticon-magnifying-glass" aria-hidden="true"></i></span>
                </button>
            </div>
        </div>
    </form>
    <div id="block-quick-view-popup" class="block-quick-view-popup">
        <div class="quick-view-content">
            <a href="#" class="popup-btn-close"><span class="flaticon-close"></span></a>
            <div class="product-items">
                <div class="product-image">
                    <a href="#"><img src="assets/images/popup-pro.jpg" alt="p1"></a>
                </div>
                <div class="product-info">
                    <div class="product-name"><a href="#">Photo Camera</a></div>
                    <span class="star-rating">
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <i class="fa fa-star" aria-hidden="true"></i>
                            <span class="review">5 Review(s)</span>
                        </span>
                    <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o" aria-hidden="true"></i>Add to
                        Wishlist</a>
                    <div class="product-infomation">
                        Description Our new HPB12 / A12 battery is rated at 2000mAh and designed to power up Black and
                        Decker FireStorm line of 12V tools allowing...
                    </div>
                </div>
                <div class="product-info-price">
                        <span class="price">
                            <ins>$229.00</ins>
                            <del>$259.00</del>
                        </span>
                    <div class="quantity">
                        <h6 class="quantity-title">Quantity:</h6>
                        <div class="buttons-added">
                            <input type="text" value="1" title="Qty" class="input-text qty text" size="1">
                            <a href="#" class="sign plus"><i class="fa fa-plus"></i></a>
                            <a href="#" class="sign minus"><i class="fa fa-minus"></i></a>
                        </div>
                    </div>
                    <a href="#" class="btn-add-to-cart">Add to cart</a>
                </div>
            </div>
        </div>
    </div>
    <!-- HEADER -->
    <header class="site-header header-opt-1">
        <!-- header-top -->
        <div class="header-top">
            <div class="container">
                <!-- hotline -->
                <ul class="nav-top-left">
                 <c:if test="${!empty(sessionScope.user.uid) }"><li><a href="user/findUserByUid?uid=${sessionScope.user.uid }">欢迎你${sessionScope.user.username }</a></li></c:if>
                 <c:if test="${!empty(sessionScope.user.uid) }"><li><a href="user/userLogout">退出登录</a></li></c:if>
                </ul><!-- hotline -->
                <!-- heder links -->
                <ul class="nav-top-right dagon-nav">
                    <li class="menu-item-has-children"><a href="#" class="dropdown-toggle"><img
                            src="assets/images/general/l1.jpg" alt="flag">English<i class="fa fa-angle-down"
                                                                                    aria-hidden="true"></i></a>
                        <ul class="submenu parent-megamenu">
                            <li class="switcher-option">
                                <a href="#" class="flag"><img src="assets/images/general/l1.jpg" alt="flag">English</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="flag"><img src="assets/images/general/l2.jpg" alt="flag">Hungary</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="flag"><img src="assets/images/general/l3.jpg" alt="flag">German</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="flag"><img src="assets/images/general/l4.jpg" alt="flag">French</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="flag"><img src="assets/images/general/l5.jpg" alt="flag">Canada</a>
                            </li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children">
                        <a href="#" class="dropdown-toggle">
                            <span>Dollar (US)</span><i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="submenu parent-megamenu">
                            <li class="switcher-option">
                                <a href="#" class="switcher-flag icon">Pound (GBP)</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="switcher-flag icon">Euro (EUR)</a>
                            </li>
                            <li class="switcher-option">
                                <a href="#" class="switcher-flag icon">Dollar (USD)</a>
                            </li>
                        </ul>
                    </li>
                   <c:if test="${empty(sessionScope.user.uid) }"> <li><a href="login.jsp"><i class="flaticon-profile" aria-hidden="true"></i>注册 / 登录</a></li></c:if>
                </ul><!-- heder links -->
            </div>
        </div> <!-- header-top -->
        <!-- header-content -->
        <div class="header-content">
            <div class="container">
                <div class="row">
                    <div class="col-md-2 nav-left">
                        <!-- logo -->
                        <strong class="logo">
                            <a href="index.jsp"><img src="assets/images/logo.png" alt="logo"></a>
                        </strong>
                        <!-- logo -->
                    </div>
                    <div class="col-md-8 nav-mind">
                        <!-- block search -->
                        <div class="block-search">
                            <div class="block-content">
                                <div class="categori-search  ">
                                    <select title="categories" data-placeholder="All Categories"
                                            class="chosen-select categori-search-option">
                                        <option value="">All Categories</option>
                                        <optgroup label="LifeStyle">
                                            <option>Cell Phones</option>
                                            <option>Game & Consoles</option>
                                            <option>Smart Watchs</option>
                                        </optgroup>
                                        <optgroup label="Smartphone">
                                            <option>Cell Phones</option>
                                            <option>Game & Consoles</option>
                                            <option>Smart Watchs</option>
                                        </optgroup>
                                        <optgroup label="LifeStyle">
                                            <option>Cell Phones</option>
                                            <option>Game & Consoles</option>
                                            <option>Smart Watchs</option>
                                        </optgroup>
                                        <optgroup label="Smartphone">
                                            <option>Cell Phones</option>
                                            <option>Game & Consoles</option>
                                            <option>Smart Watchs</option>
                                        </optgroup>
                                    </select>
                                </div>
                                <div class="form-search">
                                    <form action="findProductByName" method="post">
                                        <div class="box-group">
                                            <input type="text" class="form-control" name="name"
                                                   placeholder="请输入商品名称或关键字">
                                            <button class="btn btn-search" type="submit"><span
                                                    class="flaticon-magnifying-glass"></span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div><!-- block search -->
                    </div>
                    <div class="col-md-2 nav-right">
                        <!-- block mini cart -->
                        <span data-action="toggle-nav" class="menu-on-mobile hidden-md style2">
                                <span class="btn-open-mobile home-page">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </span>
                                <span class="title-menu-mobile">Main menu</span> 
                            </span>
                        <div class="block-minicart dropdown style2">
                            <a class="minicart" href="#">

                                    <span class="counter qty">

                                        <span class="cart-icon"><i class="flaticon-shopping-cart"
                                                                   aria-hidden="true"></i></span>

                                        <span class="counter-number">2</span>

                                    </span>
                                <span class="counter-your-cart">

                                        <span class="counter-label">购物车</span>

                                        <span class="counter-price">$00.00</span>

                                    </span>
                            </a>
                            <div class="parent-megamenu">
                                <form>
                                    <div class="minicart-content-wrapper">
                                        <div class="subtitle">
                                                                             你的购物车有 <span>2</span>件商品 
                                        </div>
                                        <div class="minicart-items-wrapper">
                                            <ol class="minicart-items">
                                                <li class="product-inner">
                                                    <div class="product-thumb style1">
                                                        <div class="thumb-inner">
                                                            <a href="#"><img src="assets/images/home2/c1.jpg"
                                                                             alt="c1"></a>
                                                        </div>
                                                    </div>
                                                    <div class="product-innfo">
                                                        <div class="product-name"><a href="#">Notebook Pro
                                                        </a></div>
                                                        <a href="#" class="remove"><i class="flaticon-close"
                                                                                      aria-hidden="true"></i></a>
                                                        <span class="price price-dark">

                                                                <ins>$229.00</ins>

                                                            </span>
                                                    </div>
                                                </li>
                                                <li class="product-inner">
                                                    <div class="product-thumb style1">
                                                        <div class="thumb-inner">
                                                            <a href="#"><img src="assets/images/home2/c2.jpg"
                                                                             alt="c2"></a>
                                                        </div>
                                                    </div>
                                                    <div class="product-innfo">
                                                        <div class="product-name"><a href="#">Bluetooth Speaker
                                                        </a></div>
                                                        <a href="#" class="remove"><i class="flaticon-close"
                                                                                      aria-hidden="true"></i></a>
                                                        <span class="price">

                                                                <ins>$229.00</ins>

                                                                <del>$259.00</del>

                                                            </span>
                                                    </div>
                                                </li>
                                            </ol>
                                        </div>
                                        <div class="subtotal">
                                            <span class="label">总价 :</span>
                                            <span class="price">$480.00</span>
                                        </div>
                                        <div class="actions">
                                            <a class="btn btn-viewcart" href="shopping-cart.html">查看购物车</a>
                                            <a class="btn btn-checkout" href="checkout.html">查看订单</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!-- block mini cart -->
                        <a href="#" class="hidden-md search-hidden"><span class="flaticon-magnifying-glass"></span></a>
                        <a class="wishlist-minicart" href="wishlist.jsp"><i class="fa fa-heart-o"
                                                                             aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div><!-- header-content -->
        <!-- header-menu-bar -->
        <div class="header-menu-bar header-sticky">
            <div class="header-menu-nav menu-style-1">
                <div class="container">
                    <div class="header-menu-nav-inner ">
                        <div class="header-menu header-menu-resize">
                            <ul class="header-nav dagon-nav">
                                <li class="btn-close hidden-md"><i class="flaticon-close" aria-hidden="true"></i></li>
                                <li class="menu-item-has-children arrow">
                                    <a href="${ctx}/index.jsp">首页</a>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="pageProduct">商店</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="pageProduct">网格商品</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="pageProduct">商品列表</a>
                                        </li>                                  
                                        <li class="menu-item">
                                            <a href="pageProduct">商品详情</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children arrow item-megamenu">
                                    <a href="#">相机</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <div class="submenu parent-megamenu megamenu">
                                        <div class="row">
                                            <div class="submenu-banner submenu-banner-menu-1">
                                                <div class="col-md-4">
                                                    <div class="dropdown-menu-info">
                                                        <h6 class="dropdown-menu-title">相机</h6>
                                                        <div class="dropdown-menu-content">
                                                            <ul class="menu">
                                                                <li class="menu-item"><a href="#">数码相机</a></li>
                                                                <li class="menu-item"><a href="#">胶片机</a></li>                                                              
                                                                <li class="menu-item"><a href="#">双反相机</a></li>                                                                  
                                                                <li class="menu-item"><a href="#">单反相机</a></li>
                                                                <li class="menu-item"><a href="#">旁轴相机</a></li>                                                           
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                               <!--  <div class="col-md-4">
                                                    <div class="dropdown-menu-info">
                                                        <h6 class="dropdown-menu-title">Computer</h6>
                                                        <div class="dropdown-menu-content">
                                                            <ul class="menu">
                                                                <li class="menu-item"><a href="#">Computer</a></li>
                                                                <li class="menu-item"><a href="#">Smartphone </a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">Printers</a></li>
                                                                <li class="menu-item"><a href="#">Game & Consoles</a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">New Arrivals</a></li>
                                                                <li class="menu-item"><a href="#">Monitors</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div> -->
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="menu-item-has-children arrow item-megamenu">
                                    <a href="#">电脑</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <div class="submenu parent-megamenu megamenu">
                                        <div class="row">
                                            <div class="submenu-banner submenu-banner-menu-2">
                                               <!--  <div class="col-md-3">
                                                    <div class="dropdown-menu-info">
                                                        <h6 class="dropdown-menu-title">Camera</h6>
                                                        <div class="dropdown-menu-content">
                                                            <ul class="menu">
                                                                <li class="menu-item"><a href="#">Laptop</a></li>
                                                                <li class="menu-item"><a href="#">Speakers</a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">Tablet
                                                                    Computer</a></li>
                                                                <li class="menu-item"><a href="#">Monitors</a></li>
                                                                <li class="menu-item"><a href="#">Projector</a></li>
                                                                <li class="menu-item"><a href="#">Office</a></li>
                                                                <li class="menu-item"><a href="#">Networking</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div> -->
                                                <div class="col-md-3">
                                                    <div class="dropdown-menu-info">
                                                        <h6 class="dropdown-menu-title">电脑</h6>
                                                        <div class="dropdown-menu-content">
                                                            <ul class="menu">
                                                                <li class="menu-item"><a href="#">台式电脑</a></li>
                                                                <li class="menu-item"><a href="#">笔记本电脑 </a></li>                                                           
                                                                <li class="menu-item"><a href="#">平板电脑</a></li>
                                                               <!--  <li class="menu-item"><a href="#">Game & Consoles</a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">New Arrivals</a></li>
                                                                <li class="menu-item"><a href="#">Monitors</a></li> -->
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                               <!--  <div class="col-md-3">
                                                    <div class="dropdown-menu-info">
                                                        <h6 class="dropdown-menu-title">Computer</h6>
                                                        <div class="dropdown-menu-content">
                                                            <ul class="menu">
                                                                <li class="menu-item"><a href="#">Computer</a></li>
                                                                <li class="menu-item"><a href="#">Smartphone </a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">Printers</a></li>
                                                                <li class="menu-item"><a href="#">Game & Consoles</a>
                                                                </li>
                                                                <li class="menu-item"><a href="#">New Arrivals</a></li>
                                                                <li class="menu-item"><a href="#">Monitors</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div> -->
                                                <div class="col-md-3">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#">页面</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="user/checkShopCartByUid?uid=${sessionScope.user.uid }">购物车</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="user/checkOrder?uid=${sessionScope.user.uid }">我的订单</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="user/checkIFocustables?uid=${sessionScope.user.uid }">我的收藏</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="compare.html">比较</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#">博客</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="blog-grid.html">Blog Grid</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="blog-list.html">Blog List</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="blog-single.html">Blog Single</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#">其他</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="about-us.html">关于我们</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="contact-us.html">联系我们</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="login.jsp">登录</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end header-menu-bar -->
    </header>
    <!-- END HEADER -->
    <!-- MAIN -->
    <main class="site-main">
        <div class="block-section-1">
            <div class="main-slide slide-opt-1 full-width">
                <div class="owl-carousel nav-style1" data-nav="false" data-autoplay="false" data-dots="true"
                     data-loop="true" data-margin="0"
                     data-responsive='{"0":{"items":1},"600":{"items":1},"1000":{"items":1}}'>
                    <div class="item-slide item-slide-1">
                        <div class="slide-desc slide-desc-1">
                            <div class="container">
                                <div class="container-inner">
                                    <div class="p-primary">Discovery And Explore Digital</div>
                                    <p>Vehicula curae mi senectus sodales proin, ultricies gravida.</p>
                                    <a href="grid-product.html" class="btn-shop-now">开始购物</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item-slide item-slide-2">
                        <div class="slide-desc slide-desc-2">
                            <div class="container">
                                <div class="container-inner">
                                    <div class="p-primary">Smart Watches New Collection</div>
                                    <p>Inceptos aptent eleifend metus. Porta montes nibh mollis</p>
                                    <a href="grid-product.html" class="btn-shop-now">开始购物</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item-slide item-slide-3">
                        <div class="slide-desc slide-desc-3">
                            <div class="container">
                                <div class="container-inner">
                                    <div class="p-primary">Follow Keeping through Control</div>
                                    <p>Lorem ipsum dolor sit amet consectetur, adipiscing turpis</p>
                                    <a href="grid-product.html" class="btn-shop-now">开始购物</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-section-99">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="dagon-iconbox style-02">
                            <div class="iconbox-inner">
                                <div class="icon"><span class="flaticon-delivery-truck"></span></div>
                                <div class="content"><h4 class="title">FAST SHIPPING</h4>
                                    <p class="text">Dispatch on most items</p></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="dagon-iconbox style-02">
                            <div class="iconbox-inner">
                                <div class="icon"><span class="flaticon-refresh"></span></div>
                                <div class="content"><h4 class="title">30 DAY RETURns</h4>
                                    <p class="text">For peace of mind</p></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="dagon-iconbox style-02">
                            <div class="iconbox-inner">
                                <div class="icon"><span class="flaticon-quality-badge"></span></div>
                                <div class="content"><h4 class="title">BEST FURNITURE</h4>
                                    <p class="text">Online retailer for home</p></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-daily-deals style1">
            <div class="container">
                <div class="title-of-section main-title">每日特惠</div>
                <div class="owl-carousel nav-style2 border-background equal-container" data-nav="true"
                     data-autoplay="false" data-dots="false" data-loop="true" data-margin="30"
                     data-responsive='{"0":{"items":1},"530":{"items":2},"768":{"items":3},"992":{"items":2}}'>
                    <div class="deal-of-day equal-elem">
                        <div class="product-thumb style1">
                            <div class="thumb-inner">
                                <a href="#"><img src="assets/images/home2/d1.jpg" alt="d1"></a>
                            </div>
                        </div>
                        <div class="product-innfo">
                            <div class="product-name"><a href="#">Ultra HD Roku Smart</a></div>
                            <span class="price">
                                    <ins>$229.00</ins>
                                    <del>$259.00</del>
                                    <span class="onsale">-50%</span>
                                </span>
                            <span class="star-rating">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <span class="review">5 Review(s)</span>
                                </span>
                            <div class="product-count-down">
                                <div class="kt-countdown" data-y="2020" data-m="6" data-d="1" data-h="10" data-i="0"
                                     data-s="0"></div>
                            </div>
                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                        </div>
                    </div>
                    <div class="deal-of-day equal-elem">
                        <div class="product-thumb style1">
                            <div class="thumb-inner">
                                <a href="#"><img src="assets/images/home2/d2.jpg" alt="d2"></a>
                            </div>
                        </div>
                        <div class="product-innfo">
                            <div class="product-name"><a href="#">Cellphone Factory</a>
                            </div>
                            <span class="price">
                                    <ins>$229.00</ins>
                                    <del>$259.00</del>
                                    <span class="onsale">-50%</span>
                                </span>
                            <span class="star-rating">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <span class="review">5 Review(s)</span>
                                </span>
                            <div class="product-count-down">
                                <div class="kt-countdown" data-y="2020" data-m="7" data-d="1" data-h="20" data-i="0"
                                     data-s="0"></div>
                            </div>
                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                        </div>
                    </div>
                    <div class="deal-of-day equal-elem">
                        <div class="product-thumb style1">
                            <div class="thumb-inner">
                                <a href="#"><img src="assets/images/home2/d1.jpg" alt="d1"></a>
                            </div>
                        </div>
                        <div class="product-innfo">
                            <div class="product-name"><a href="#">Ultra HD Roku Smart</a></div>
                            <span class="price">
                                    <ins>$229.00</ins>
                                    <del>$259.00</del>
                                    <span class="onsale">-50%</span>
                                </span>
                            <span class="star-rating">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <span class="review">5 Review(s)</span>
                                </span>
                            <div class="product-count-down">
                                <div class="kt-countdown" data-y="2020" data-m="6" data-d="1" data-h="10" data-i="0"
                                     data-s="0"></div>
                            </div>
                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                        </div>
                    </div>
                    <div class="deal-of-day equal-elem">
                        <div class="product-thumb style1">
                            <div class="thumb-inner">
                                <a href="#"><img src="assets/images/home2/d2.jpg" alt="d2"></a>
                            </div>
                        </div>
                        <div class="product-innfo">
                            <div class="product-name"><a href="#">Cellphone Factory</a>
                            </div>
                            <span class="price">
                                    <ins>$229.00</ins>
                                    <del>$259.00</del>
                                    <span class="onsale">-50%</span>
                                </span>
                            <span class="star-rating">
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <i class="fa fa-star" aria-hidden="true"></i>
                                    <span class="review">5 Review(s)</span>
                                </span>
                            <div class="product-count-down">
                                <div class="kt-countdown" data-y="2020" data-m="7" data-d="1" data-h="20" data-i="0"
                                     data-s="0"></div>
                            </div>
                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-section-3">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-5">
                        <div class="promotion-banner style-1">
                            <a href="#" class="banner-img">
                                <img src="assets/images/home2/banner-1.jpg" alt="banner-1">
                            </a>
                            <div class="promotion-banner-inner">
                                <h4>Headphone</h4>
                                <h3>Sale <strong>40%</strong> Off</h3>
                                <a class="banner-link" href="grid-product.html">Shop now</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7 col-sm-7">
                        <div class="promotion-banner style-1">
                            <a href="#" class="banner-img"><img src="assets/images/home2/banner-2.jpg"
                                                                alt="banner-2"></a>
                            <div class="promotion-banner-inner">
                                <h4>New Arrivals</h4>
                                <h3>Get <strong>25%</strong> Flat Off</h3>
                                <a class="banner-link" href="grid-product.html">Shop now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-section-4">
            <div class="container">
                <div class="title-of-section main-title">特色产品</div>
                <div class="tab-product tab-product-fade-effect">
                    <ul class="box-tabs nav-tab">
                        <li class="active"><a data-animated="" data-toggle="tab" href="#tab-1">所有商品</a></li>
                        <li><a data-animated="" data-toggle="tab" href="#tab-2">相机</a></li>
                        <li><a data-animated="" data-toggle="tab" href="#tab-3">电脑</a></li>
                        <li><a data-animated="" data-toggle="tab" href="#tab-4">控制台</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-container">
                            <div id="tab-1" class="tab-panel active">
                                <div class="owl-carousel nav-style2 border-background equal-container" data-nav="false"
                                     data-autoplay="false" data-dots="false" data-loop="true" data-margin="30"
                                     data-responsive='{"0":{"items":1},"480":{"items":2},"768":{"items":3},"992":{"items":4},"1200":{"items":4}}'>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p1.jpg" alt="p1"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Game Controller
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p6.jpg" alt="p6"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p2.jpg" alt="p2"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Photo Camera
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p7.jpg" alt="p7"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Ring Video Doorbell
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p3.jpg" alt="p3"></a>
                                                    </div>
                                                    <span class="onnew">new</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone 4 GB
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p8.jpg" alt="p8"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p4.jpg" alt="p4"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p9.jpg" alt="p9"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p5.jpg" alt="p5"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p10.jpg"
                                                                         alt="p10"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-2" class="tab-panel">
                                <div class="owl-carousel nav-style2 border-background equal-container" data-nav="false"
                                     data-autoplay="false" data-dots="false" data-loop="true" data-margin="30"
                                     data-responsive='{"0":{"items":1},"480":{"items":2},"768":{"items":3},"992":{"items":4},"1200":{"items":4}}'>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p6.jpg" alt="p6"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p2.jpg" alt="p2"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Photo Camera
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p7.jpg" alt="p7"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Ring Video Doorbell
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p1.jpg" alt="p1"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Game Controller
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p8.jpg" alt="p8"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p4.jpg" alt="p4"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p3.jpg" alt="p3"></a>
                                                    </div>
                                                    <span class="onnew">new</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone 4 GB
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p9.jpg" alt="p9"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p5.jpg" alt="p5"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p10.jpg"
                                                                         alt="p10"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-3" class="tab-panel">
                                <div class="owl-carousel nav-style2 border-background equal-container" data-nav="false"
                                     data-autoplay="false" data-dots="false" data-loop="true" data-margin="30"
                                     data-responsive='{"0":{"items":1},"480":{"items":2},"768":{"items":3},"992":{"items":4},"1200":{"items":4}}'>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p3.jpg" alt="p3"></a>
                                                    </div>
                                                    <span class="onnew">new</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone 4 GB
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p2.jpg" alt="p2"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Photo Camera
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p10.jpg"
                                                                         alt="p10"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p1.jpg" alt="p1"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Game Controller
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p8.jpg" alt="p8"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p4.jpg" alt="p4"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p6.jpg" alt="p6"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p9.jpg" alt="p9"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p5.jpg" alt="p5"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p7.jpg" alt="p7"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Ring Video Doorbell
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="tab-4" class="tab-panel">
                                <div class="owl-carousel nav-style2 border-background equal-container" data-nav="false"
                                     data-autoplay="false" data-dots="false" data-loop="true" data-margin="30"
                                     data-responsive='{"0":{"items":1},"480":{"items":2},"768":{"items":3},"992":{"items":4},"1200":{"items":4}}'>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p2.jpg" alt="p2"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Photo Camera
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p6.jpg" alt="p6"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p1.jpg" alt="p1"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Game Controller
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p7.jpg" alt="p7"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Ring Video Doorbell
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p4.jpg" alt="p4"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p3.jpg" alt="p3"></a>
                                                    </div>
                                                    <span class="onnew">new</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone 4 GB
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p8.jpg" alt="p8"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Retina Laptop
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p9.jpg" alt="p9"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Smartphone New
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-one-row">
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p5.jpg" alt="p5"></a>
                                                    </div>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price price-dark">
                                                            <ins>$229.00</ins>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner equal-elem">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/home2/p10.jpg"
                                                                         alt="p10"></a>
                                                    </div>
                                                    <span class="onsale">-50%</span>
                                                    <a href="#" class="quick-view">Quick View</a>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Notebook Pro
                                                    </a></div>
                                                    <span class="price">
                                                            <ins>$229.00</ins>
                                                            <del>$259.00</del>
                                                        </span>
                                                    <span class="star-rating">
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <i class="fa fa-star" aria-hidden="true"></i>
                                                            <span class="review">5 Review(s)</span>
                                                        </span>
                                                    <div class="group-btn-hover">
                                                        <div class="inner">
                                                            <a href="compare.html" class="compare"><i
                                                                    class="fa fa-exchange"></i></a>
                                                            <a href="#" class="add-to-cart">Add to cart</a>
                                                            <a href="wishlist.jsp" class="wishlist"><i
                                                                    class="fa fa-heart-o"
                                                                    aria-hidden="true"></i></a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-section-6 page-product">
            <div class="container">
                <div class="promotion-banner style-3">
                    <a href="#" class="banner-img"><img src="assets/images/home2/banner-3.jpg" alt="banner-3"></a>
                    <div class="promotion-banner-inner">
                        <h4>Top Collection</h4>
                        <h3>All New Smart Watches</h3>
                        <a class="banner-link" href="grid-product.html">开始购物</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="block-the-blog">
            <div class="container">
                <div class="title-of-section"><span>查看博客</span></div>
                <div class="owl-carousel nav-style2" data-nav="true" data-autoplay="false" data-dots="true"
                     data-loop="true" data-margin="30"
                     data-responsive='{"0":{"items":1},"480":{"items":2},"600":{"items":2},"992":{"items":3}}'>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog1.jpg" alt="blog1"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">It’s all about the bread: whole grain home</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog2.jpg" alt="blog2"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Ridiculus nascetur, malesuada non in netus.</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog3.jpg" alt="blog3"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Using Lorem Ipsum allows designers to put</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog1.jpg" alt="blog1"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">It’s all about the bread: whole grain home</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog2.jpg" alt="blog2"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Ridiculus nascetur, malesuada non in netus.</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog3.jpg" alt="blog3"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Using Lorem Ipsum allows designers to put</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog1.jpg" alt="blog1"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">It’s all about the bread: whole grain home</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog2.jpg" alt="blog2"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Ridiculus nascetur, malesuada non in netus.</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                    <div class="blog-item">
                        <div class="post-thumb">
                            <a href="#"><img src="assets/images/home1/blog3.jpg" alt="blog3"></a>
                        </div>
                        <div class="post-item-info">
                            <h3 class="post-name"><a href="#">Using Lorem Ipsum allows designers to put</a></h3>
                            <div class="post-metas">
                                <span class="author">Post by: <span>Admin</span></span>
                                <span class="comment"><i class="fa fa-comment" aria-hidden="true"></i>36 Comments</span>
                            </div>
                            <div>Lorem ipsum dolor sit amet consectetur adipiscing, elit integer urna placerat donec,
                                cum viverra egestas ac luctus...
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <!-- end MAIN -->
    <!-- FOOTER -->
    <footer class="site-footer footer-opt-2">
        <div class="footer-top full-width">
            <div class="owl-carousel instagram" data-nav="false"
                 data-autoplay="false" data-dots="false" data-loop="true" data-margin="0"
                 data-responsive='{"0":{"items":2},"480":{"items":2},"768":{"items":3},"992":{"items":4},"1200":{"items":5}}'>
                <div class="item-instagram">
                    <a href="#">
                        <img src="assets/images/item-instagram-1.jpg" alt="img">
                    </a>
                    <span class="text">
                        <i class="icon fa fa-instagram" aria-hidden="true"></i>
			        </span>
                </div>
                <div class="item-instagram">
                    <a href="#">
                        <img src="assets/images/item-instagram-2.jpg" alt="img">
                    </a>
                    <span class="text">
                        <i class="icon fa fa-instagram" aria-hidden="true"></i>
			        </span>
                </div>
                <div class="item-instagram">
                    <a href="#">
                        <img src="assets/images/item-instagram-3.jpg" alt="img">
                    </a>
                    <span class="text">
                        <i class="icon fa fa-instagram" aria-hidden="true"></i>
			        </span>
                </div>
                <div class="item-instagram">
                    <a href="#">
                        <img src="assets/images/item-instagram-4.jpg" alt="img">
                    </a>
                    <span class="text">
                        <i class="icon fa fa-instagram" aria-hidden="true"></i>
			        </span>
                </div>
                <div class="item-instagram">
                    <a href="#">
                        <img src="assets/images/item-instagram-5.jpg" alt="img">
                    </a>
                    <span class="text">
                        <i class="icon fa fa-instagram" aria-hidden="true"></i>
			        </span>
                </div>
            </div>
        </div>
        <div class="footer-column equal-container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 col-sm-6 equal-elem">
                        <div class="logo-footer"><img src="assets/images/logo-light.png" alt="logo"></div>
                        <div class="contacts">
                            <p class="contacts-info">Nullam tristique tortor nibh, in viverra libero sollicitudin ac.
                                Suspendisse quis lacinia ipsum. Etiam scelerisque sit amet lectus quis lacinia. Sed.</p>
                            <span class="contacts-info info-address ">218 Fifth Avenue, HeavenTower NewYork City</span>
                            <span class="contacts-info info-phone">(+68) 123 456 7890</span>
                            <span class="contacts-info info-support">Hot-Support@Dagon.com</span>
                        </div>
                    </div>
                    <div class="col-md-2 col-sm-6 equal-elem">
                        <div class="links">
                            <h3 class="title-of-section">My account</h3>
                            <ul>
                                <li><a href="#">Sign In</a></li>
                                <li><a href="#">View Cart</a></li>
                                <li><a href="#">My Wishlist</a></li>
                                <li><a href="#">Terms & Conditions</a></li>
                                <li><a href="#">Contact us</a></li>
                                <li><a href="#">Track My Order</a></li>
                                <li><a href="#">Help</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2 col-sm-6 equal-elem">
                        <div class="links">
                            <h3 class="title-of-section">Information</h3>
                            <ul>
                                <li><a href="#">Specials</a></li>
                                <li><a href="#">New products</a></li>
                                <li><a href="#">Best sellers</a></li>
                                <li><a href="#">Our stores</a></li>
                                <li><a href="#">Contact us</a></li>
                                <li><a href="#">Sitemap</a></li>
                                <li><a href="#">Blog</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6 equal-elem">
                        <div class="links">
                            <h3 class="title-of-section">Newsletter</h3>
                            <span class="span-newsletter">Get notified of new products, limited releases, and more.</span>
                            <div class="newsletter-form">
                                <form id="newsletter-validate-detail" class="form subscribe">
                                    <div class="control">
                                        <input type="email" placeholder="Enter your email" id="newsletter" name="email"
                                               class="input-subscribe">
                                        <button type="submit" title="Subscribe" class="btn subscribe">
                                            <span>Sign Up</span>
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="socials">
                                <a href="#" class="social"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                <a href="#" class="social"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                <a href="#" class="social"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                                <a href="#" class="social"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright full-width">
            <div class="container">
                <div class="copyright-right">
                    Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
                </div>
                <div class="pay-men">
                    <a href="#"><img src="assets/images/general/pay1.jpg" alt="pay1"></a>
                    <a href="#"><img src="assets/images/general/pay2.jpg" alt="pay2"></a>
                    <a href="#"><img src="assets/images/general/pay3.jpg" alt="pay3"></a>
                    <a href="#"><img src="assets/images/general/pay4.jpg" alt="pay4"></a>
                </div>
            </div>
        </div>
    </footer>
    <!-- end FOOTER -->
</div>
<a href="#" id="scrollup" title="Scroll to Top">Scroll</a>
<!-- jQuery -->
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="assets/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="assets/js/wow.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.actual.min.js"></script>
<script type="text/javascript" src="assets/js/chosen.jquery.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.sticky.js"></script>
<script type="text/javascript" src="assets/js/jquery.elevateZoom.min.js"></script>
<script src="assets/js/fancybox/source/jquery.fancybox.pack.js"></script>
<script src="assets/js/fancybox/source/helpers/jquery.fancybox-media.js"></script>
<script src="assets/js/fancybox/source/helpers/jquery.fancybox-thumbs.js"></script>
<script src='https://maps.googleapis.com/maps/api/js?key=AIzaSyC3nDHy1dARR-Pa_2jjPCjvsOR4bcILYsM'></script>
<script type="text/javascript" src="assets/js/function.js"></script>
<script type="text/javascript" src="assets/js/Modernizr.js"></script>
<script type="text/javascript" src="assets/js/jquery.plugin.js"></script>
<script type="text/javascript" src="assets/js/jquery.countdown.js"></script>
</body>
</html>