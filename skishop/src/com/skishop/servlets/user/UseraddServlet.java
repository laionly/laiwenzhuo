package com.skishop.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.user.impl.UserDaoImpl;
import com.skishop.entity.User;

/**
 * Servlet implementation class UseraddServlet
 */
@WebServlet("/UseraddServlet")
public class UseraddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseraddServlet() {
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
		String surname=request.getParameter("surname");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		User user=new User(surname,name,email,password);
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		userDaoImpl.addUser(user);
		response.getWriter().println("<script> alert('添加成功');window.location='login.html'</script>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String surname=request.getParameter("surname");
//		String name=request.getParameter("name");
//		String email=request.getParameter("email");
//		String password=request.getParameter("password");
//		User user=new User(surname,name,email,password);
//		UserDaoImpl userDaoImpl=new UserDaoImpl();
//		userDaoImpl.addUser(user);
//		response.getWriter().println("<script> alert('添加成功');window.location='login.html'</script>");
	}

}
