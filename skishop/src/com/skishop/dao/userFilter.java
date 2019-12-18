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

public class userFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("摧毁方法");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		System.out.println("执行该过滤器");
		//强制类型转换，把ServletRequest转换为HttpServletRequest
		HttpServletRequest req=(HttpServletRequest) request;
//		HttpServletResponse res=(HttpServletResponse) response;
//		StringBuffer requestURL=req.getRequestURL();
//		String uri=req.getRequestURI();
		String email=(String) req.getSession().getAttribute("email");//判断用户是否登入
		System.out.println(email);
//		System.out.println(requestURL);
//		System.out.println(uri);
		//判断访问的是否是显示购物车页
			if(email==null || "".equals(email)){
				System.out.println("name="+email);
				response.getWriter().println("<script> alert('请登录或管理员无法使用此功能');window.location='login.html'</script>");
				return;
			}else {
			
//			System.out.println("路径报错");
//			res.sendRedirect("login.html");
//			return;
		}
		chain.doFilter(request, response);//放行请求、响应资源

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化方法");

	}

}
