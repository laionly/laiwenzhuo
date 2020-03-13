<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8">
    <title>Dagon</title>
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png"/>
    <link rel="stylesheet" type="text/css" href="assets/fonts/flaticon/flaticon.css">
    <link rel="stylesheet" type="text/css" href="assets/css/animate.css">
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" type="text/css" href="assets/css/pe-icon-7-stroke.css">
    <link rel="stylesheet" type="text/css" href="assets/css/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="assets/css/chosen.css">
    <link rel="stylesheet" type="text/css" href="assets/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="assets/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
</head>
<body class="page-product grid-view">
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
                    <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o" aria-hidden="true"></i>Add to Wishlist</a>
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
                    <c:if test="${!empty(sessionScope.user.username) }"><li><a href="findUserByUid?uid=${sessionScope.user.uid }">欢迎你${sessionScope.user.username }</a></li></c:if>
                 <c:if test="${!empty(sessionScope.user.username) }"><li><a href="userLogout">退出登录</a></li></c:if> 
                </ul><!-- hotline -->
                <!-- heder links -->
                <ul class="nav-top-right dagon-nav">
                    <li class="menu-item-has-children">
                        <a href="#" class="dropdown-toggle">
                            <img src="assets/images/general/l1.jpg" alt="flag">English<i class="fa fa-angle-down"
                                                                                         aria-hidden="true"></i>
                        </a>
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
                    <c:if test="${empty(sessionScope.user.username) }"><li><a href="login.jsp"><i class="flaticon-profile" aria-hidden="true"></i>注册 / 登录</a></li></c:if>
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
                        </strong><!-- logo -->
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
                                    <form>
                                        <div class="box-group">
                                            <input type="text" class="form-control"
                                                   placeholder="Search keyword here...">
                                            <button class="btn btn-search" type="button"><span
                                                    class="flaticon-magnifying-glass"></span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div><!-- block search -->
                    </div>
                    <div class="col-md-2 nav-right">
                        <!-- block mini cart -->
                        <div class="block-minicart dropdown">
                            <a class="minicart" href="#">

                                    <span class="counter qty">

                                        <span class="cart-icon"><i class="flaticon-shopping-cart"
                                                                   aria-hidden="true"></i></span>

                                        <span class="counter-number">2</span>

                                    </span>
                                <span class="counter-your-cart">

                                        <span class="counter-label">购物车:</span>

                                        <span class="counter-price">$00.00</span>

                                    </span>
                            </a>
                            <div class="parent-megamenu">
                                <form>
                                    <div class="minicart-content-wrapper">
                                        <div class="subtitle">
                                                                              你的购物车有<span>2</span>件商品
                                        </div>
                                        <div class="minicart-items-wrapper">
                                            <ol class="minicart-items">
                                                <li class="product-inner">
                                                    <div class="product-thumb style1">
                                                        <div class="thumb-inner">
                                                            <a href="#"><img src="assets/images/home1/c1.jpg"
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
                                                            <a href="#"><img src="assets/images/home1/c2.jpg"
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
                                            <a class="btn btn-checkout" href="checkout.html">订单</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div><!-- block mini cart -->
                        <a href="#" class="hidden-md search-hidden"><span class="flaticon-magnifying-glass"></span></a>
                        <a class="wishlist-minicart" href="wishlist.jsp"><i class="fa fa-heart-o" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div><!-- header-content -->
        <!-- header-menu-bar -->
        <div class="header-menu-bar header-sticky">
            <div class="header-menu-nav menu-style-2">
                <div class="container">
                    <div class="header-menu-nav-inner">
                        <div id="box-vertical-megamenus" class="box-vertical-megamenus nav-toggle-cat">
                            <h4 class="title active">

                                    <span class="btn-open-mobile home-page">

                                        <span></span>

                                        <span></span>

                                        <span></span>

                                    </span>
                                <span class="title-menu">All Departments</span>
                            </h4>
                            <div class="vertical-menu-content">
                                <span class="btn-close hidden-md"><i class="flaticon-close" aria-hidden="true"></i></span>
                                <ul class="vertical-menu-list">
                                    <li><a href="#">New Arrivals</a></li>
                                    <li class="menu-item-has-children arrow item-megamenu">
                                        <a href="#" class="dropdown-toggle">Tv & Audio</a>
                                        <span class="toggle-submenu hidden-md"></span>
                                        <div class="submenu parent-megamenu megamenu">
                                            <div class="row">
                                                <div class="submenu-banner submenu-banner-menu-1">
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Smartphone</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Monitors
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Tablet</a></li>
                                                                    <li class="menu-item"><a href="#">Computer
                                                                        </a></li>
                                                                    <li class="menu-item"><a href="#">Bestseller</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Top Rated</a></li>
                                                                    <li class="menu-item"><a href="#">Office</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Networking</a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Computer</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Smart
                                                                        Computer</a></li>
                                                                    <li class="menu-item"><a href="#">Bluetooth
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Soundbars</a></li>
                                                                    <li class="menu-item"><a href="#">
                                                                        Computer</a></li>
                                                                    <li class="menu-item"><a href="#">New Arrivals</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Monitors</a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="menu-item-has-children arrow item-megamenu">
                                        <a href="#" class="dropdown-toggle">Laptop</a>
                                        <span class="toggle-submenu hidden-md"></span>
                                        <div class="submenu parent-megamenu megamenu">
                                            <div class="row">
                                                <div class="submenu-banner submenu-banner-menu-1">
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Smartphone</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Monitors
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Tablet</a></li>
                                                                    <li class="menu-item"><a href="#">Computer
                                                                        </a></li>
                                                                    <li class="menu-item"><a href="#">Bestseller</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Top Rated</a></li>
                                                                    <li class="menu-item"><a href="#">Office</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Networking</a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Computer</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Smart
                                                                        Computer</a></li>
                                                                    <li class="menu-item"><a href="#">Bluetooth
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Soundbars</a></li>
                                                                    <li class="menu-item"><a href="#">
                                                                        Computer</a></li>
                                                                    <li class="menu-item"><a href="#">New Arrivals</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Monitors</a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="#">Computer</a>
                                    </li>
                                    <li><a href="#">Smartphone </a></li>
                                    <li class="menu-item-has-children arrow item-megamenu">
                                        <a href="#" class="dropdown-toggle">Printers</a>
                                        <span class="toggle-submenu hidden-md"></span>
                                        <div class="submenu parent-megamenu megamenu">
                                            <div class="row">
                                                <div class="submenu-banner submenu-banner-menu-1">
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Camera</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Monitor
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Speakers</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Tablet
                                                                        Computer</a></li>
                                                                    <li class="menu-item"><a href="#">Monitors</a></li>
                                                                    <li class="menu-item"><a href="#">Projector</a></li>
                                                                    <li class="menu-item"><a href="#">Office</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Networking</a>
                                                                    </li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <div class="dropdown-menu-info">
                                                            <h6 class="dropdown-menu-title">Computer</h6>
                                                            <div class="dropdown-menu-content">
                                                                <ul class="menu">
                                                                    <li class="menu-item"><a href="#">Computer</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Phone
                                                                    </a></li>
                                                                    <li class="menu-item"><a href="#">Printers</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Game & Consoles</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">New Arrivals</a>
                                                                    </li>
                                                                    <li class="menu-item"><a href="#">Monitors</a></li>
                                                                </ul>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="#">Camera</a></li>
                                    <li><a href="#">Game & Consoles</a></li>
                                    <li><a href="#">Tablet</a></li>
                                    <li><a href="#">Monitors</a></li>
                                    <li><a href="#">Drivers</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="header-menu header-menu-resize">
                            <ul class="header-nav dagon-nav">
                                <li class="btn-close hidden-md"><i class="flaticon-close" aria-hidden="true"></i></li>
                                <li class="menu-item-has-children arrow">
                                    <a href="index.jsp" class="dropdown-toggle">首页</a>
                                    <span class="toggle-submenu hidden-md"></span>                               
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#" class="dropdown-toggle">商店</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="grid-product.html">网格商品</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="list-product.html">商品列表</a>
                                        </li>                                      
                                        <li class="menu-item">
                                            <a href="detail.html">商品详情</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#" class="dropdown-toggle">子菜单</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                    <ul class="submenu parent-megamenu">
                                        <li class="menu-item">
                                            <a href="checkOrder?uid=${sessionScope.user.uid }">我的订单</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="checkShopCartByUid?uid=${sessionScope.user.uid }">购物车</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="contact-us.html">联系我们</a>
                                        </li>                                   
                                        <li class="menu-item">
                                            <a href="checkIFocustables?uid=${sessionScope.user.uid }">我的收藏</a>
                                        </li>
                                        <li class="menu-item">
                                            <a href="compare.html">比较</a>
                                        </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="contact-us.html" class="dropdown-toggle">联系我们</a>
                                    <span class="toggle-submenu hidden-md"></span>
                                </li>
                                <li class="menu-item-has-children arrow">
                                    <a href="#" class="dropdown-toggle">博客</a>
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
                            </ul>
                        </div>
                        <span data-action="toggle-nav" class="menu-on-mobile hidden-md">

                                <span class="btn-open-mobile home-page">

                                    <span></span>

                                    <span></span>

                                    <span></span>

                                </span>

                                <span class="title-menu-mobile">Main menu</span> 

                            </span>
                    </div>
                </div>
            </div>
        </div>
    </header><!-- end HEADER -->
    <!-- MAIN -->
    <main class="site-main product-list product-grid">
        <div class="container">
            <ol class="breadcrumb-page">
                <li><a href="index.jsp">首页 </a></li>
                <li class="active"><a href="#">网格类别 </a></li>
            </ol>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-9 col-sm-8 float-none float-right">
                    <div class="main-content">
                        <div class="promotion-banner style-3">
                            <a href="#" class="banner-img"><img src="assets/images/product/banner-product.jpg"
                                                                alt="banner-product"></a>
                            <div class="promotion-banner-inner">
                                <h4>Top Staff Pick</h4>
                                <h3>Best Watches Collection</h3>
                                <a class="banner-link" href="grid-product.html">开始购物</a>
                            </div>
                        </div>
                        <div class="toolbar-products">
                            <h4 class="title-product">网格类别</h4>
                            <div class="toolbar-option">
                                <div class="toolbar-sort">
                                    <select title="sort" class="chosen-select sorter-options form-control">
                                        <option selected="selected" value="position">按人气排序</option>
                                        <option value="name">Name</option>
                                        <option value="price">Price</option>
                                    </select>
                                </div>
                                <div class="toolbar-per">
                                    <select title="limit" class="chosen-select limiter-options form-control">
                                        <option selected="selected" value="6">20 per page</option>
                                        <option value="15">15</option>
                                        <option value="30">30</option>
                                    </select>
                                </div>
                                <div class="modes">
                                    <a href="grid-product.html" class="active modes-mode mode-grid" title="Grid"><i
                                            class="fa fa-th-large"></i>
                                        <span>网格</span>
                                    </a>
                                    <a href="list-product.html" title="List" class="modes-mode mode-list"><i
                                            class="fa fa-bars"></i>
                                        <span>清单</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="products products-list products-grid equal-container auto-clear">
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p8.jpg" alt="p8"></a>
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
                                        <div class="info-product">
                                            <p>Weigh: 8.25 kg</p>
                                            <p>Size: One Size Fits All </p>
                                            <p>Guarantee: 2 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p9.jpg" alt="p9"></a>
                                        </div>
                                        <span class="onnew">new</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Smartphone 4 GB</a></div>
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
                                        <div class="info-product">
                                            <p>Display Size: 6</p>
                                            <p>Display Type: Linux</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p10.jpg" alt="p10"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Cellphone Factory</a></div>
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
                                        <div class="info-product">
                                            <p>Color: White</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p11.jpg" alt="p11"></a>
                                        </div>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Modern Watches</a></div>
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p12.jpg" alt="p12"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Ecase Leather
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p13.jpg" alt="p13"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">External Enclosure
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p14.jpg" alt="p14"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Smart Camera
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p15.jpg" alt="p15"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Gaming Mouse
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p16.jpg" alt="p16"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#"> Xphone Factory
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p17.jpg" alt="p17"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Flat Wireless Game
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p18.jpg" alt="p18"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Fly Camera
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style1 width-33 col-md-4 col-sm-6 col-xs-6 equal-elem">
                                <div class="product-inner">
                                    <div class="product-thumb">
                                        <div class="thumb-inner">
                                            <a href="#"><img src="assets/images/product/p19.jpg" alt="p19"></a>
                                        </div>
                                        <span class="onsale">-50%</span>
                                        <a href="#" class="quick-view">Quick View</a>
                                    </div>
                                    <div class="product-innfo">
                                        <div class="product-name"><a href="#">Extra Bass On
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
                                        <div class="info-product">
                                            <p>Hight precision lens provided</p>
                                            <p>Android Supported</p>
                                            <p>Guarantee: 1 Year</p>
                                        </div>
                                        <div class="single-add-to-cart">
                                            <a href="#" class="btn-add-to-cart">Add to cart</a>
                                            <a href="compare.html" class="compare"><i class="fa fa-exchange"></i>Compare</a>
                                            <a href="wishlist.jsp" class="wishlist"><i class="fa fa-heart-o"
                                                                            aria-hidden="true"></i>Wishlist</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="pagination">
                            <ul class="nav-links">
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li class="back-next"><a href="#">Next</a></li>
                            </ul>
                            <span class="show-resuilt">Showing 1-8 of 12 result</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-4">
                    <div class="col-sidebar">
                        <div class="filter-options">
                            <div class="block-title">Shop by</div>
                            <div class="block-content">
                                <div class="filter-options-item filter-categori">
                                    <div class="filter-options-title">Categories</div>
                                    <div class="filter-options-content">
                                        <ul>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Smartphone
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Computer
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Body
                                                Parts
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Printers
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Repair
                                                Partss</label>
                                            </li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Camera
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Monitors
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Office
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Tablets
                                            </label></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="filter-options-item filter-brand">
                                    <div class="filter-options-title">Brand</div>
                                    <div class="filter-options-content">
                                        <ul>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Networking</label>
                                            </li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Projector</label>
                                            </li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Bentley
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Honda
                                            </label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Mercedes
                                            </label></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="filter-options-item filter-price">
                                    <div class="filter-options-title">Price</div>
                                    <div class="filter-options-content">
                                        <div class="price_slider_wrapper">
                                            <div data-label-reasult="Price:" data-min="0" data-max="3000" data-unit="$"
                                                 class="slider-range-price " data-value-min="85" data-value-max="2000">
                                                <span class="text-right">Filter</span>
                                            </div>
                                            <div class="price_slider_amount">
                                                <div class="price_label">
                                                    Price: <span class="from">$85</span>-<span class="to">$2000</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="filter-options-item filter-size">
                                    <div class="filter-options-title">Size</div>
                                    <div class="filter-options-content">
                                        <ul>
                                            <li><label class="inline"><input type="checkbox"><span
                                                    class="input">S</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span
                                                    class="input">M</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span
                                                    class="input">L</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span
                                                    class="input">XL</span></label></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="filter-options-item filter-color">
                                    <div class="filter-options-title">Color</div>
                                    <div class="filter-options-content">
                                        <ul>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Red<span
                                                    class="value">(217)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Black<span
                                                    class="value">(79)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Grey<span
                                                    class="value">(116)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>While<span
                                                    class="value">(38)</span></label></li>
                                        </ul>
                                        <ul>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Yellow<span
                                                    class="value">(179)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Blue<span
                                                    class="value">(283)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Pink<span
                                                    class="value">(29)</span></label></li>
                                            <li><label class="inline"><input type="checkbox"><span class="input"></span>Green<span
                                                    class="value">(205)</span></label></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="block-banner-sidebar">
                            <a href="#"><img src="assets/images/product/banner-sidebar.jpg" alt="banner-sidebar"></a>
                            <div class="promotion-banner-inner">
                                <h4>Fly Drone</h4>
                                <h3>Tincidunt interdum senectus fames sociis sem platea </h3>
                                <a class="banner-link" href="grid-product.html">Shop now</a>
                            </div>
                        </div>
                        <div class="block-latest-roducts">
                            <div class="block-title">Latest Products</div>
                            <div class="block-latest-roducts-content">
                                <div class="owl-carousel nav-style2" data-nav="false" data-autoplay="false"
                                     data-dots="false" data-loop="true" data-margin="0"
                                     data-responsive='{"0":{"items":1},"600":{"items":1},"1000":{"items":1}}'>
                                    <div class="owl-ones-row">
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p1.jpg" alt="p1"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Homasy Portable</a></div>
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p2.jpg" alt="p2"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Lexani Forged</a>
                                                    </div>
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p3.jpg" alt="p3"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Custom Laptop
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p4.jpg" alt="p4"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Pocket RC Drone </a>
                                                    </div>
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
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="owl-ones-row">
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p1.jpg" alt="p1"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Homasy Portable</a></div>
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p2.jpg" alt="p2"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Lexani Forged</a>
                                                    </div>
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p3.jpg" alt="p3"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Custom Laptop
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
                                                </div>
                                            </div>
                                        </div>
                                        <div class="product-item style1">
                                            <div class="product-inner">
                                                <div class="product-thumb">
                                                    <div class="thumb-inner">
                                                        <a href="#"><img src="assets/images/blog/p4.jpg" alt="p4"></a>
                                                    </div>
                                                </div>
                                                <div class="product-innfo">
                                                    <div class="product-name"><a href="#">Pocket RC Drone </a>
                                                    </div>
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
    </main><!-- end MAIN -->
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