package com.skishop.dao;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest req=(HttpServletRequest) request;
		String email=(String) req.getSession().getAttribute("adminemail");//判断管理员是否登入
		if(email==null || "".equals(email)){
			System.out.println("name="+email);
			response.getWriter().println("<script> alert('用户权限不够');window.location='productlist'</script>");
			return;
					}
				else {
					
				}
				chain.doFilter(request, response);//放行请求、响应资源

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
