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
 * Servlet implementation class AdminUpdateServlet
 */
@WebServlet("/adminupdate")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String ids=request.getParameter("id");
		
		int id=Integer.parseInt(ids);
		
		System.out.println(id+"ID的值");
		
		String loginname=request.getParameter("loginname");
		String password=request.getParameter("password");
		String phone =request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		AdminDaoImpl userDaoImpl=new AdminDaoImpl();
		
		int code=301;
		
	//	Myadmin admin=new Myadmin(id,loginname, password, phone, email, address,code);
		
		Myadmin admin=new Myadmin(id,loginname,password,phone,email,address,code);

		boolean result=userDaoImpl.updateAdmin(admin);
		
		if(result){
			response.getWriter().write(JSONObject.toJSONString(admin));
			
		}
	}

}
