package com.skishop.servlets.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skishop.dao.product.impl.ProductDaoImpl;
import com.skishop.entity.Page;
import com.skishop.entity.Product;

/**
 * Servlet implementation class ProductPageListServlet
 */
@WebServlet("/productpage")
public class ProductPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取超链接中请求参数(pageNum),上一页、下一页、首页、末页四个超链接参数保持一致
		String number= request.getParameter("pageNum");
		//因为商品分页超链接中没有请求参数，说以number一直为null;
		//如果number为null,pageNum也就是当前页等于1
		//只有当number不为null时，才强制转化为int
		int pageNum=0;
		//判断是否获取请求，如果不获取则显示第一页
		if(number==null || number.equals("")){
			pageNum=1;
		}else {
			pageNum=Integer.parseInt(number);
		}
		ProductDaoImpl pd=new ProductDaoImpl();
		List<Product> page= pd.findProductByPage(pageNum, 4);
		int count= pd.findCount();
		//实例化Page封装类对象
		Page<Product> p=new Page<Product>(pageNum,4);
		p.setTotalCount(count);//赋值给totalCount属性
		p.setList(page);
		request.setAttribute("page", p);//与上面page无关
		request.getRequestDispatcher("productpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
