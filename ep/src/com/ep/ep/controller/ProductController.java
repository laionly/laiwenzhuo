package com.ep.ep.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Product;
import com.ep.ep.entity.Product_type;
import com.ep.ep.service.ProductService;
import com.ep.ep.service.ProductTypeService;
import com.ep.ep.util.FileAccepterUtil;
import com.ep.ep.util.Page;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	ProductTypeService pService;

	@RequestMapping(value = "toaddproduct")
	public String toaddproduct(HttpServletRequest request, HttpServletResponse response) {

		List<Product_type> producttype = pService.findAllProducttype();
		System.out.println(producttype);
		request.setAttribute("producttype", producttype);
		return "addproduct";
	}

	@RequestMapping(value = "addproduct")
	public String insertProduct(@RequestParam(value = "picture") MultipartFile mf, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取upload这个文件夹的绝对路径
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		//若不存在文件路径，则创建
		File file2=new File(path);
		if (!file2.exists()){
			file2.mkdirs();
		}
		// 获取文件名
		String oldFileName = mf.getOriginalFilename();
		// 将路径和文件名包装到File对象生成文件对象
		File file = new File(path + File.separator + oldFileName);
		// 将当前文件数据to给谁，这里to给tomcat目录下生成图片
		mf.transferTo(file);
		Product product = new Product(request.getParameter("name"), Double.valueOf(request.getParameter("price")),
				Double.valueOf(request.getParameter("rprice")), oldFileName,
				Integer.parseInt(request.getParameter("pt_id")));

		productService.insertProduct(product);
		System.out.println(product);
		response.getWriter().println("<script>alert('添加成功');window.location='main.jsp'</script>");
		return null;
	}

	@RequestMapping(value = "productlist", method = RequestMethod.GET)
	public String selectProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Product> products = productService.findAll();
		request.setAttribute("products", products);
		return "productlist";
	}

	@RequestMapping(value = "deleteProduct", method = RequestMethod.GET)
	public void deleteProductType(HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = session.getServletContext().getRealPath("/upload");
		int pid = Integer.parseInt(request.getParameter("pid"));
		productService.deleteProduct(pid, path);
		response.getWriter().println("<script>alert('删除成功');window.location='productlist'</script>");
	}
    
	//根据id查询商品
	@RequestMapping(value="findProductById")
	public String findProductById(@RequestParam(value="pid")Integer pid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Product product=productService.findProductById(pid);
		System.out.println(product);
		request.setAttribute("product", product);
		return "productupdate";	
	}
	
	@RequestMapping(value = "updateproduct", method = RequestMethod.POST)
	public String updateProduct(MultipartFile mf, HttpServletRequest request,
			HttpServletResponse response, HttpSession session,Product product) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = session.getServletContext().getRealPath("/upload");
		File file2=new File(path);
		if (!file2.exists()){
			file2.mkdirs();
		}
		// 获取文件名
		String oldFileName = mf.getOriginalFilename();
		File file = new File(path + File.separator + oldFileName);
		// 将当前文件数据to给谁，这里to给tomcat目录下生成图片
		mf.transferTo(file);
		product.setPicture(oldFileName);
		productService.updateProduct(product);
		response.getWriter().println("<script>alert('修改成功');window.location='productlist'</script>");
		return null;
	}
	
	@RequestMapping(value="pageProduct")
	public ModelAndView pageProduct(HttpServletRequest request, String pagenum, String nowpage)
			throws ServletException {
		int pageNum = 1;// 分页设置，从第几项开始
		int size = 12;// 分页设置，每次显示几项
		if (pagenum == null) {
			if (nowpage == null) {
				pageNum = 1;
			} else {
				String page = nowpage;
				pageNum = Integer.valueOf(page);
			}
		} else {
			String page = pagenum;
			pageNum = Integer.valueOf(page);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", Math.abs((pageNum-1)*size));//分页设置，从第几项开始，0表示第一项
		params.put("size", size);//分页设置，每次显示几项
		Page<Product> pager = new Page<Product>(pageNum,size);
		List<Product> products=productService.pageProduct(params);
		pager.setTotalCount(productService.productCount());
		pager.setList(products);
		return new ModelAndView("grid-product","page",pager) ;

	}

	@RequestMapping(value = "findProductByName",method = RequestMethod.POST)
	public ModelAndView findProductByName(String name,String pagenum, String nowpage){
		int pageNum = 1;// 分页设置，从第几项开始
		int size = 12;// 分页设置，每次显示几项
		if (pagenum == null) {
			if (nowpage == null) {
				pageNum = 1;
			} else {
				String page = nowpage;
				pageNum = Integer.valueOf(page);
			}
		} else {
			String page = pagenum;
			pageNum = Integer.valueOf(page);
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("page", Math.abs((pageNum-1)*size));//分页设置，从第几项开始，0表示第一项
		params.put("size", size);//分页设置，每次显示几项
		params.put("name",name);
		Page<Product> pager=new Page<>(pageNum,size);
		List<Product> products=productService.findProductByName(params);
		pager.setTotalCount(productService.productCountByName(name));
		pager.setList(products);
		return new ModelAndView("grid-product","page",pager);
	}
	

}
