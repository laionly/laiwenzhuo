package com.ds.digitalshop.servlet.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.CollectService;
import com.ds.digitalshop.service.ProductService;

import javassist.CodeConverter.ArrayAccessReplacementMethodNames;

/**
 * Servlet implementation class FindAllProductServlet
 */
@WebServlet("/FindAllProductServlet")
public class FindAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllProductServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext sc=getServletContext();
		String config =sc.getInitParameter("contextConfigLocation");
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		ProductService ps=(ProductService)ac.getBean("pserviceImpl");
		CollectService cService=(CollectService)ac.getBean("CollectServiceImpl");

		int pagenum=1;
		try{
			String page = request.getParameter("pagenum");
			pagenum = Integer.valueOf(page);
		}catch(Exception e){
			pagenum=1;
		}
		Page<Product> page=ps.productpage(pagenum);
		
		List<Map<String, Object>> lists = new ArrayList<>();
		
		if (request.getSession().getAttribute("user")!=null) {
			User user=new User();
			Integer userid=((User)request.getSession().getAttribute("user")).getUserid();
			user.setUserid(userid);
			
			List<Product> list=page.getList();

			for (Product product : list) {
				Map<String, Object> map = new HashMap<>();
				
				map.put("productid", product.getProductid());
				map.put("name", product.getName());
				map.put("description", product.getDescription());
				map.put("listimg", product.getListimg());
				map.put("price", product.getPrice());
				map.put("discountprice", product.getDiscountprice());
				
				//大于0为已收藏，0为未收藏
				Collect collect = cService.selectCollect(userid, product.getProductid());
				if (collect!=null) {
					map.put("collect", collect.getCid());
				}else{
					map.put("collect", 0);
				}
				
				lists.add(map);
			}
		}else {
			List<Product> list=page.getList();
			
			lists = new ArrayList<>();
			
			for (Product product : list) {
				Map<String, Object> map = new HashMap<>();
				
				map.put("productid", product.getProductid());
				map.put("name", product.getName());
				map.put("description", product.getDescription());
				map.put("listimg", product.getListimg());
				map.put("price", product.getPrice());
				map.put("discountprice", product.getDiscountprice());
				map.put("collect", 0);
				
				lists.add(map);
			}
		}
		Page<Map<String, Object>> page2 = new Page<Map<String, Object>>();
		
		page2.setNextPageNum(page.getNextPageNum());
		page2.setPageNum(page.getPageNum());
		page2.setPageSize(page.getPageSize());
		page2.setPrePageNum(page.getPrePageNum());
		page2.setTotalCount(page.getTotalCount());
		page2.setTotalPageNum(page.getTotalPageNum());
		page2.setList(lists);
		
		request.getSession().setAttribute("product", page2);
		
		request.getRequestDispatcher("product_grid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
