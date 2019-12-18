package com.skishop.servlets.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.product.impl.ProductDaoImpl;
import com.skishop.entity.Product;

/**
 * Servlet implementation class ProductEdit2Servlet
 */
@WebServlet("/editProduct2")
public class ProductEdit2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEdit2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String listimg=request.getParameter("listimg");
		String prices=request.getParameter("prince");
		int price=Integer.parseInt(prices);
		String discountprince=request.getParameter("discountprince");
		int discountprice=Integer.parseInt(discountprince);
		ProductDaoImpl pd=new ProductDaoImpl();
		Product p=new Product(id, name, description, listimg, price, discountprice);
		boolean result=pd.updateProduct(p);
		if(result){
//			request.setAttribute("product", pd.selectProduct(id));
			request.getRequestDispatcher("editproduct.jsp").forward(request, response);
		}
	}

}
