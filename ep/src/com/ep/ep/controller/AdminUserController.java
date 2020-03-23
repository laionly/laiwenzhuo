package com.ep.ep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ep.ep.entity.User;
import com.ep.ep.service.AdminUserService;

@Controller
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    
    @RequestMapping(value="finduser")
    public String finduser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<User> users=adminUserService.findAllUsers();
		request.setAttribute("users", users);
    	return "finduser";
    }
    
    @RequestMapping(value="deleteuser",method = RequestMethod.GET)
    public String deleteuser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Integer uid=Integer.parseInt(request.getParameter("uid"));
		adminUserService.deleteUser(uid);
		response.getWriter().println("<script>alert('删除成功');window.location='finduser'</script>");
    	return null;
    }
    
   
}
