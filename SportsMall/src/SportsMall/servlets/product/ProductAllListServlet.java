package SportsMall.servlets.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.product.impl.ProductDaoImplhibernate;
import SportsMall.entity.Product_zuqiu;

/**
 * Servlet implementation class ProductAllListServlet
 */
@WebServlet("/ProductAllListServlet")
public class ProductAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAllListServlet() {
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
		ProductDaoImplhibernate productDaoImplhibernate=new ProductDaoImplhibernate();
		List<Product_zuqiu> product_zuqiu=productDaoImplhibernate.finAll();
		request.setAttribute("product_zuqiu", product_zuqiu);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
