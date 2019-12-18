package SportsMall.servlets.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import SportsMall.dao.product.impl.ProductDaoImpl;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() 
     */
    public ProductListServlet() {
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
		ProductDaoImpl pd=new ProductDaoImpl();
		List<Product_zuqiu> list_zq=pd.findAll_zuqiu();
		List<Product> list_lq=pd.finAll_lanqiu();
		List<Product> list_ymq=pd.finAll_yumaoqiu();
		List<Product> list_ppq=pd.finAll_pingpangqiu();
		request.setAttribute("product_zq", list_zq);
		request.setAttribute("product_lq", list_lq);
		request.setAttribute("product_ymq", list_ymq);
		request.setAttribute("product_ppq", list_ppq);
		request.getRequestDispatcher("shoplist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
