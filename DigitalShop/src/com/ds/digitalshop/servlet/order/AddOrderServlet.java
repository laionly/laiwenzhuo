package com.ds.digitalshop.servlet.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Cart;
import com.ds.digitalshop.entity.CartItem;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.ProductItem;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.OrderService;
import com.ds.digitalshop.service.ProductService;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		ServletContext sc=getServletContext();
		String config =sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		OrderService os=(OrderService)ac.getBean("OrderServiceImpl");
		
		Order order = new Order();
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		Map<Integer, CartItem> map =cart.getMap();
		Set<ProductItem> productItems = new HashSet<ProductItem>();
		for (CartItem cartItem : map.values()) {
			
			ProductItem productItem = new ProductItem();
			productItem.setName(cartItem.getProduct().getName());
			productItem.setDescription(cartItem.getProduct().getDescription());
			productItem.setListimg(cartItem.getProduct().getListimg());
			productItem.setDiscountprice(cartItem.getProduct().getDiscountprice());
			productItem.setPrice(cartItem.getProduct().getPrice());
			
			productItem.setCount(cartItem.getCount());
			productItem.setProductItemprice(cartItem.getPrice());
			productItems.add(productItem);
			productItem.setOrder(order);
		}
		
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		String ordertime=sdf.format(date.getTime());
		System.out.println(ordertime);
			
		User user=((User)request.getSession().getAttribute("user"));
		
		int number=cart.getCount();	
		int orderprice=cart.getPrice();
		order.setProductItems(productItems);
		order.setAddress(request.getParameter("address"));
		order.setName(request.getParameter("name"));
		order.setEmail(request.getParameter("email"));
		order.setPhone(request.getParameter("phone"));
		order.setNumber(number);
		order.setOrderprice(String.valueOf(orderprice));
		order.setOrdertime(ordertime);
		order.setUser(user);
		os.addOrder(order);
		
		
		
		response.getWriter().println("<script>alert('下单成功');window.location='ClearCartServlet'</script>");			
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
