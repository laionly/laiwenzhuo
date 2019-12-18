package SportsMall.servlets.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.dao.product.impl.ProductDaoImplhibernate;
import SportsMall.entity.Myadmin;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String listimg=request.getParameter("listimg");
		int price=Integer.parseInt(request.getParameter("price"));
		int discountprice=Integer.parseInt(request.getParameter("discountprice"));
		
		ProductDaoImplhibernate productDaoImplhibernate=new ProductDaoImplhibernate();
		Product_zuqiu product = new Product_zuqiu(id, name, listimg, price, discountprice);
		productDaoImplhibernate.updata(product);
		request.getRequestDispatcher("ProductAllListServlet").forward(request, response);
		    
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);		
}
}