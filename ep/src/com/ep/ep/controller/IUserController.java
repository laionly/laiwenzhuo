package com.ep.ep.controller;


import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.entity.Product;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;
import com.ep.ep.service.Shop_CartService;
import com.ep.ep.service.UserService;
import com.ep.ep.util.ChangeNum;
import com.ep.ep.util.Page;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"user","uid","orid"})//设置session作用域
public class IUserController {
	@Autowired
	UserService us;
	@Autowired
	Shop_CartService sc;


	/** 用户注册
	 * @param user 请求参数绑定实体类对象 
	 * 要求input框里的name属性和实体类的属性名相同，相当于映射
	 * @param password1 请求参数绑定String对象
	 * 要求input框里的name属性和对象属性名相同，相当于映射
	 *
	 */
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public void addUser( HttpServletResponse response,User user,String password1) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//用户注册时，通过名字查找数据库信息，若存在则不能注册
		User findUsername=us.findUserByUname(user.getUsername());
		User findPhone=us.findByPhone(user.getPhone());
		User findEmail=us.findByEmail(user.getEmail());
		if (!user.getUsername().equals("")) {
			if (findUsername==null) {
				if (!user.getPhone().equals("")) {
					if (findPhone==null) {
						if (!user.getEmail().equals("")) {
							if (findEmail==null) {
								if (!user.getPassword().equals("") || !password1.equals("")) {
									if (user.getPassword().equals(password1)) {
										us.addUser(user);
										response.getWriter().println("<script>alert('注册成功！！！');window.location='../login.jsp'</script>");
									}else {
										response.getWriter().println("<script>alert('两次输入密码不相同！');window.location='../login.jsp'</script>");
									}
								}else {
									response.getWriter().println("<script>alert('密码不能为空！');window.location='../login.jsp'</script>");
								}
							}else {
								response.getWriter().println("<script>alert('邮箱号已被注册！');window.location='../login.jsp'</script>");
							}
						}else {
							response.getWriter().println("<script>alert('邮箱号不能为空！');window.location='../login.jsp'</script>");
						}
					}else {
						response.getWriter().println("<script>alert('手机号已被注册！');window.location='../login.jsp'</script>");
					}
				}else {
					response.getWriter().println("<script>alert('手机号不能为空！');window.location='../login.jsp'</script>");
				}

			}else {
				response.getWriter().println("<script>alert('用户名已存在！');window.location='../login.jsp'</script>");
			}
		}else {
			response.getWriter().println("<script>alert('用户名不能为空！');window.location='../login.jsp'</script>");
		}


	}

	// 用户登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletResponse response,String username,String password,String isLogin,Model model) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user = us.login(username, password);
		if ("y".equals(isLogin)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", URLEncoder.encode(username,"UTF-8"));
			// 设置Cookie的有效期为3天
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			/**
			 * 若使用二级目录则需设置cookie.setPath("/")
			 * 表示可在同一应用服务器内共享方法
			 */
			nameCookie.setPath("/");
			Cookie pwdCookie = new Cookie("password", password);
			//设置Cookie的有效期为3天
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			pwdCookie.setPath("/");
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
		} else {
			Cookie pwdCookie = new Cookie("password", password);
			//清除cookie
			pwdCookie.setMaxAge(0);
			pwdCookie.setPath("/");
			response.addCookie(pwdCookie);
		}
		if (user != null) {
			//设置request作用域,在类上设置session作用域
			model.addAttribute("uid",user.getUid());
			model.addAttribute("user",user);
			//设置session作用域时长，默认的过期时间是30分钟
			response.getWriter().println("<script>alert('登录成功！！！');window.location='../index.jsp'</script>");
		} else {
			response.getWriter().println("<script>alert('账号或密码错误，请重新登录');window.location='../login.jsp'</script>");
		}
	}

	// 查看用户个人信息通过ID
	@RequestMapping(value = "/findUserByUid", method = RequestMethod.GET)
	public ModelAndView findUserByUid(ModelMap modelMap) {
		//通过id查找用户信息
		//modelMap.get获取session作用域
		User user = us.findUserByUid((int)modelMap.get("uid"));
		//ModelAndView(String viewName, String modelName, Object modelObject)，
		//viewName：跳转到指定的页面，类似于请求转发
		//modelName：可以在视图中取出Model并显示，通过使用el表达式
		//页面上可以通过el变量方式${key}来获取数据
		return new ModelAndView("information","user",user);
	}

	// 更新用户个人信息
	@RequestMapping(value = "updataUser", method = RequestMethod.POST)
	public ModelAndView updataUser(ModelMap modelMap,User user)
			throws ServletException, IOException {
		us.updataUser(new User((int)modelMap.get("uid"), user.getUsername(),
				user.getPassword(), user.getAddress(),user.getPhone(),
				user.getEmail()));
		//页面上可以通过el变量方式${key}来获取数据
		return new ModelAndView("information","user",user);
	}

	// 用户查看收藏夹
	@RequestMapping(value = "checkIFocustables", method = RequestMethod.GET)
	public ModelAndView checkIFocustables(ModelMap modelMap) {
		User user = us.checkFoucstable((int)modelMap.get("uid"));
		return new ModelAndView("wishlist","user",user);
	}

	// 用户查看购物车
	@RequestMapping(value = "checkShopCartByUid", method = RequestMethod.GET)
	public ModelAndView checkShopCartByUid(ModelMap modelMap)
			throws ServletException, IOException {
		//通过uid来查找用户的购物车，返回一个shop_cart集合
		List<Shop_cart> shop_carts = us.checkShopCart((int)modelMap.get("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//计算购物车每一项的总价
			double amount = shop_cart.getProducts().getRprice() * shop_cart.getShoppingnum();
			shop_cart.setAmount(amount);
			sc.updataShop_Cart(shop_cart);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		//把结果页面上需要的数据放到ModelMap对象中即可，
		//他的作用类似于request对象的setAttribute方法的作用，用来在一个请求过程中传递处理的数据。
		//Map对象中设定好key与value值，之后可以在视图中取出
		ModelMap model=new ModelMap();
		model.addAttribute("allAmount",allAmount);
		model.addAttribute("shop_carts", shop_carts);
		return new ModelAndView("shopping-cart",model);
	}
	//增加购物车里的商品(有BUG)
	@RequestMapping(value = "changeShop_CartNumAdd", method = RequestMethod.POST)
	public @ResponseBody ChangeNum changeShop_CartNumAdd(ModelMap modelMap, @RequestBody ChangeNum cn){
		//方法一、使用@RequestBody注解 SpringMVC会对json数据直接进行封装
		//要求键的值和实体类的属性名称对应
		//方法二、获取json传转换成java对象
//		ChangeNum cn = JSON.parseObject(json, ChangeNum.class);
		//增加商品数量
		cn.setShoppingnum(cn.getShoppingnum() + 1);
		int cid = cn.getCid();
		Shop_cart shop_cart1 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新商品数量
		us.updateProductnum(shop_cart1);
		//通过uid查找购物车
		List<Shop_cart> shop_carts = us.checkShopCart((int)modelMap.get("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//遍历List集合，计算一项购物项的总价=商品单价*数量
			double amount = shop_cart.getProducts().getRprice() * shop_cart.getShoppingnum();
			//计算购物车每一项的总价
			shop_cart.setAmount(amount);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		Shop_cart shop_cart2 = us.findShop_CartByCid(cid);
		//设置购物车每一项总价
		cn.setAmount(shop_cart2.getShoppingnum() * shop_cart2.getProducts().getRprice());
		//设置购物车总价
		cn.setAllAmount(allAmount);
		Shop_cart shop_cart3 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新购物车总价
		us.updateProductnum(shop_cart3);
		//将java对象转化成json串
//		response.getWriter().write(JSONObject.toJSONString(cn));
		//使用注解@ResponseBody直接将实体类转换为json串并返回给客户端
		return cn;

	}
	//减少购物车里的商品(有BUG)
	@RequestMapping(value = "changeShop_CartNumDel", method = RequestMethod.POST)
	public @ResponseBody ChangeNum changeShop_CartNumDel(ModelMap modelMap,@RequestBody ChangeNum cn){
		//方法一、使用@RequestBody注解 SpringMVC会对json数据直接进行封装
		//要求键的值和实体类的属性名称对应
		//获取json传转换成java对象
//		ChangeNum cn = JSON.parseObject(json, ChangeNum.class);
		//减少商品数量
		cn.setShoppingnum(cn.getShoppingnum() - 1);
		int cid = cn.getCid();
		Shop_cart shop_cart1 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新商品数量
		us.updateProductnum(shop_cart1);
		//通过uid查找购物车
		List<Shop_cart> shop_carts = us.checkShopCart((int)modelMap.get("uid"));
		double allAmount = 0;
		for (Shop_cart shop_cart : shop_carts) {
			//遍历List集合，计算一项购物项的总价=商品单价*数量
			double amount = shop_cart.getProducts().getRprice() * shop_cart.getShoppingnum();
			//计算购物车每一项的总价
			shop_cart.setAmount(amount);
			//计算购物车总价
			allAmount += shop_cart.getAmount();
		}
		Shop_cart shop_cart2 = us.findShop_CartByCid(cid);
		//设置购物车每一项总价
		cn.setAmount(shop_cart2.getShoppingnum() * shop_cart2.getProducts().getRprice());
		//设置购物车总价
		cn.setAllAmount(allAmount);
		Shop_cart shop_cart3 = new Shop_cart(cid, cn.getShoppingnum(), cn.getAmount());
		//更新购物车总价
		us.updateProductnum(shop_cart3);
		//将java对象转化成json串
//		response.getWriter().write(JSONObject.toJSONString(cn));
		//使用注解@ResponseBody直接将实体类转换为json串并返回给客户端
		return cn;
	}
	//用户从购物车下订单
	@RequestMapping(value = "place_order", method = RequestMethod.POST)
	public void place_order(ModelMap modelMap, HttpServletResponse response,String address,String phone,String name)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		/*为了防止购物车没有商品，通过获取用户购物车商品数量如果没有商品则不能下单*/
		double amount=us.Amount((int)modelMap.get("uid"));
		if(amount>0){
			if (!address.equals("") && !phone.equals("") && !name.equals("")) {
				Date date=new Date();//获取当前时间
				//转化时间格式
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String ordertime=sdf.format(date.getTime());
				//创建订单
				Orderbase orderbase = new Orderbase((int)modelMap.get("uid"),
						amount, ordertime, address,
						phone, name);
				//添加订单
				us.place_orderByUid(orderbase);
				//查找购物车全部商品
				List<Shop_cart> shop_carts = us.checkShopCart((int)modelMap.get("uid"));
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
				response.getWriter().println("<script>alert('下单成功！！！');window.location='../index.jsp'</script>");
			}else {
				response.getWriter().println("<script>alert('请填写完整的收货信息！');window.location='allAmount'</script>");

			}
		}else{
			response.getWriter().println("<script>alert('您的购物车里没有商品');window.location='../index.jsp'</script>");
		}

	}
	//退出登录
	@RequestMapping(value="userLogout", method = RequestMethod.GET)
	@SuppressWarnings("rawtypes")
	public void userLogout(HttpServletResponse response, SessionStatus sessionStatus)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//实现用户注销功能
		//清除session作用域
		sessionStatus.setComplete();
		response.getWriter().println("<script> alert('注销成功');window.location='../login.jsp'</script>");

	}
	//用户查看订单
	@RequestMapping(value="checkOrder", method = RequestMethod.GET)
	public ModelAndView checkOrder(ModelMap modelMap,
								   String pagenum,String nowpage){
		int pageNum = 1;//分页设置，从第几项开始
		int size=5;//分页设置，每次显示几项
		if (pagenum==null) {
			if (nowpage==null) {
				pageNum = 1;
			}else{
				String page = nowpage;
				pageNum = Integer.valueOf(page);
			}
		}else {
			String page = pagenum;
			pageNum = Integer.valueOf(page);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", Math.abs((pageNum-1)*size));//分页设置，从第几项开始，0表示第一项
		params.put("size", size);//分页设置，每次显示几项
		params.put("uid",(Integer) modelMap.get("uid"));
		Page<Orderbase> pager = new Page<Orderbase>(pageNum,size);
		//查看全部订单，传入page，size，uid
		List<Orderbase> orderbases=us.checkOrderByUid(params);
		//设置总数据
		pager.setTotalCount(us.count((Integer) modelMap.get("uid")));
		pager.setList(orderbases);
		//ModelAndView(String viewName, String modelName, Object modelObject)，
		//viewName：跳转到指定的页面
		//modelName：可以在视图中取出Model并显示，通过使用el表达式
		return new ModelAndView("order","orderlist",pager);
	}
	//用户查看详情订单
	@RequestMapping(value="checkOrderitem", method = RequestMethod.GET)
	public ModelAndView checkOrderitem(ModelMap modelMap,Model model,String pagenum,String nowpage,String orid){
		int pageNum = 1;//分页设置，从第几项开始
		int size=5;//分页设置，每次显示几项
		if (pagenum==null) {
			if (nowpage==null) {
				pageNum = 1;
			}else{
				String page = nowpage;
				pageNum = Integer.valueOf(page);
			}
		}else {
			String page = pagenum;
			pageNum = Integer.valueOf(page);
		}
		Map<String, Object> params = new HashMap<>();
		params.put("page", Math.abs((pageNum-1)*size));
		params.put("size", size);
//		params.put("orid",orid);
		int neworid=0;
		//为了防止获取不到orid值
		if (orid!=null) {
			//获取POST/GET传递的参数值
			neworid=Integer.parseInt(orid);
			params.put("orid", neworid);
		}else {
			//获取session作用域的值
			neworid=(int)modelMap.get("orid");
			params.put("orid",neworid);
		}
		Page<Orderitem> pager = new Page<Orderitem>(pageNum,size);
		//查看全部详情订单也就是每一项订单里有什么商品，传入page，size，uid
		List<Orderitem> orderitems=us.checkOrderItemByOrdi(params);
		pager.setList(orderitems);
		//设置总数据
		pager.setTotalCount(us.productCount(neworid));
		//把orid设置进session作用域，方便获取
		model.addAttribute("orid",neworid);
		//ModelAndView(String viewName, String modelName, Object modelObject)，
		//viewName：跳转到指定的页面
		//modelName：可以在视图中取出Model并显示，通过使用el表达式
		return new ModelAndView("orderitem","orderitems",pager);
	}
	//下订单跳转计算总价
	@RequestMapping(value="allAmount", method = RequestMethod.GET)
	public ModelAndView allAmount(ModelMap modelMap)throws ServletException,IOException{
		//计算购物车总价
		double allAmount = us.Amount((Integer)modelMap.get("uid"));
		return new ModelAndView("checkout","allAmount",allAmount);
	}
	//从收藏夹添加商品进购物车
	@RequestMapping(value="addProductinShop_Cart", method = RequestMethod.GET)
	public ModelAndView addProductinShop_Cart(ModelMap modelMap,int pid,int fid){
		/**
		 * 通过pid查询用户购物车，如果查询到用户收藏夹里没有此类商品
		 * 就添加此类商品进用户购物车后从收藏夹删除此类商品
		 * 若通过pid查询用户购物车，如查询到用户收藏夹里有此类商品
		 * 就更新购物车此类商品数量
		 */
		Shop_cart shop_cart=sc.findShop_cartByPid(pid,(Integer) modelMap.get("uid"),fid);
		if (shop_cart==null) {
			sc.addShop_cart((Integer) modelMap.get("uid"),pid,1);
			User user = us.checkFoucstable((Integer)modelMap.get("uid"));
			return new ModelAndView("wishlist","user",user);
		}else {
			Shop_cart shop_cart1=sc.addShop_cartByPid(pid,(Integer) modelMap.get("uid"));
			shop_cart1.setShoppingnum(shop_cart1.getShoppingnum()+1);
			sc.updataShop_Cart(shop_cart1);
			User user = us.checkFoucstable((Integer)modelMap.get("uid"));
			return new ModelAndView("wishlist","user",user);
		}

	}
	//删除收藏夹里的商品项（取消收藏）
	@RequestMapping(value="removeFocustable", method = RequestMethod.GET)
	public ModelAndView removeFocustable(ModelMap modelMap,int fid){
		us.deleteFocustable(fid);
		User user = us.checkFoucstable((Integer)modelMap.get("uid"));
		return new ModelAndView("wishlist","user",user);
	}
	//注册时检测用户名是否重复
	@RequestMapping(value="checkUsername", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody String checkUsername(String username){
		User user=us.findUserByUname(username);
		String msg=null;
		if(user!=null) {
			msg=username+"已存在";
		}else if(username.equals("")){
			msg="用户名不能为空";
		}else {
			msg=" ";
		}
		return msg;
	}

	//注册时检测手机号是否重复
	@RequestMapping(value="checkPhone", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody String checkPhone(String phone){
		User user=us.findByPhone(phone);
		String msg=null;
		if(user!=null) {
			msg=phone+"已被使用";
		}else if(phone.equals("")){
			msg="手机号不能为空";
		}else {
			msg=" ";
		}
		return msg;
	}
	//注册时检测邮箱号是否重复
	@RequestMapping(value="checkEmail", method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public @ResponseBody String checkEmail(String email){
		User user=us.findByEmail(email);
		String msg=null;
		if(user!=null) {
			msg=email+"已被使用";
		}else if(email.equals("")){
			msg="邮箱号不能为空";
		}else {
			msg=" ";
		}
		return msg;
	}

	//添加商品进购物车
	@RequestMapping(value="addShopCart", method = RequestMethod.GET)
	public String addShopCart(ModelMap modelMap,int pid,HttpServletResponse response)throws ServletException,IOException{
		Shop_cart shop_cart=sc.addShop_cartByPid(pid,(Integer)modelMap.get("uid"));
		if (shop_cart==null) {
			sc.addShopcart((Integer)modelMap.get("uid"),pid, 1);
			response.getWriter().println("<script>alert('添加成功');window.location='../pageProduct'</script>");
			return null;

		}else {
			Shop_cart shop_cart1=sc.addShop_cartByPid(pid,(Integer)modelMap.get("uid"));
			shop_cart1.setShoppingnum(shop_cart1.getShoppingnum()+1);
			sc.updataShop_Cart(shop_cart1);
			response.getWriter().println("<script>alert('添加成功');window.location='../pageProduct'</script>");
			return null;

		}

	}
	//添加商品进收藏夹
	@RequestMapping("addWishList")
	public void addWishList(ModelMap modelMap,int pid,HttpServletResponse response) throws IOException {
		us.addWishList((Integer) modelMap.get("uid"),pid);
        response.getWriter().println("<script>alert('添加收藏成功');window.location='../pageProduct'</script>");
	}
	
	//删除购物车
	@RequestMapping(value="deleteShopcartById")
	public String deleteShopcartById(Integer cid){
		sc.deleteShopcartById(cid);
		return "forward:checkShopCartByUid";
	}
	//清空购物车
	@RequestMapping(value="deleteShopcart")
	public String deleteShopcart(Integer uid){
		sc.deleteShopcart(uid);
		return "forward:checkShopCartByUid";
	}
	//清空用户收藏夹
	@RequestMapping(value = "removeAllFocustableByUid")
	public String removeAllFocustableByUid(ModelMap modelMap){
		us.removeAllFocustableByUid((Integer)modelMap.get("uid"));
		return "forward:checkIFocustables";
	}
	
}
