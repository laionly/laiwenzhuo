package com.ds.digitalshop.servlet.cart;

import java.io.IOException;

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
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.service.ProductService;

/**
 * Servlet implementation class RemoveCartServlet
 */
@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCartServlet() {
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
		
		Integer productid=Integer.parseInt(request.getParameter("productid"));
		
		ServletContext sc=request.getServletContext();
		String config=sc.getInitParameter("contextConfigLocation");
		
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		ProductService ps=(ProductService)ac.getBean("pserviceImpl");
		
		Product product=ps.selectproduct(productid);
		HttpSession session=request.getSession();
		
		Cart cart=(Cart)session.getAttribute("cart");
		if(cart==null){
			cart=new Cart();
		}
		cart.deleteItem(product);
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
