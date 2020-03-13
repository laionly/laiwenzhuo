package com.naive.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.digitalshop.entity.User;
import com.naive.servicedao.AdminUserServiceDao;
/**
 * 用户controller
 * @author Naive
 * @date 2019年12月26日
 */
@Controller
public class UsersController {
	@Resource
	private AdminUserServiceDao adminUserServiceDao;
	
	@RequestMapping("UserList")
	public String UserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum = 1;
		try {
			String page = request.getParameter("pagenum");
			String nowpage = request.getParameter("nowpage");
			if (nowpage!=null) {
				pagenum = Integer.valueOf(nowpage);
			}else {
				pagenum = Integer.valueOf(page);
			}
		} catch (Exception e) {
			pagenum = 1;
		}
		request.setAttribute("userslist", adminUserServiceDao.UsersPage(pagenum));
		return "/ManagementSystem/tgls/agent/agent_list.jsp";
	}
	
	@RequestMapping("DeleteUser")
	public String DeleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (adminUserServiceDao.DelUsers(Integer.valueOf(request.getParameter("id")))) {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除成功！');window.location.href='UserList'</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除失败！');window.location.href='UserList'</script>");
		}
		return null;
	}
	
	@RequestMapping("UpUserPassword")
	public String UpUserPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameter("password").equals(request.getParameter("password2"))) {
			response.getWriter().print("<script type=\"text/javascript\">alert('两次密码不一样！');window.location.href='/DigitalShop/ManagementSystem/tgls/users_password.jsp'</script>");
		}else {
			if (adminUserServiceDao.UpdatePassword(Integer.valueOf(request.getParameter("id")),
					request.getParameter("password"))) {
				response.getWriter().print("<script type=\"text/javascript\">alert('修改成功！');window.location.href='/DigitalShop/ManagementSystem/tgls/users_password.jsp'</script>");
			}
		}
		return null;
	}
	
	@RequestMapping("selUser")
	public String selUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = adminUserServiceDao.selectUser(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("user", user);
		return "/ManagementSystem/tgls/agent/agent_order.jsp";
	}
	
	@RequestMapping("DelCollect")
	public String DelCollect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (adminUserServiceDao.DelCollect(Integer.valueOf(request.getParameter("cid")))) {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除成功！');window.location.href='UserList'</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除失败！');window.location.href='UserList'</script>");
		}
		return null;
	}
	
	@RequestMapping("agentquery")
	public String AgentQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum = 1;
		try {
			String page = request.getParameter("pagenum");
			String nowpage = request.getParameter("nowpage");
			if (nowpage!=null) {
				pagenum = Integer.valueOf(nowpage);
			}else {
				pagenum = Integer.valueOf(page);
			}
		} catch (Exception e) {
			pagenum = 1;
		}
		request.setAttribute("userslist", adminUserServiceDao.queryUserPage(pagenum,
				request.getParameter("name")));
		return "/ManagementSystem/tgls/agent/agent_list.jsp";
	}
	
	@RequestMapping("UserOrder")
	public String UserOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userorder",adminUserServiceDao.userOrder(Integer.valueOf(request.getParameter("orderid"))));
		return "/ManagementSystem/tgls/agent/agent_orderdetails.jsp";
	}
}
