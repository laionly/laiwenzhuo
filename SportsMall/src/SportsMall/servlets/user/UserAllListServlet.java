package SportsMall.servlets.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.dao.user.impl.UserDaoImpl;
import SportsMall.dao.user.impl.UserDaoImplhibernate;
import SportsMall.entity.Myadmin;
import SportsMall.entity.User;

/**
 * Servlet implementation class UserAllListServlet
 */
@WebServlet("/UserAllListServlet")
public class UserAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAllListServlet() {
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
		UserDaoImplhibernate userDaoImplhibernate = new UserDaoImplhibernate ();
		List<User> user = userDaoImplhibernate.findAll();
		request.setAttribute("user", user);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
