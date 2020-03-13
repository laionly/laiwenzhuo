package com.ds.digitalshop.servlet.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Cart;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.service.OrderService;

/**
 * Servlet implementation class ShowOrderServlet
 */
@WebServlet("/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderServlet() {
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
		
		
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		request.getSession().setAttribute("cart", cart);
		
		/*Product product=new Product();
		int productid=0;
		if (request.getParameter("productid")!=null) {
			productid=Integer.parseInt(request.getParameter("productid"));
		}else{
			productid=(int) request.getAttribute("productid");
		}
		System.out.print(productid);
		product.setProductid(productid);*/
		/*List<Order> order=os.selectOrder(productid);
		System.out.println(order);
		request.setAttribute("product",productid);		
		request.setAttribute("list", order);*/
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
