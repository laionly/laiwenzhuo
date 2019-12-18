package com.lwz.WS.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lwz.WS.dao.impl.PersonDaoimpl;
import com.lwz.WS.service.PersonService;

/**
 * Servlet implementation class UserLoginServlet
 */
//@WebServlet("/UserLoginServlet")
public class PersonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonLoginServlet() {
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
	
		ApplicationContext ac = (ApplicationContext) request.getServletContext().getAttribute("ApplicationContext");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PersonService ps =(PersonService)ac.getBean("pservice");
		boolean loginok=ps.login(username, password);
		if(loginok){
			request.getSession().setAttribute("username", username);
			request.getSession().setMaxInactiveInterval(3600);
			response.getWriter().println("<script> alert('登入成功！！');window.location='index.html'</script>");
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
