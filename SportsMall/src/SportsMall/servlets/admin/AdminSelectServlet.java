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
 * Servlet implementation class AdminSelectServlet
 */
@WebServlet("/AdminSelectServlet")
public class AdminSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSelectServlet() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		AdminDaoImplhibernate adminDaoImplhibernate = new AdminDaoImplhibernate();
		Myadmin myadmin = adminDaoImplhibernate.select(id);
		request.setAttribute("Myadmin", myadmin);
		
		request.getRequestDispatcher("editadmin.jsp").forward(request, response);
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
