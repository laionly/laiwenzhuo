package SportsMall.servlets.product.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

import SportsMall.dao.product.impl.ProductDaoImpl;
import SportsMall.entity.Cart;
import SportsMall.entity.CartItem;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;
 

/**
 * Servlet implementation class deleteItem
 */
@WebServlet("/deleteItem")
public class deleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		ProductDaoImpl pd=new ProductDaoImpl();
		Product_zuqiu product=pd.selectProduct_zq(id);
		HttpSession session=request.getSession();
		Cart c=(Cart)session.getAttribute("cart");
		if(c==null){
			c=new Cart();
		}
		c.deleteItem(product);
		session.setAttribute("cart", c);
		request.getRequestDispatcher("ShowCartServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
