package com.skishop.servlets.product.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skishop.dao.product.impl.ProductDaoImpl;
import com.skishop.entity.Cart;
import com.skishop.entity.Product;

/**
 * Servlet implementation class clearCart
 */
@WebServlet("/clearCart")
public class clearCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clearCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDaoImpl pd=new ProductDaoImpl();
		Product product=new Product();
		HttpSession session=request.getSession();
		Cart c=(Cart)session.getAttribute("cart");
		if(c==null){
			c=new Cart();
		}
		c.clearCart(product);
		session.setAttribute("cart", c);
		request.getRequestDispatcher("productlist").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
