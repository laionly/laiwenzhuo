package SportsMall.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.model.source.internal.hbm.EmbeddableSourceImpl;

import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.entity.Myadmin;

/**
 * Servlet implementation class AdmineUpdateServlet
 */
@WebServlet("/AdmineUpdateServlet")
public class AdmineUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdmineUpdateServlet() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		System.out.println(address);
		String codes=request.getParameter("code");
		System.out.println(codes);
		int code=Integer.parseInt(codes);
		Myadmin admin = new Myadmin(id, loginname, password, phone, email, address, code);
		AdminDaoImplhibernate adminDaoImplhibernate = new AdminDaoImplhibernate();
		System.out.println(admin);
		adminDaoImplhibernate.updata(admin);
	    response.getWriter().println("<script> alert('修改成功');window.location='AdminAllListServlet'</script>");
	    
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
