package com.ep.ep.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 用户拦截器
 * 如果获取不到uid则跳转至登录页
 * 反之放行
 * @author lwz
 *
 */
public class UserInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if (request.getSession().getAttribute("uid")!=null) {
			return true;
		}else {
			response.getWriter().println("<script>alert('请登录');window.location='login.jsp'</script>");
			return false;
		}
	}

}
