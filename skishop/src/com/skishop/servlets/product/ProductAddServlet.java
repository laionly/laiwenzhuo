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
 * Servlet implementation class ProductAddServlet
 */
@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
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
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String listimg=request.getParameter("listimg");
		String princes=request.getParameter("prince");
		int prince=Integer.parseInt(princes);
		String discountprinces=request.getParameter("discountprince");
		int discountprince=Integer.parseInt(discountprinces);
		Product product=new Product(id, name, description, listimg, prince, discountprince);
		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
		productDaoImpl.saveProduct(product);
		response.getWriter().println("<script> alert('添加成功');window.location='productlist'</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String ids=request.getParameter("id");
//		int id=Integer.parseInt(ids);
//		String name=request.getParameter("name");
//		String description=request.getParameter("description");
//		String listimg=request.getParameter("listimg");
//		String princes=request.getParameter("prince");
//		int prince=Integer.getInteger(princes);
//		String discountprinces=request.getParameter("discountprince");
//		int discountprince=Integer.getInteger(discountprinces);
//		Product product=new Product(id, name, description, listimg, prince, discountprince);
//		ProductDaoImpl productDaoImpl=new ProductDaoImpl();
//		productDaoImpl.saveProduct(product);
//		response.getWriter().println("<script> alert('添加成功');window.location='productlist'</script>");
	}

}
