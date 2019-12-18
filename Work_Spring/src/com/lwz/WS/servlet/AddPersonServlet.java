package com.lwz.WS.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.lwz.WS.entity.Person;
import com.lwz.WS.service.PersonService;

/**
 * Servlet implementation class AddPersonServlet
 */
@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
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
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		Person person =new Person(username, password, email, address);
		PersonService ps =(PersonService)ac.getBean("pservice");
		ps.addPerson(person);
		if(person!=null){
			response.getWriter().println("<script> alert('注册成功！！！');window.location='login.jsp'</script>");
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
