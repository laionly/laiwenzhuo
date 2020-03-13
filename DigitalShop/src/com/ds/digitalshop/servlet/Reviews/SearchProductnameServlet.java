package com.ds.digitalshop.servlet.Reviews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.CollectService;
import com.ds.digitalshop.service.ProductReviewsService;

/**
 * Servlet implementation class SearchProductnameServlet
 */
public class SearchProductnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchProductnameServlet() {
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
		CollectService cService = (CollectService) ac.getBean("CollectServiceImpl");
		String name = request.getParameter("name");

		List<Product> list = prss.findproduct(name);

		List<Map<String, Object>> lists = new ArrayList<>();
		if (request.getSession().getAttribute("user") != null) {
			User user = new User();
			Integer userid = ((User) request.getSession().getAttribute("user")).getUserid();
			user.setUserid(userid);


			for (Product product : list) {
				Map<String, Object> map = new HashMap<>();

				map.put("productid", product.getProductid());
				map.put("name", product.getName());
				map.put("description", product.getDescription());
				map.put("listimg", product.getListimg());
				map.put("price", product.getPrice());
				map.put("discountprice", product.getDiscountprice());
				
				// 大于0为已收藏，0为未收藏
				Collect collect = cService.selectCollect(userid, product.getProductid());
				if (collect != null) {
					map.put("collect", collect.getCid());
				} else {
					map.put("collect", 0);
				}
				System.out.println(map);
				lists.add(map);
			}

			request.setAttribute("list", lists);

			request.getRequestDispatcher("product_grid.jsp").forward(request, response);
		} else {
//			List<Product> list = prss.findproduct(name);
//
//			List<Map<String, Object>> lists = new ArrayList<>();

			for (Product product : list) {
				Map<String, Object> map = new HashMap<>();

				map.put("productid", product.getProductid());
				map.put("name", product.getName());
				map.put("description", product.getDescription());
				map.put("listimg", product.getListimg());
				map.put("price", product.getPrice());
				map.put("discountprice", product.getDiscountprice());
				map.put("collect", 0);
				System.out.println(map);
				lists.add(map);
			}

			request.setAttribute("list", lists);

			request.getRequestDispatcher("product_grid.jsp").forward(request, response);
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
