package SportsMall.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

//import SportsMall.dao.admin.impl.AdminDaoImplhibernate;
import SportsMall.dao.admin.impl.AdminDaoImpl;
import SportsMall.entity.Myadmin;

/**
 * Servlet implementation class AdminDeleteServlet
 */
@WebServlet("/admindelete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.addHeader("content-type","application:json;charset=utf8");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//int id=Integer.parseInt(request.getParameter("id"));
		
		
		
		String ids=request.getParameter("id");
	
		int id=Integer.parseInt(ids);
		
		AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
		adminDaoImpl.deleteAdmin(id);
		
		System.out.println("删除");
		
		int code=303;

			response.getWriter().write(JSONObject.toJSONString(code));
		
		
		
	//	AdminDaoImplhibernate adminDaoImplhibernate=new AdminDaoImplhibernate();
	//	adminDaoImplhibernate.delete(id);
		
		//response.getWriter().println("<script> alert('删除成功');window.location=''</script>");
	}

}
