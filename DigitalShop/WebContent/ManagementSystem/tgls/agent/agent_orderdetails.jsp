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
				<div class="layui-form-item">
					<a class="layui-btn layui-btn-sm layui-btn-normal" onclick="printTable('dayindaju1')">打印</a>
				</div>
			</div>
			
			<div class="layui-row" id="dayindaju1">
				<table class="layui-table printTable">
					<tbody>
						<tr>
							<td class="printName" colspan="7">订单详情</td>
						</tr>
						<tr>
							<td class="printDis" colspan="7">
								<span>订单编号：${userorder.orderid}</span>
							</td>
						</tr>
						<tr>
							<th width="8%" class="textCenter">序号</th>
							<th width="10%" class="textCenter">商品名称</th>
							<th width="20%" >商品描述</th>
							<th width="10%" class="textCenter">商品图片</th>
							<th width="10%" class="textCenter">下单数量</th>
							<th width="10%" class="textCenter">商品单价</th>
							<th width="10%" class="textCenter">下单金额</th>
							
						</tr>
						
						<c:forEach var="i" items="${userorder.productItems}">
						<tr>
							<td class="textCenter">${i.productItemid }</td>
							<td>${i.name }</td>
							<td class="textCenter">${i.description}</td>
							<td class="textCenter"><img src="Productimg/upload/${i.listimg}" style="max-width: none;" width="20" height="20" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
							<td class="textCenter">${i.count}</td>
							<td class="textCenter">${i.discountprice}</td>
							<td class="textCenter">${i.productItemprice}</td>
						</tr>
						</c:forEach>
						
			            <tr>
			                <td class="textCenter">总计</td>
			                <td></td>
			                <td></td>
							<td class="textCenter"></td>
							<td class="textCenter">${userorder.number}</td>
							<td></td>
			                <td class="textCenter">${userorder.orderprice}</td>
			            </tr>
						<tr>
							<td class="" colspan="7" style="padding: 20px;">
								<span style="float: left;">下单用户：${userorder.user.username}</span>
								<span style="margin: 40px;">联系方式：${userorder.phone}</span>
								<span>地址：${userorder.address}</span>
								<span style="float: right;">下单日期：${userorder.ordertime}</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<script>
			//打印方法
		    function printTable(id){
		    	$('#'+id).printThis({ importCss: true, importStyle: true });
		    }
		</script>
	</body>

</html>