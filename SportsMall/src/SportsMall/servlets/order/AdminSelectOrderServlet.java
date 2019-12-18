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
import SportsMall.service.OrderService;
import SportsMall.service.OrderServiceImpl;

/**
 * Servlet implementation class AdminSelectOrderServlet
 */
@WebServlet("/AdminSelectOrderServlet")
public class AdminSelectOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSelectOrderServlet() {
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
		// 实例化，创建对象
		OrderServiceImpl orderService = new OrderServiceImpl();//创建对象orderService
		List<Order> alist=orderService.findAllOrders();//使用orderService里面查询所有订单的方法创建Order的List集合（因为查询的订单有很多，所以使用集合）
		// 使用requset转发
		request.setAttribute("alist", alist);//设置请求参数（key-value的形式）			
		request.getRequestDispatcher("allorderlist.jsp").forward(request, response);//跳转到全部订单的页面	
						
						
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
