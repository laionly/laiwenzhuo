package com.ds.digitalshop.servlet.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;

/**
 * Servlet implementation class UserLoginServelt
 */
@WebServlet("/UserLoginServelt")
public class UserLoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String flag = request.getParameter("isLogin");

		if ("y".equals(flag)) {
			// 创建两个Cookie对象
			Cookie nameCookie = new Cookie("username", name);
			// 设置Cookie的有效期为3天
			nameCookie.setMaxAge(60 * 60 * 24 * 3);
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(60 * 60 * 24 * 3);
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
		}else{
			Cookie pwdCookie = new Cookie("password", pwd);
			pwdCookie.setMaxAge(0);
			response.addCookie(pwdCookie);
		}

		ServletContext sc = getServletContext();
		sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService us = (UserService) ac.getBean("uservice");
		User user = us.UserLogin(username, password);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("username", user.getUsername());
			request.getSession().setMaxInactiveInterval(3600);
			response.getWriter().println("<script> alert('登录成功！！');window.location='index.jsp'</script>");
		} else {
			response.getWriter()
					.println("<script> alert('您输入的用户名或者密码错误，请重新登录');window.location='account.jsp'</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
