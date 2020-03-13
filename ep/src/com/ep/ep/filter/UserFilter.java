package com.ep.ep.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter{

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
		/**
		 * 获取session作用域中的uid值（登录时设置）
		 * 若未登录则跳转到登录页面
		 * 若登录过后访问过滤的jsp则跳转至主页index.jsp
		 */
		if (req.getSession().getAttribute("uid")==null) {
			response.getWriter().println("<script> alert('请登录后再进行操作');window.location='login.jsp'</script>");
		} else{
			response.getWriter().println("<script> window.location='index.jsp'</script>");
			chain.doFilter(request, response);//放行请求、响应资源
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
