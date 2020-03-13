package com.naive.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naive.entity.Admin;
import com.naive.entity.SysStatus;
import com.naive.entity.SysTool;
import com.naive.servicedao.AdminServiceDao;
import com.naive.util.NaiveUtil;
/**
 * 管理员首页controller
 * @author Naive
 * @date: 2019年12月17日 下午4:42:21
 */
@Controller
public class AdminMainController {
	@Resource
	private AdminServiceDao adminServiceDao;
	
	@RequestMapping(value="adminlogin", method = RequestMethod.POST)
	public String AdminLogin(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		Admin admin = adminServiceDao.AdminLogin(request.getParameter("adminName"), 
				request.getParameter("passWord"));
		if (admin != null) {
			request.getSession().setAttribute("ADMIN_SESSION", admin);
			return "redirect:/ManagementSystem/frame.jsp";
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('登录失败！');window.location.href='/DigitalShop/ManagementSystem/login.jsp'</script>");
			//request.getRequestDispatcher("/ManagementSystem/login.jsp").forward(request, response);
			return null;
		}
	}
	
	@RequestMapping("main")
	public String GetSystem(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		NaiveUtil naiveUtil = new NaiveUtil();
		SysStatus status = adminServiceDao.selStatus();
		SysTool sysTool = naiveUtil.sysTool(request);
		status.setPeopleOnline(String.valueOf(request.getSession().getServletContext().getAttribute("numSessions")));
		request.setAttribute("sysStatus", status);
		request.setAttribute("sysTool", sysTool);
		return "/ManagementSystem/tgls/main/main.jsp";
	}
	
	@RequestMapping("Loginoff")
	public String LoginOff(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession(false);//防止创建Session
		session.removeAttribute("ADMIN_SESSION");
		response.getWriter().print("<script type=\"text/javascript\">alert('请重新登录');top.window.location.href='/DigitalShop/ManagementSystem/login.jsp'</script>");
		return null;
	}
	
	@RequestMapping("UpPassword")
	public String UpPassword(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("ADMIN_SESSION");
		if (request.getParameter("oldpassword").equals(admin.getPassword())) {
			if (request.getParameter("password").equals(request.getParameter("password2"))) {
				admin.setPassword(request.getParameter("password"));
				if (adminServiceDao.AdminUpdata(admin)) {
					return "Loginoff";
				}
			}else {
				response.getWriter().print("<script type=\"text/javascript\">alert('两次输入的密码有误');window.location.href='/DigitalShop/ManagementSystem/tgls/admin_password.jsp'</script>");
			}
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('密码错误');window.location.href='/DigitalShop/ManagementSystem/tgls/admin_password.jsp'</script>");
		}
		return null;
	}

}
