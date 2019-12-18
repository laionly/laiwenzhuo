package SportsMall.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import SportsMall.dao.user.impl.UserDaoImpl;
import SportsMall.dao.user.impl.UserDaoImplhibernate;
import SportsMall.entity.User;

/**
 * Servlet implementation class UserUpdate2Servlet
 */
@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelectServlet() {
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
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		UserDaoImplhibernate userDaoImplhibernate=new UserDaoImplhibernate();
		User user=userDaoImplhibernate.select(id);
		request.setAttribute("user", user);
		System.out.println(user);
		request.getRequestDispatcher("edituser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
