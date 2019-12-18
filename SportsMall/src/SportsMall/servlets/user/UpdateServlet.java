package SportsMall.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import SportsMall.dao.user.impl.UserDaoImpl;
import SportsMall.entity.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/updatemessage")
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String phone =request.getParameter("phone");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		int code=301;
		User user=new User(id,username, password, phone, email, address,code);
		
		System.out.println(user);
		
		boolean result=userDaoImpl.updateUser(user);
		
		if(result){
			response.getWriter().write(JSONObject.toJSONString(user));
			
		}
	}

}
