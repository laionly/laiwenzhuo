package SportsMall.servlets.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.entity.Order;
import SportsMall.service.OrderServiceImpl;

/**
 * Servlet implementation class UserFindOrderByIdServlet
 */
@WebServlet("/UserFindOrderByIdServlet")
public class UserFindOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFindOrderByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// ����ҵ��㹦��:���ݶ�����Ų�ѯ������Ϣ
		OrderServiceImpl OrderService = new OrderServiceImpl();
		Order order = OrderService.findOrderByid(id);
		// ����������request
		request.getSession().setAttribute("order", order);
		
		request.getRequestDispatcher("orderinfo.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
