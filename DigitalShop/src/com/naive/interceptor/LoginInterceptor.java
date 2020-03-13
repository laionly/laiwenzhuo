package com.naive.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.naive.entity.Admin;
/**
 *拦截器登录判断
 * @author Naive
 * @date 2019年12月21日
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取请求的RUi:去除http:localhost:8080这部分剩下的
//        String uri = request.getRequestURI();
//        StringBuffer url = request.getRequestURL();
		String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length()); 
        System.out.println(url);
        if ("/adminlogin".equals(url)) {
            return true;
        }
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("ADMIN_SESSION");
        //判断session中是否有用户数据，如果有，则返回true，继续向下执行
        if (user != null) {
            return true;
        }
        response.getWriter().print("<script type=\"text/javascript\">alert('请登录');top.window.location.href='/DigitalShop/ManagementSystem/login.jsp'</script>");
        return false;
    }
}
