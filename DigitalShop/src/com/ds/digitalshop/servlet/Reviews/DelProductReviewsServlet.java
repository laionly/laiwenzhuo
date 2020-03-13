package com.ds.digitalshop.servlet.Reviews;

import java.io.IOException;

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
import com.ds.digitalshop.service.ProductReviewsService;

/**
 * Servlet implementation class DelProductReviewsServlet
 */
@WebServlet("/DelProductReviews")
public class DelProductReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelProductReviewsServlet() {
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

		Appraise appraise = new Appraise();
		int aid = Integer.parseInt(request.getParameter("aid"));
		int productid = Integer.parseInt(request.getParameter("productid"));
		User user = (User) request.getSession().getAttribute("user");
		// 获取商品评价用户的名字
		String name = request.getParameter("name");
		// 获取正在登录用户的名字
		String username = user.getUsername();
		if (name.equals(username) ) {
			appraise.setAid(aid);
			prs.delproductreview(aid);
			request.getRequestDispatcher("ProductDetails?productid=" + productid).forward(request, response);
		} else {
			response.getWriter()
					.println("<script> alert('您不能删除别人的评论');window.location='ProductDetails?productid="
							+ productid + "'</script>");
		}

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
