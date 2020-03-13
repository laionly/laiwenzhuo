<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/base.css">
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/iconfont.css">
		<script type="text/javascript" src="/DigitalShop/ManagementSystem/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/layui/css/layui.css">
		<script type="text/javascript" src="/DigitalShop/ManagementSystem/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="/DigitalShop/ManagementSystem/css/jquery.mCustomScrollbar.css">
		<script src="/DigitalShop/ManagementSystem/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/jquery.mousewheel.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="/DigitalShop/ManagementSystem/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>

	<body>
		<div class="cBody">
			<div class="layui-form-item">用户ID:${user.userid }</div>
			<c:if test="${empty(user.collects)}">该用户收藏为空</c:if>
			<c:if test="${!empty(user.collects)}">
			<div class="layui-form-item">用户 ${user.username } 的收藏</div>
			<table class="layui-table" >
				<thead>
					<tr>
						<th>收藏项ID</th>
						<th>收藏商品</th>
						<th>商品图片</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="i" items="${user.collects }">
					<tr>
						<td>${i.cid}</td>
						<td>${i.product.name}</td>
						<td><img src="Productimg/upload/${i.product.listimg}" width="20" height="20" style="max-width: none;" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td>
							<a href="/DigitalShop/DelCollect?cid=${i.cid}"><button class="layui-btn layui-btn-xs" >移除收藏</button></a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			
			<div class="layui-form-item"></div>
			<div class="layui-form-item">用户ID:${user.userid }</div>
			<c:if test="${empty(user.orders)}">该用户订单为空</c:if>
			<c:if test="${!empty(user.orders)}">
			<div class="layui-form-item">用户 ${user.username } 的订单</div>
				<table class="layui-table">
					<thead>
						<tr>
							<th>收货人</th>
							<th>订单ID</th>
							<th>收货地址</th>
							<th>联系方式</th>
							<th>订单金额</th>
							<th>下单时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach var="i" items="${user.orders }">
						<tr>
							<td>${i.name}</td>
							<td><a href="/DigitalShop/UserOrder?orderid=${i.orderid}">${i.orderid}</a></td>
							<td>${i.address}</td>
							<td>${i.phone}</td>
							<td>${i.orderprice}</td>
							<td>${i.ordertime}</td>
							<td>
								<a href="/DigitalShop/UsersDelete?id="><button class="layui-btn layui-btn-xs" >删除订单</button></a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</body>

</html>