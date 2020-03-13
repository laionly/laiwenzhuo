package com.naive.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ds.digitalshop.entity.Product;
import com.naive.servicedao.AdminProductServiceDao;
import com.naive.util.FileAccepterUtil;
/**
 *管理员商品Controller
 * @author Naive
 * @date 2019年12月23日
 */
@Controller
public class ProductController {
	@Resource
	private AdminProductServiceDao adminProductServiceDao;

	
	@RequestMapping("addProduct")
	public String addProduct(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
		String path = request.getServletContext().getRealPath("/Productimg/")+"upload/";
        FileAccepterUtil accepterUtil = new FileAccepterUtil();
		String fileName = accepterUtil.FileUpload(file, path);
        if (fileName!=null) {
        	Product product = new Product(request.getParameter("name"),
    				request.getParameter("description"),
    				fileName,
    				Integer.valueOf(request.getParameter("price")),
    				Integer.valueOf(request.getParameter("discountprice")));
        	adminProductServiceDao.addProduct(product);
        	response.getWriter().print("<script type=\"text/javascript\">alert('添加成功！');window.location.href='/DigitalShop/ManagementSystem/tgls/goodsManage/goods_add.jsp'</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('添加失败！');window.location.href='/DigitalShop/ManagementSystem/tgls/goodsManage/goods_add.jsp'</script>");
		}
		return null; 
	}
	
	
	public String ProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("productlist", adminProductServiceDao.findAllProduct());
		return "/ManagementSystem/tgls/goodsManage/goods_list.jsp";
	}
	
	@RequestMapping("DelProduct")
	public String DelProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/Productimg/")+"upload/";
		if (adminProductServiceDao.DelProduct(Integer.valueOf(request.getParameter("pid")), path)) {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除成功！');window.location.href='ProductList'</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('删除失败！');window.location.href='ProductList'</script>");
		}
		return null;
	}
	
	@RequestMapping("SelectProduct")
	public String SelectProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("product", 
				adminProductServiceDao.selProduct(Integer.valueOf(request.getParameter("pid"))));
		return "/ManagementSystem/tgls/goodsManage/goods_update.jsp";
	}
	
	@RequestMapping("UpdateProduct")
	public String UpdateProduct(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletContext().getRealPath("/Productimg/")+"upload/";
		Product product = new Product(request.getParameter("name"),
				request.getParameter("description"),
				request.getParameter("listimg"),
				Integer.valueOf(request.getParameter("price")),
				Integer.valueOf(request.getParameter("price")));
		product.setProductid(Integer.valueOf(request.getParameter("pid")));
		if (adminProductServiceDao.UpProduct(product, file, path)) {
			response.getWriter().print("<script type=\"text/javascript\">alert('修改成功！');window.location.href='ProductList'</script>");
		}else {
			response.getWriter().print("<script type=\"text/javascript\">alert('修改失败！');window.location.href='SelectProduct'</script>");
		}
		
		return null;
	}
	
	@RequestMapping("ProductList")
	public String PageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pagenum = 1;
		try {
			String page = request.getParameter("pagenum");
			String nowpage = request.getParameter("nowpage");
			if (nowpage!=null) {
				pagenum = Integer.valueOf(nowpage);
			}else {
				pagenum = Integer.valueOf(page);
			}
		} catch (Exception e) {
			pagenum = 1;
		}
		request.setAttribute("productlist", adminProductServiceDao.ProductPage(pagenum));
		return "/ManagementSystem/tgls/goodsManage/goods_list.jsp";
	}
}
