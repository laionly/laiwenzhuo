package com.ds.digitalshop.servlet.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.CollectService;
import com.ds.digitalshop.service.ProductReviewsService;
import com.ds.digitalshop.service.ProductService;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
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
		Integer productid=Integer.parseInt(request.getParameter("productid"));
		ServletContext sc=getServletContext();
		String config =sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		ProductService ps=(ProductService)ac.getBean("pserviceImpl");
		CollectService cService=(CollectService)ac.getBean("CollectServiceImpl");
		ProductReviewsService prs = (ProductReviewsService) ac.getBean("ProductReviewsServiceImpl");
		Product product=ps.selectproduct(productid);
		
		if (request.getSession().getAttribute("user")!=null) {

			User user=new User();
			Integer userid=((User)request.getSession().getAttribute("user")).getUserid();
			user.setUserid(userid);
			
			Collect collect = cService.selectCollect(userid, product.getProductid());
			
			request.setAttribute("product", product);
			
			if (collect!=null) {
				request.setAttribute("collect", collect.getCid());
			}else{
				request.setAttribute("collect", 0);
			}
			
			product.setProductid(productid);
			List<Appraise> prlist = prs.findAll(productid);
			//获取单个商品评价总数
			int count=prlist.size();
			request.setAttribute("productid", productid);
			request.setAttribute("list", prlist);
			request.setAttribute("count", count);
			
			
			request.getRequestDispatcher("product_single.jsp").forward(request, response);
		}else {
			request.setAttribute("product", product);
			
			request.setAttribute("collect", 0);
			
			product.setProductid(productid);
			List<Appraise> prlist = prs.findAll(productid);
			//获取单个商品评价总数
			int count=prlist.size();
			request.setAttribute("productid", productid);
			request.setAttribute("list", prlist);
			request.setAttribute("count", count);
			
			request.getRequestDispatcher("product_single.jsp").forward(request, response);
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
