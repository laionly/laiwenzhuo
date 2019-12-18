package com.skishop.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.user.impl.UserDaoImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登录功能的实现
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取客户端传递过来的账号和密码
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		//检测帐号和密码是否合法 借助Dao来进行实现
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		boolean loginok=userDaoImpl.UsersLogin(email, password);
		if(loginok){
			//登录成功 session的写
			request.getSession().setAttribute("email", email);
			request.getSession().setMaxInactiveInterval(3600);
//			response.getWriter().println("<script> alert('登入成功！！');window.location='index.html'</script>");
			request.getRequestDispatcher("index.html").forward(request, response);
			//跳转到登录后的主界面就行
		}else{
			//登录失败
			//账号名和密码输入错误 提示下 继续登录
			response.getWriter().println("<script> alert('您输入的用户名或者密码错误，请重新登录');window.location='login.html'</script>");
		}
	}

}
