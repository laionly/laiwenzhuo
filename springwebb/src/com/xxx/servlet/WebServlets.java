package com.xxx.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xxx.entity.Person;

/**
 * Servlet implementation class WebServlet
 */
@WebServlet("/WebServlets")
public class WebServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WebServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//WebApplicationContextUtils类源码112行
		//ContextLoader类源码294行
		//获取全局初始化参数方法getInitParameter
		ServletContext sc=getServletContext();
		WebApplicationContext wb=(WebApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		String config =sc.getInitParameter("contextConfigLocation");
//		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
//		Person person=(Person) ac.getBean("person");
//		System.out.println(person.toString());
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		Person person = (Person)ac.getBean("person");
		System.out.println(person);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
