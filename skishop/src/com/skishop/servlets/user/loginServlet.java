package com.skishop.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登录判断用户角色
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String roles=request.getParameter("role");
//		int role=Integer.parseInt(roles);
//		if(role==1){
//			request.getRequestDispatcher("UserLoginServlet").forward(request, response);
//		}else{
//			request.getRequestDispatcher("AdminLoginServlet").forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 登录判断用户角色
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String roles=request.getParameter("role");
				int role=Integer.parseInt(roles);
				if(role==1){
					System.out.println("用戶登录");
					request.getRequestDispatcher("UserLoginServlet").forward(request, response);
				}else{
					System.out.println("管理员登录");
					request.getRequestDispatcher("AdminLoginServlet").forward(request, response);
				}
			}
	}


