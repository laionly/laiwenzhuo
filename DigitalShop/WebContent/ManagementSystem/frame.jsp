<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>欢迎使用后台管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="/DigitalShop/ManagementSystem/images/favicon.ico"/>
		<link rel="bookmark" href="/DigitalShop/ManagementSystem/images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/base.css">
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/iconfont.css">
		<script type="text/javascript" src="/DigitalShop/ManagementSystem/framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="/DigitalShop/ManagementSystem/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/jquery.mCustomScrollbar.css">
		<script src="/DigitalShop/ManagementSystem/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/jquery.mousewheel.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/frameStyle.css">
		<script type="text/javascript" src="/DigitalShop/ManagementSystem/framework/frame.js" ></script>
		
	</head>

	<body>
		<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="/DigitalShop/ManagementSystem/images/timg.png"/>
		        <div class="logoText">
		            <h1>${sessionScope.ADMIN_SESSION.adminName}管理员</h1>
		            <p>管理员ID：${sessionScope.ADMIN_SESSION.id}</p>
		        </div>
		    </div>
		    <div class="menu">
		        <ul>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)" onclick="menuCAClick('../main',this)"><i class="iconfont icon-zhishi left"></i>后台首页</a>
		           </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yonghu left"></i>会员管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('../UserList',this)">会员列表</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>商品管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('../ProductList',this)">全部商品</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('/DigitalShop/ManagementSystem/tgls/goodsManage/goods_add.jsp',this)">发布商品</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>留言管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('/DigitalShop/ManagementSystem/newslist',this)">留言管理</a></dt>
		                </dl>
		           </li>
		           <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-dingdan left"></i>订单管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('/DigitalShop/ManagementSystem/orderlist',this)">订单管理</a></dt>
		                </dl>
		           </li>
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('tgls/admin_password.jsp',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="../Loginoff"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
			<!-- 头部栏 - 结束 -->
			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="../main" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
	</body>

</html>