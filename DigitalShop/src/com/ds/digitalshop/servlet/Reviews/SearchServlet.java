package com.ds.digitalshop.servlet.Reviews;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.ProductReviewsService;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;chara=utf-8");
				
				ServletContext sc=getServletContext();
				String config =sc.getInitParameter("contextConfigLocation");
				ApplicationContext ac =WebApplicationContextUtils.getWebApplicationContext(sc);
				ProductReviewsService prss=(ProductReviewsService) ac.getBean("ProductReviewsServiceImpl");
				
				Product product=new Product();
				int productid=Integer.parseInt(request.getParameter("product"));
				System.out.println("servlet"+productid);
				product.setProductid(productid);
//				prss.findProductByProductid(productid);
				List list= (List) prss.findoneproductid(productid);
				request.setAttribute("product", list);
				request.getRequestDispatcher("product_grid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
