package SportsMall.servlets.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.product.impl.ProductDaoImpl;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;

/**
 * Servlet implementation class ProductParticularServlet
 */
@WebServlet("/ProductParticularServlet")
public class ProductParticularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductParticularServlet() {
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
		ProductDaoImpl pd=new ProductDaoImpl();
		Product_zuqiu p=pd.selectProduct_zq(id);
		request.setAttribute("product_zq_xq", p);
		request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
