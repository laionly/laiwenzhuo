package com.ds.digitalshop.servlet.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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
		ServletContext sc = getServletContext();
		sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		int userid = Integer.parseInt(request.getParameter("userid"));
		String head_portrait = request.getParameter("head_portrait");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		if (username != "") {
			if (password != "") {
				if (email != "") {
					if (address != "") {
						if (phone != "") {
							UserService us = (UserService) ac.getBean("uservice");
							User user = new User(userid, username, password, email, address, phone, head_portrait);
							us.updateUser(user);
							request.getSession().setAttribute("user", user);
							response.getWriter().println(
									"<script> alert('修改个人信息成功！！');window.location='userinformation.jsp'</script>");

						} else {
							request.setAttribute("addFail", "电话	不能为空！");
							request.getRequestDispatcher("userinformation.jsp").forward(request, response);
						}

					} else {
						request.setAttribute("addFail", "地址不能为空！");
						request.getRequestDispatcher("userinformation.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("addFail", "邮箱不能为空！");
					request.getRequestDispatcher("userinformation.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("addFail", "密码不能为空！");
				request.getRequestDispatcher("userinformation.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("addFail", "用户名不能为空！");
			request.getRequestDispatcher("userinformation.jsp").forward(request, response);
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
