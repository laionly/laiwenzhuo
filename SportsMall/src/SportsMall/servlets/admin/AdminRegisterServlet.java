package SportsMall.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.entity.Myadmin;

/**
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String loginname = request.getParameter("loginname");

		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int code=Integer.parseInt(request.getParameter("code"));
		Myadmin admin = new Myadmin(id, loginname, password, phone, email, address, code);
		AdminDaoImplhibernate adminDaoImplhibernate = new AdminDaoImplhibernate();
		adminDaoImplhibernate.save(admin);
		request.getRequestDispatcher("").forward(request, response);

	}

}
