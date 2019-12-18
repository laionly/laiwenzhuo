package SportsMall.servlets.order;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.UUIDUtils;
import SportsMall.dao.order.impl.OrderDaoImpl;
import SportsMall.entity.Cart;
import SportsMall.entity.CartItem;
import SportsMall.entity.Order;
import SportsMall.entity.OrderItem;
import SportsMall.entity.User;
import SportsMall.service.OrderService;
import SportsMall.service.OrderServiceImpl;

/**
 * Servlet implementation class UserAddOrderServlet
 */
@WebServlet("/UserAddOrderServlet")
public class UserAddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddOrderServlet() {
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
				
				//����OrderDao��ʵ�������
				
				//ʵ����User����
				User user=(User)request.getSession().getAttribute("user");
				
				System.out.println(user+"用户名");
				//ʵ����Order����
				
				
				//��ȡ���ﳵ����
				Cart cart=(Cart) request.getSession().getAttribute("cart");
				//��������
				System.out.println(UUIDUtils.getId());
				
				Order order=new Order();
				order.setId(UUIDUtils.getId());
				order.setOrdertime(new Date());
				order.setPrice(cart.getPrice());
				order.setUser(user);
				
				
				//构造订单项
				for (CartItem item:cart.getCartItems()) {
					
					OrderItem orderItem = new OrderItem();
					orderItem.setId(UUIDUtils.getId());
					orderItem.setProduct(item.getProduct());
					orderItem.setCount(item.getCount());
					orderItem.setOrder(order);
					orderItem.setPrice(item.getPrice());
					// 将购物车中的每个明细添加到订单中
					order.getOrderItems().add(orderItem);
					
				}
				//
				/*OrderDaoImpl odi=new OrderDaoImpl();
				odi.addOrder(order);*/
				
				// ����service����Ӷ���
				OrderService orderService = new OrderServiceImpl();
				orderService.addOrder(order);
				//
				// //ת��
			
				request.setAttribute("order", order);//�������������

				request.getRequestDispatcher("orderlist.jsp").forward(request, response); //�ڹ��ﳵ����ύ����֮����ת��ҳ��
			}

			
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
