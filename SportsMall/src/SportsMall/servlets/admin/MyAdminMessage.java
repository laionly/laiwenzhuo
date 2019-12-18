package SportsMall.servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;


import SportsMall.dao.admin.impl.AdminDaoImpl;
import SportsMall.entity.Myadmin;

/**
 * Servlet implementation class admin
 */
@WebServlet("/loginadmin")
public class MyAdminMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAdminMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
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
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("用户名+"+username);
		System.out.println("密码+"+password);
		
		
		AdminDaoImpl ah=new AdminDaoImpl();
		
		Myadmin admin = ah.adminmessage(username, password);
		
		System.out.println("admin+"+admin);
		
		request.getSession().setAttribute("admin",admin);

		
		if(admin!= null){

		//	response.getWriter().write(JSONObject.toJSONString(adminmessage.getCode()));
			response.getWriter().write(JSONObject.toJSONString(admin));
			
		}else{
			int code=404;
			response.getWriter().write(JSONObject.toJSONString(code));
		}
		
		
		
	}

}
