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
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//		response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
//		response.addHeader("content-type","application:json;charset=utf8");
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		System.out.println("名字+"+username);
//		System.out.println("密码+"+password);
//		
//		UserServiceImpl us=new UserServiceImpl();
//		
//		User user = us.login(username, password);
//		
//		//System.out.println(user);
//		
//		response.getWriter().write(JSONObject.toJSONString(user));
		
		
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
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//System.out.println(username);
		
		UserDaoImpl us=new UserDaoImpl();
		
		User user = us.login(username, password);
		
		System.out.println(user);
		
		request.getSession().setAttribute("user",user);
		
		
		
		if(user!= null){
			
			response.getWriter().write(JSONObject.toJSONString(user));
			//response.getWriter().write(JSONObject.toJSONString(user.getCode()));
			
		}else{
			int code=404;
			response.getWriter().write(JSONObject.toJSONString(code));
		}
		
		//System.out.println(user);
		
	//	response.getWriter().write(JSONObject.toJSONString(user));
		
//		response.addHeader("Access-Control-Allow-Origin", "*");
//		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//		response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
//		response.addHeader("content-type","application:json;charset=utf8");
//
//		
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		UserServiceImpl us=new UserServiceImpl();
//		
//		User user = us.login(username, password);
//		
//		System.out.println(user);
//		
//		response.getWriter().write(JSONObject.toJSONString(user));
		
		
	}

}
