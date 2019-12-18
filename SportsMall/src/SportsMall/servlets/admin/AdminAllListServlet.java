package SportsMall.servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.entity.Myadmin;

/**
 * Servlet implementation class AdminAllListServlet
 */
@WebServlet("/AdminAllListServlet")
public class AdminAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAllListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		AdminDaoImplhibernate adminDaoImplhibernate = new AdminDaoImplhibernate();
		List<Myadmin> myadmin = adminDaoImplhibernate.findAll();
		request.setAttribute("myadmin", myadmin);
		request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
	}
}
