<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>商品详情</title>
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473973_udy02fgnf3m.css" />
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_1473987_p34tlh0h33f.css">
    <link rel="stylesheet" type="text/css" href="css/xiangqin.css">
    <script src="jquery-2.2.4.min.js"></script>
    <script src="js/cookie.js"></script>
    <script src="js/xiangqin.js"></script>
    
    
</head>
<body>

    <!-- header顶部导航-用户 -->
    <div class="header">
        <!-- 包裹左右模块的div -->
        <div class="header-wrap">
            <!-- 顶部导航左模块 -->
            <div class="header-left">
                <div class="menu">
                    <ul>
                        <li><a href="index.html">首页</a></li>
                        <li><a href="ProductListServlet">商城</a></li>
                        <li><a href="ShowCartServlet">去购物车</a></li>
                        <!-- <li><a href="">经验交流</a></li> -->
                        <li><a href="lianxi.html">联系我们</a></li>
                    </ul>
                </div>
            </div>
            <!-- 顶部导航右模块 -->
            <div class="header-right">
                <ul>
                    <li class="iconfont icon-icon-user"><a href=""></a></li>
                    <li class="iconfont icon-gouwuche"><a href=""></a></li>
                </ul>
            </div>
            <!-- 划过图标出现div -->
            <div class="yonghu">
                <div class="yonghubg"></div>
                <a href="login.html"><button>登录</button></a>
                <a href="zhuce.html"><button>注册</button></a>
            </div>
            <!-- 登出和个人信息 -->
            <div class="yonghu1">
                <div class="yonghubg1"></div>
                <a href="#"><button>登出</button></a>
                <a href="#"><button>信息</button></a>
            </div>
        </div>
    </div>

    <!-- header顶部导航-管理员——————————————————————————————————————————————————————————————————————————————————— -->
    <div class="header1">
        <!-- 包裹左右模块的div -->
        <div class="header1-wrap">
            <!-- 顶部导航左模块 -->
            <div class="header1-left">
                <div class="menu1">
                    <ul>
                        <li><a href="index.html">首页</a></li>
                        <li><a href="ProductListServlet">商城</a></li>
                        <li><a href="AdminAllListServlet">管理员列表</a></li>
                        <li><a href="UserAllListServlet">用户列表</a></li>
                        <li><a href="ProductAllListServlet">商品列表</a></li>
                    </ul>
                </div>
            </div>
            <!-- 顶部导航右模块 -->
            <div class="header1-right">
                <ul>
                    <li class="iconfont icon-icon-user"><a href=""></a></li>
                    <!-- <li class="iconfont icon-gouwuche"><a href=""></a></li> -->
                </ul>
            </div>
            <!-- 划过用户图标出现的div -->
            <div class="yonghu">
                <div class="yonghubg"></div>
                <a href="login.html"><button>登录</button></a>
                <a href="zhuce.html"><button>注册</button></a>
            </div>
            <!-- 登录后更改信息 -->
            <div class="yonghu2">
                <div class="yonghubg2"></div>
                <a href="#"><button>登出</button></a>
                <a href="#"><button>信息</button></a>
            </div>
        </div>
    </div>
    <!-- —————————————————————————————————————————————————————————————————————————————————————————————————————— -->

    <<div class="middle">
             <li id="kbig">
				<img src="images/足球/${product_zq_xq.listimg}">
			</li>
        <h2>乔丹${product_zq_xq.name }官方正品成人专用7号球学生室外${product_zq_xq.name }真皮 耐磨${product_zq_xq.name }AOA</h2>
        <div class="touwrap">
            <div class="tou">
                <p>价格<del>￥${product_zq_xq.price}</del></p>
                <p>促销价<span>￥${product_zq_xq.discountprice}</span></p>
            </div>
            <li class="kuaidi"><span id="yunfei">运费</span><span>北京</span><span>至</span>
                <select style="width: 80px;height: 30px;">
                    <option>南宁</option>
                    <option>来宾</option>
                    <option>百色</option>
                    <option>桂林</option>
                </select>
                <span>快递包邮</span>
            </li>
            <div class="number">
                <p>
                    <span style="color: gray;">月销量<i style="color: red;font-weight: bold;">2.0万+</i></span>
                    <span style="color: gray;">累计评价<i style="color: red;font-weight: bold;"">2432566</i></span>
                               <span style=" color: gray;">送天猫积分<i style="color:green;font-weight: bold;"">77</i></span>
                           </p>
                      </div>		                                       
                           <p class=" num1"><span>数量</span><input style="margin-right: 10px;" type="text"
                                    name="num" value="1">件<span style="color: gray;margin-left: 30px;">库存12134件</span></p>
                       <span style="color: gray;float: left;margin-top:25px;margin-right: 30px;">颜色分类</span>
		   <ul class="kankan">
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152733.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152755.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152816.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152820.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152812.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152809.jpg"></li>
			<li><img class="ksmall" src="images/篮球1/QQ图片20191114152801.jpg"></li>
		</ul>
                <div class="button">
                    <li class="iconfont icon-gouwuche"></li>
                    <a href="CartServlet?id=${product_zq_xq.id}"><button>加入购物车</button></a>
                </div>	
        </div>
     </div>
        <!-- 底部导航 -->
        <div class="footer">
            <div class="footer-wrap">
                <div class="row">
                    <div class="footer-ul">
                        <ul>
                            <h4>商品</h4>
                            <li><a href="#">篮球</a></li>
                            <li><a href="#">足球</a></li>
                            <li><a href="#">羽毛球</a></li>
                        </ul>
                    </div>
                    <div class="footer-ul">
                        <ul>
                            <h4>关于</h4>
                            <li><a href="#">价格</a></li>
                            <li><a href="#">质量</a></li>
                            <li><a href="#">保障
                                </a></li>
                        </ul>
                    </div>
                    <div class="footer-ul">
                        <ul>
                            <h4>客户支持</h4>
                            <li><a href="lianxi.html">联系我们</a></li>
                            <li><a href="#">订单跟踪</a></li>
                            <li><a href="personal.html">个人信息</a></li>
                        </ul>
                    </div>
                    <div class="footer_bottom">
                        <div class="copy">
                            <p>世纪之歌小组.</p>
                        </div>
                    </div>
                </div>
            </div>
    
        </div>

</body>

</html>