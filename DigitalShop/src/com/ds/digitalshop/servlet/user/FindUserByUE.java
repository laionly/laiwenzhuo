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
 * Servlet implementation class FindUserByUE
 */
@WebServlet("/FindUserByUE")
public class FindUserByUE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserByUE() {
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
		ServletContext sc=getServletContext();
		sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		UserService us=(UserService)ac.getBean("uservice");
		User user=us.findUserByUE(username, email);
		if(user!=null){
			request.getSession().setAttribute("email", user.getEmail());
			System.out.println(request.getSession().getAttribute("email"));
			request.getRequestDispatcher("").forward(request, response);
			
		}else {
			response.getWriter().println("<script> alert('账号邮箱不匹配，请重新输入');window.location='account.jsp'</script>");
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
