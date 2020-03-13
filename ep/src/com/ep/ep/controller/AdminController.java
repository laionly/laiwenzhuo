package com.ep.ep.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ep.ep.dao.admin.AdminDao;
import com.ep.ep.entity.Admin;
import com.ep.ep.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService as;
	@RequestMapping(value="register",method = RequestMethod.POST)
   public void adminRegister(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Admin admin=new Admin(request.getParameter("name"),request.getParameter("password"));
		as.insertAdmin(admin);
		response.getWriter().println("<script>alert('注册成功！！！');window.location='adminlogin.jsp'</script>");  
   }
	
   @RequestMapping(value="adminlogin",method = RequestMethod.POST)
   public String loginAdmin(Model model,HttpServletResponse response,HttpServletRequest request
		   ,@RequestParam(value="name")String name,@RequestParam(value="password")String password)throws Exception{
	   request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	   Admin admin=as.loginAdmin(request.getParameter("name"),request.getParameter("password"));
	   System.out.println("name="+name);
	   System.out.println("password="+password);
	   if(admin!=null){
	    	response.getWriter().println("<script>alert('登录成功！！！');window.location='main.jsp'</script>");
	    }else{
	    	response.getWriter().println("<script>alert('登录失败！！！');window.location='adminlogin.jsp'</script>");
	    }
	   return null;  
   }
}
