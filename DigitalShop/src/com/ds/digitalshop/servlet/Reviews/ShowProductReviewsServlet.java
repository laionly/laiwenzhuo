package com.ds.digitalshop.servlet.Reviews;

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
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.service.ProductReviewsService;
import com.ds.digitalshop.service.ProductService;

/**
 * Servlet implementation class ShowProductReviewsServlet
 */
@WebServlet("/ShowProductReviewsServlet")
public class ShowProductReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowProductReviewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决中文乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		ServletContext sc = getServletContext();
		String config = sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		ProductReviewsService prs = (ProductReviewsService) ac.getBean("ProductReviewsServiceImpl");

		Product product = new Product();
		int productid = 0;
		if (request.getParameter("productid") != null) {
			productid = Integer.parseInt(request.getParameter("productid"));
		} else {
			productid = (int) request.getAttribute("productid");
		}
		product.setProductid(productid);
		List<Appraise> prlist = prs.findAll(productid);
		//获取单个商品评价总数
		int count=prlist.size();
		request.setAttribute("productid", productid);
		request.setAttribute("list", prlist);
		request.setAttribute("count", count);
		request.getRequestDispatcher("product_single.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
