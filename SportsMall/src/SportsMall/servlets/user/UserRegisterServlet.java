package SportsMall.servlets.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.user.impl.UserDaoImplhibernate;
import SportsMall.entity.User;



/**
 * Servlet implementation class Register
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterServlet() {
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
		doPost(request, response);
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
//		int id=Integer.parseInt(request.getParameter("id"));
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int code = 200;
		User user=new User(username, password, phone, email, address,code);
		
		System.out.println(user);
		
		UserDaoImplhibernate userDaoImplhibernate=new UserDaoImplhibernate();
		userDaoImplhibernate.save(user);
		
		request.getRequestDispatcher("login.html").forward(request, response);
	}
};
