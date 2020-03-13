<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
		<div class="layui-form-item">修改商品信息</div>
			<form id="addForm" class="layui-form" action="UpdateProduct?pid=${product.productid}&listimg=${product.listimg}" method="post" enctype="multipart/form-data" onsubmit="cPost();">
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-inline shortInput">
						<input type="text" value="${product.name}" name="name" required lay-verify="required|identity" autocomplete="off" class="layui-input">
					</div>
					
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品描述</label>
					<div class="layui-input-inline shortInput">
						<input type="text" value="${product.description}" name="description" required lay-verify="required|PriceCheck" autocomplete="off" class="layui-input">
					</div>
					
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品图片</label>
					<div class="layui-upload-drag" id="goodsPic">
						<img id="avatar-img" style="width: 100px; height: 100px;" src="Productimg/upload/${product.listimg}"/>
						<p>点击上传</p>
					</div>
					<input class="layui-upload-file" type="file" id="file" name="file">
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品价格</label>
					<div class="layui-input-inline shortInput">
						<input type="text" value="${product.price}" name="price" autocomplete="off" class="layui-input">
					</div>
					
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">折后价</label>
					<div class="layui-input-inline shortInput">
						<input type="text" value="${product.discountprice}" name="discountprice" autocomplete="off" class="layui-input">
					</div>
					
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="立即提交" >
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</body>
	<script type="text/javascript">
			$(document).ready(function(){
					$("#goodsPic").click(function(){
					$("#file").trigger("click");
				});
			});
			// 找到头像的input标签绑定change事件
			$("#file").change(function (e) {
				
				var fileMsg = e.currentTarget.files;
				
				// 1. 创建一个读取文件的对象
				var fileReader = new FileReader();
				// 读取你选中的那个文件
				fileReader.readAsDataURL(this.files[0]); // 读取文件是需要时间的
				fileReader.onload = function () {
					var fileSize = fileMsg[0].size;
					console.log(fileSize);
					if(fileSize>10000000){
						alert('文件太大');
						$("#file").val("");
						//file.after(file.clone().val(""));      
						//file.remove(); 
						return false;
					}else{
						
						// 2. 等上一步读完文件之后才 把图片加载到img标签中
						$("#avatar-img").attr("src", fileReader.result);
					}
					
					//alert(document.getElementById("avatar-img").src);
			};
		});	
			
			
			/* function f() {
				if($("#file").val()==null||$("#file").val()==""){
					alert('文件为空');
					return false;
				}
			}  */
		</script>
</html>