package com.ep.ep.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;
import com.ep.ep.service.Shop_CartService;
import com.ep.ep.service.UserService;
import com.ep.ep.util.ChangeNum;
import com.ep.ep.util.Page;

@Controller
public class IUserController {
	@Autowired
	UserService us;
	@Autowired 
	Shop_CartService sc;

	// 用户注册
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = new User(request.getParameter("username"), request.getParameter("password"),
				request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"));
		//用户注册时，通过名字查找数据库信息，若存在则不能注册
		String psw=request.getParameter("password");
		String psw1=request.getParameter("password1");
		User findUsername=us.findUserByUname(user.getUsername());
		User findPhone=us.findByPhone(user.getPhone());
		User findEmail=us.findByEmail(user.getEmail());
		if (!user.getUsername().equals("")) {
			if (findUsername==null) {
				if (!user.getPhone().equals("")) {
					if (findPhone==null) {
						if (!user.getEmail().equals("")) {
							if (findEmail==null) {
								if (!psw.equals("") || !psw1.equals("")) {
									if (psw.equals(psw1)) {
										us.addUser(user);
										response.getWriter().println("<script>alert('注册成功！！！');window.location='login.jsp'</script>");
									}else {
										response.getWriter().println("<script>alert('两次输入密码不相同！');window.location='login.jsp'</script>");
									}
								}else {
									response.getWriter().println("<script>alert('密码不能为空！');window.location='login.jsp'</script>");
								}
							}else {
								response.getWriter().println("<script>alert('邮箱号已被注册！');window.location='login.jsp'</script>");
							}
						}else {
							response.getWriter().println("<script>alert('邮箱号不能为空！');window.location='login.jsp'</script>");
						}
					}else {
						response.getWriter().println("<script>alert('手机号已被注册！');window.location='login.jsp'</script>");
					}
				}else {
					response.getWriter().println("<script>alert('手机号不能为空！');window.location='login.jsp'</script>");
				}
				
			}else {
				response.getWriter().println("<script>alert('用户名已存在！');window.location='login.jsp'</script>");
			}
		}else {
			response.getWriter().println("<script>alert('用户名不能为空！');window.location='login.jsp'</script>");
		}
		

	}

	// 用户登录
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("isLogin");
		User user = us.login(request.getParameter("username"), request.getParameter("password"));
		if ("y".equals(flag)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", URLEncoder.encode(request.getParameter("username"),"UTF-8"));
			// 设置Cookie的有效期为3天
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			Cookie pwdCookie = new Cookie("password", request.getParameter("password"));
			//设置Cookie的有效期为3天
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
		} else {
			Cookie pwdCookie = new Cookie("password", request.getParameter("password"));
			//清除cookie
			pwdCookie.setMaxAge(0);
			response.addCookie(pwdCookie);
		}
		if (user != null) {
			//设置Session作用域，通过请求转发传进jsp页面
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("uid", user.getUid());
			//设置session作用域时长，默认的过期时间是30分钟
			request.getSession().setMaxInactiveInterval(36000);
			response.getWriter().println("<script>alert('登录成功！！！');window.location='index.jsp'</script>");
		} else {
			response.getWriter().println("<script>alert('账号或密码错误，请重新登录');window.location='login.jsp'</script>");
		}
		return null;
	}

	// 查看用户个人信息通过ID
	@RequestMapping(value = "findUserByUid", method = RequestMethod.GET)
	public String findUserByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//通过id查找用户信息
		User user = us.findUserByUid(Integer.parseInt(request.getParameter("uid")));
		//设置Session作用域，通过请求转发传进jsp页面
		request.getSession().setAttribute("user", user);
		return "/information.jsp";
	}

	// 更新用户个人信息
	@RequestMapping(value = "updataUser", method = RequestMethod.POST)
	public String updataUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取POST/GET传递的参数值
		User user = new User((Integer) request.getSession().getAttribute("uid"), request.getParameter("username"),
				request.getParameter("password"), request.getParameter("address"), request.getParameter("phone"),
				request.getParameter("email"));
		us.updataUser(user);
		//设置request作用域，通过请求转发传进jsp页面
		request.setAttribute("user", user);
		return "/information.jsp";
	}

	// 用户查看收藏夹
	@RequestMapping(value = "checkIFocustables", method = RequestMethod.GET)
	public String checkIFocustables(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = us.checkFoucstable((Integer) request.getSession().getAttribute("uid"));
		request.setAttribute("user", user);
		//请求转发
		return "/wishlist.jsp";
	}

	// 用户查看购物车
	@RequestMapping(value = "checkShopCartByUid", method = RequestMethod.GET)
	public String checkShopCartByUid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//通过uid来查找用户的购物车，返回一个shop_cart集合
		List<Shop_cart> shop_carts = us.checkShopCart((Integer) request.getSession().getAttribute("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//计算购物车每一项的总价
			double amount = shop_cart.getProducts().getPrice() * shop_cart.getShoppingnum();
			shop_cart.setAmount(amount);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		//设置request作用域，通过请求转发传进jsp页面
		request.setAttribute("allAmount", allAmount);
		request.setAttribute("shop_carts", shop_carts);
		//请求转发
		return "/shopping-cart.jsp";
	}
	//增加商品(有BUG)
	@RequestMapping(value = "changeShop_CartNumAdd", method = RequestMethod.POST)
	public void changeShop_CartNumAdd(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String json) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取json传转换成java对象
		ChangeNum cn = JSON.parseObject(json, ChangeNum.class);
		//增加商品数量
		cn.setShoppingnum(cn.getShoppingnum() + 1);
		int cid = cn.getCid();
		Shop_cart shop_cart1 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新商品数量
		us.updateProductnum(shop_cart1);
		//通过uid查找购物车
		List<Shop_cart> shop_carts = us.checkShopCart((Integer) request.getSession().getAttribute("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//遍历List集合，计算一项购物项的总价=商品单价*数量
			double amount = shop_cart.getProducts().getPrice() * shop_cart.getShoppingnum();
			//计算购物车每一项的总价
			shop_cart.setAmount(amount);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		Shop_cart shop_cart2 = us.findShop_CartByCid(cid);
		//设置购物车每一项总价
		cn.setAmount(shop_cart2.getShoppingnum() * shop_cart2.getProducts().getPrice());
		//设置购物车总价
		cn.setAllAmount(allAmount);
		Shop_cart shop_cart3 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新购物车总价
		us.updateProductnum(shop_cart3);
		//将java对象转化成json串
		response.getWriter().write(JSONObject.toJSONString(cn));

	}
	//减少商品(有BUG)
	@RequestMapping(value = "changeShop_CartNumDel", method = RequestMethod.POST)
	public void changeShop_CartNumDel(HttpServletRequest request, HttpServletResponse response,
			@RequestBody String json) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取json传转换成java对象
		ChangeNum cn = JSON.parseObject(json, ChangeNum.class);
		//减少商品数量
		cn.setShoppingnum(cn.getShoppingnum() - 1);
		int cid = cn.getCid();
		Shop_cart shop_cart1 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新商品数量
		us.updateProductnum(shop_cart1);
		//通过uid查找购物车
		List<Shop_cart> shop_carts = us.checkShopCart((Integer) request.getSession().getAttribute("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//遍历List集合，计算一项购物项的总价=商品单价*数量
			double amount = shop_cart.getProducts().getPrice() * shop_cart.getShoppingnum();
			//计算购物车每一项的总价
			shop_cart.setAmount(amount);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		Shop_cart shop_cart2 = us.findShop_CartByCid(cid);
		//设置购物车每一项总价
		cn.setAmount(shop_cart2.getShoppingnum() * shop_cart2.getProducts().getPrice());
		//设置购物车总价
		cn.setAllAmount(allAmount);
		Shop_cart shop_cart3 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新购物车总价
		us.updateProductnum(shop_cart3);
		//将java对象转化成json串
		response.getWriter().write(JSONObject.toJSONString(cn));

	}
	//用户从购物车下订单
	@RequestMapping(value = "place_order", method = RequestMethod.POST)
	public void place_order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*为了防止购物车没有商品，通过获取用户购物车商品数量如果没有商品则不能下单*/
		double amount=us.Amount((Integer) request.getSession().getAttribute("uid"));
		if(amount>0){
			if (!request.getParameter("address").equals("") && !request.getParameter("phone").equals("") && !request.getParameter("name").equals("")) {
				Date date=new Date();//获取当前时间
				//转化时间格式
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
				String ordertime=sdf.format(date.getTime());
				//创建订单
				Orderbase orderbase = new Orderbase((Integer) request.getSession().getAttribute("uid"), 
						amount, ordertime, request.getParameter("address"),  
						request.getParameter("phone"), request.getParameter("name"));
				//添加订单
				us.place_orderByUid(orderbase);
				//查找购物车全部商品
				List<Shop_cart> shop_carts = us.checkShopCart((Integer) request.getSession().getAttribute("uid"));
				for (Shop_cart shop_cart : shop_carts) {
					//购物车一项商品项对应一项详情订单项
					Orderitem orderitem=new Orderitem(orderbase.getOrid(), shop_cart.getProduct_id(), shop_cart.getShoppingnum(), 
							shop_cart.getProducts().getName(), shop_cart.getProducts().getPrice(), 
							shop_cart.getProducts().getRprice(), shop_cart.getProducts().getPicture());
					//添加详情订单
					us.place_orderByOrid(orderitem);
					//添加详情订单同时删除购物车项
					us.deleteShop_cartByCid(shop_cart.getCid());
				}
				response.getWriter().println("<script>alert('下单成功！！！');window.location='index.jsp'</script>");
			}else {
//				response.sendRedirect("allAmount");
				response.getWriter().println("<script>alert('请填写完整的收货信息！');window.location='allAmount'</script>");
				
			}
		}else{
			response.getWriter().println("<script>alert('您的购物车里没有商品');window.location='index.jsp'</script>");
		}
		
	}
	//退出登录
	@RequestMapping(value="userLogout", method = RequestMethod.GET)
	@SuppressWarnings("rawtypes")
	public void userLogout(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//实现用户注销功能
		Enumeration em = request.getSession().getAttributeNames();
		 while(em.hasMoreElements()){
			 //清空session值
			 request.getSession().removeAttribute(em.nextElement().toString());
			 response.getWriter().println("<script> alert('注销成功');window.location='login.jsp'</script>");
		 }
	}
	//用户查看订单
	@RequestMapping(value="checkOrder", method = RequestMethod.GET)
	public String checkOrder(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int pagenum = 1;//分页设置，从第几项开始
		int size=5;//分页设置，每次显示几项
		if (request.getParameter("pagenum")==null) {
			if (request.getParameter("nowpage")==null) {
				pagenum = 1;
			}else{
				String page = request.getParameter("nowpage");
				pagenum = Integer.valueOf(page);
			}
		}else {
			String page = request.getParameter("pagenum");
			pagenum = Integer.valueOf(page);
		}
		Math.abs((pagenum-1)*size);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", Math.abs((pagenum-1)*size));//分页设置，从第几项开始，0表示第一项
		params.put("size", size);//分页设置，每次显示几项
		params.put("uid",(Integer) request.getSession().getAttribute("uid"));
		Page<Orderbase> pager = new Page<Orderbase>(pagenum,size);
		//查看全部订单，传入page，size，uid
		List<Orderbase> orderbases=us.checkOrderByUid(params);
		//设置总数据
		pager.setTotalCount(us.count((Integer) request.getSession().getAttribute("uid")));
		pager.setList(orderbases);
		request.setAttribute("orderlist",pager);
		//请求转发
		return "/order.jsp";
	}
	//用户查看详情订单
	@RequestMapping(value="checkOrderitem", method = RequestMethod.GET)
	public String checkOrderitem(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int pagenum = 1;//分页设置，从第几项开始
		int size=5;//分页设置，每次显示几项
		if (request.getParameter("pagenum")==null) {
			if (request.getParameter("nowpage")==null) {
				pagenum = 1;
			}else{
				String page = request.getParameter("nowpage");
				pagenum = Integer.valueOf(page);
			}
		}else {
			String page = request.getParameter("pagenum");
			pagenum = Integer.valueOf(page);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", Math.abs((pagenum-1)*size));
		params.put("size", size);
		int orid=0;
		//为了防止获取不到orid值
		if (request.getParameter("orid")!=null) {
			//获取POST/GET传递的参数值
			orid=Integer.parseInt(request.getParameter("orid"));
			params.put("orid", orid);
		}else {
			//获取session作用域的值
			orid=(Integer)request.getSession().getAttribute("orid");
			params.put("orid",orid);
		}
		Page<Orderitem> pager = new Page<Orderitem>(pagenum,size);
		//查看全部详情订单也就是每一项订单里有什么商品，传入page，size，uid
		List<Orderitem> orderitems=us.checkOrderItemByOrdi(params);
		pager.setList(orderitems);
		//设置总数据
		pager.setTotalCount(us.productCount(orid));
		request.setAttribute("orderitems", pager);
		//把orid设置进session作用域，方便获取
		request.getSession().setAttribute("orid", orid);
		//请求转发
		return "/orderitem.jsp";
	}
	//下订单跳转计算总价
	@RequestMapping(value="allAmount", method = RequestMethod.GET)
	public String allAmount(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//计算购物车总价
		double allAmount = us.Amount((Integer) request.getSession().getAttribute("uid"));
		//设置request作用域值
		request.setAttribute("allAmount", allAmount);
		//请求转发
		return "/checkout.jsp";
	}
	//从收藏夹添加商品进购物车
	@RequestMapping(value="addProductinShop_Cart", method = RequestMethod.GET)
	public String addProductinShop_Cart(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/**
		 * 通过pid查询用户购物车，如果查询到用户收藏夹里没有此类商品
		 * 就添加此类商品进用户购物车后从收藏夹删除此类商品
		 * 若通过pid查询用户购物车，如查询到用户收藏夹里有此类商品
		 * 就更新购物车此类商品数量
		 */
		Shop_cart shop_cart=sc.findShop_cartByPid(Integer.parseInt(request.getParameter("pid")));
		if (shop_cart==null) {
			sc.addShop_cart((Integer) request.getSession().getAttribute("uid"), 
					Integer.parseInt(request.getParameter("pid")), 1);
			User user = us.checkFoucstable((Integer) request.getSession().getAttribute("uid"));
			request.setAttribute("user", user);
		}else {
			Shop_cart shop_cart1=sc.findShop_cartByPid(Integer.parseInt(request.getParameter("pid")));
			shop_cart1.setShoppingnum(shop_cart1.getShoppingnum()+1);
			sc.updataShop_Cart(shop_cart1);
			User user = us.checkFoucstable((Integer) request.getSession().getAttribute("uid"));
			request.setAttribute("user", user);
		}
		return "/wishlist.jsp";
	}
	//删除收藏夹里的商品项（取消收藏）
	@RequestMapping(value="deleteFocustable", method = RequestMethod.GET)
	public String deleteFocustable(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		us.deleteFocustable(Integer.parseInt(request.getParameter("pid")));
		User user = us.checkFoucstable((Integer) request.getSession().getAttribute("uid"));
		request.setAttribute("user", user);
		return "/wishlist.jsp";
	}
	//注册时检测用户名是否重复
	@RequestMapping(value="checkUsername", method = RequestMethod.GET)
	public String checkUsername(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username=request.getParameter("username");
		User user=us.findUserByUname(username);
		if(user!=null) {
			response.getWriter().write("用户名"+username+"已存在");
		}else if(username.equals("")){
			response.getWriter().write("用户名不能为空");
		}else {
			response.getWriter().write(" ");
		}
		return null;
	}
	
	  //注册时检测手机号是否重复
		@RequestMapping(value="checkPhone", method = RequestMethod.GET)
		public String checkPhone(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String phone=request.getParameter("phone");
			User user=us.findByPhone(phone);
			if(user!=null) {
				response.getWriter().write("手机号"+phone+"已被注册");
			}else if(phone.equals("")){
				response.getWriter().write("手机号不能为空");
			}else {
				response.getWriter().write(" ");
			}
			return null;
		}
		//注册时检测邮箱号是否重复
		@RequestMapping(value="checkEmail", method = RequestMethod.GET)
		public String checkEmail(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String email=request.getParameter("email");
			User user=us.findByEmail(email);
			if(user!=null) {
				response.getWriter().write("邮箱号"+email+"已被注册");
			}else if(email.equals("")){
				response.getWriter().write("邮箱号不能为空");
			}else {
				response.getWriter().write(" ");
			}
			return null;
		}
}
