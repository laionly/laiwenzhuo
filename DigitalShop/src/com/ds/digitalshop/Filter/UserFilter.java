package com.ds.digitalshop.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest req=(HttpServletRequest) request;
		String username=(String) req.getSession().getAttribute("username");//判断用户是否登入
		System.out.println(username);
			if(username==null || "".equals(username)){
				System.out.println("name="+username);
				response.getWriter().println("<script> alert('请登录后再进行操作');window.location='login.jsp'</script>");
				return;
			}else {
				chain.doFilter(request, response);//放行请求、响应资源
		}
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
