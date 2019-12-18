package SportsMall.servlets.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.entity.Order;
import SportsMall.entity.User;
import SportsMall.service.OrderServiceImpl;

/**
 * Servlet implementation class UserSelectOrderServlet
 */
@WebServlet("/UserSelectOrderServlet")
public class UserSelectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelectOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//设置编码格式，防止中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user=(User) request.getSession().getAttribute("user");
		OrderServiceImpl os=new OrderServiceImpl();
		List<Order> order=os.findAllRecords(user);
		request.setAttribute("myorder",order);
		request.getRequestDispatcher("myorderlist.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
