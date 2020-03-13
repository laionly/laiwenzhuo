package com.ds.digitalshop.servlet.user;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.ProductItem;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;

/**
 * Servlet implementation class Order_detail
 */
public class Order_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc=getServletContext();
		sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		User user=(User)request.getSession().getAttribute("user");
		UserService us=(UserService)ac.getBean("uservice");
		User user1=us.findUserByid(user.getUserid());
		Set<Order> orders = user1.getOrders();
		for(Order order : orders){
			if (order.getOrderid()==Integer.valueOf(request.getParameter("orderid"))) {
				request.setAttribute("order", order);
			}
		}
		request.getRequestDispatcher("myorder_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
