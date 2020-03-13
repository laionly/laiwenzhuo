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
			<div class="console">
				<form class="layui-form" action="/DigitalShop/agentquery" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="输入会员名称" autocomplete="off" class="layui-input">
						</div>
						<input class="layui-btn" type="submit" value="检索">
						<buttom class="layui-btn" type="submit" onclick="window.location.href='/DigitalShop/UserList'">检索全部</buttom>
					</div>
				</form>
				
			</div>
			<div class="pages">
				检索到${userslist.totalCount}条数据
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>用户ID</th>
						<th>用户名</th>
						<th>头像</th>
						<th>联系方式</th>
						<th>邮箱</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var="i" items="${userslist.list}">
					<tr>
						<td>${i.userid}</td>
						<td><a href="/DigitalShop/selUser?id=${i.userid}">${i.username}</a></td>
						<td><img src="/img/${i.head_portrait}" width="20" height="20" style="max-width: none;" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td>${i.phone}</td>
						<td>${i.email}</td>
						<td>${i.address}</td>
						<td>
							<a href="/DigitalShop/DeleteUser?id=${i.userid}"><button class="layui-btn layui-btn-xs" >删除用户</button></a>
							<button class="layui-btn layui-btn-xs" onclick="window.location.href='/DigitalShop/ManagementSystem/tgls/users_password.jsp?id=${i.userid}'">修改密码</button>
						</td>
					</tr>
					</c:forEach>

				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<div class="pages" style="margin-left:10px;">
				<button class="layui-btn layui-btn-xs" style="float: left;margin-left:5px;" onclick="window.location.href='UserList?pagenum=${pagelist.prePageNum}'">上一页</button>
				<form class="layui-form" style="float: left;" action="/DigitalShop/UserList" method="get">
					<font style="margin-left:5px;">当前页数</font>
					<input style="margin-left:0px;width:25px;" type="text" name="nowpage" value="${userslist.pageNum}"/>
					<font style="margin-left:5px;">总页数${userslist.totalPageNum}</font>
					<input class="layui-btn layui-btn-xs" type="submit" value="跳转"/>
				</form>
				<button style="margin-left:5px;" class="layui-btn layui-btn-xs" onclick="window.location.href='UserList?pagenum=${pagelist.nextPageNum}'">下一页</button>
			</div>
		</div>
	</body>

</html>