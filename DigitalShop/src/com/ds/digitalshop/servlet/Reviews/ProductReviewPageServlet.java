package com.ds.digitalshop.servlet.Reviews;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.service.ProductReviewsService;

/**
 * Servlet implementation class ProductReviewPageServlet
 */
public class ProductReviewPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductReviewPageServlet() {
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
		response.setContentType("text/html;chara=utf-8");

		ServletContext sc = getServletContext();
		String config = sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		ProductReviewsService prss = (ProductReviewsService) ac.getBean("ProductReviewsServiceImpl");

		int pagenum = 1;
		String page = request.getParameter("pagenum");
		String nowpage = request.getParameter("nowpage");
		if (nowpage != null) {
			pagenum = Integer.valueOf(nowpage);
		} else {
			pagenum = Integer.valueOf(page);
		}
		request.setAttribute("pagenum", pagenum);
		request.getRequestDispatcher("ShowProductReviewsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
