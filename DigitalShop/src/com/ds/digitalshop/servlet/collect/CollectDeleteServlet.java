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

import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.service.CollectService;

/**
 * Servlet implementation class CollectDeleteServlet
 */
@WebServlet("/CollectDeleteServlet")
public class CollectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectDeleteServlet() {
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
		Integer cid=Integer.parseInt(request.getParameter("cid"));
		ServletContext sc =getServletContext();
		String config=sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		CollectService cService=(CollectService)ac.getBean("CollectServiceImpl");
		
		Product product=new Product();
		Integer productid=Integer.parseInt(request.getParameter("productid"));
		product.setProductid(productid);
		
		String page = request.getParameter("pagenum");
		
		//0是收藏页，1是个详情页
		int flag = Integer.parseInt(request.getParameter("flag"));

		cService.deleteCollect(cid);	
		//request.getRequestDispatcher("FindAllProductServlet").forward(request, response);
		
		if (flag==0) {
			response.getWriter().println("<script>alert('已取消收藏');window.location='FindAllProductServlet?pagenum="+page+"'</script>");
		}else{
			{
				response.getWriter().println("<script>alert('已取消收藏');window.location='ProductDetails?productid="+productid+"'</script>");		
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
