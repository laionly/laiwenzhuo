package com.ds.digitalshop.servlet.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;
import com.ds.digitalshop.entity.Collect;

/**
 * Servlet implementation class RemoveCollectServlet
 */
public class RemoveCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveCollectServlet() {
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
		UserService us = (UserService) ac.getBean("uservice");
		int cid = Integer.parseInt(request.getParameter("cid"));
		us.removeUserCollectbycid(cid);
		request.getRequestDispatcher("MyFoavoritesServlet").forward(request, response);

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
