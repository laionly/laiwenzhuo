package com.ds.digitalshop.servlet.collect;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.CollectService;

/**
 * Servlet implementation class CollectAddServlet
 */
@WebServlet("/CollectAddServlet")
public class CollectAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		ServletContext sc =getServletContext();
		String config=sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		CollectService cService=(CollectService)ac.getBean("CollectServiceImpl");
		
		User user=new User();
		Integer userid=((User)request.getSession().getAttribute("user")).getUserid();
		user.setUserid(userid);
		
		String page = request.getParameter("pagenum");
		
		//0是收藏页，1是个详情页
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		Product product=new Product();
		Integer productid=Integer.parseInt(request.getParameter("productid"));
		product.setProductid(productid);
		
		Collect collect=new Collect(product,user);
		
		if (cService.selectCollect(userid,productid)!=null) {
			
			if (flag==0) {
				response.getWriter().println("<script>alert('您已经收藏过了');window.location='FindAllProductServlet?pagenum="+page+"'</script>");		
			}else {
				response.getWriter().println("<script>alert('您已经收藏过了');window.location='ProductDetails?productid="+productid+"'</script>");		
			}
			
		}else {
			if (flag==0) {
				cService.addCollect(collect);
		        response.getWriter().println("<script>alert('已收藏');window.location='FindAllProductServlet?pagenum="+page+"'</script>");		
			}else {
				cService.addCollect(collect);
				response.getWriter().println("<script>alert('已收藏');window.location='ProductDetails?productid="+productid+"'</script>");		
			}
		    
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
