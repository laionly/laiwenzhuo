package SportsMall.servlets.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import SportsMall.dao.user.impl.UserDaoImpl;
import SportsMall.entity.User;

/**
 * Servlet implementation class UserAllListServlet
 */
@WebServlet("/userallList")
public class AllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers","x-requested-with,content-type");
		response.addHeader("content-type","application:json;charset=utf8");
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		List<User> list =userDaoImpl.listUser();
		System.out.println(list+"查询值");
		request.setAttribute("user", list);
		
		
		if(list!= null){

			//	response.getWriter().write(JSONObject.toJSONString(adminmessage.getCode()));
				response.getWriter().write(JSONObject.toJSONString(list));
				
			}else{
				int code=404;
				response.getWriter().write(JSONObject.toJSONString(code));
			}
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}	
		

}
