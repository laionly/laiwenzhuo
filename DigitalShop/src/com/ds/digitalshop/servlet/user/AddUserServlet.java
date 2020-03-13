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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
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
		String config = sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		System.out.println(username);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("email", email);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
		if (username != "") {
			if (password != "") {
				if (email != "") {
					if (address != "") {
						if (phone != "") {
							User user = new User(username, password, email, address, phone);
							UserService us = (UserService) ac.getBean("uservice");
							us.addUser(user);
							if (user != null) {
								response.getWriter()
										.println("<script>alert('注册成功！！！');window.location='login.jsp'</script>");
							}

						} else {
							request.setAttribute("addFail", "电话	不能为空！");
							request.getRequestDispatcher("register.jsp").forward(request, response);
						}

					} else {
						request.setAttribute("addFail", "地址不能为空！");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}

				} else {
					request.setAttribute("addFail", "邮箱不能为空！");
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("addFail", "密码不能为空！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("addFail", "用户名不能为空！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

		// if (username != "" && password != "" && email != "" && address != ""
		// && phone != "") {
		// User user = new User(username, password, email, address, phone);
		// UserService us = (UserService) ac.getBean("uservice");
		// us.addUser(user);
		// if (user != null) {
		// response.getWriter().println("<script>
		// alert('注册成功！！！');window.location='login.jsp'</script>");
		// }
		// } else {
		// request.setAttribute("addFail", "用户名、密码、邮箱、地址、电话不能为空！");
		// request.getRequestDispatcher("register.jsp").forward(request,
		// response);
		// response.getWriter().println("<script>
		// alert('用户名、密码、邮箱、地址、电话不能为空！');window.location='register.jsp'</script>");
		// }

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
