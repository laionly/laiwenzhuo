package com.ep.ep.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
import com.ep.ep.entity.Product;
import com.ep.ep.entity.Product_type;
import com.ep.ep.service.ProductService;
import com.ep.ep.service.ProductTypeService;
import com.ep.ep.util.FileAccepterUtil;

@Controller
public class ProductController {
   
	@Autowired
	ProductService productService;
	@Autowired
	ProductTypeService pService;
	
	@RequestMapping(value="toaddproduct")
	public String toaddproduct(HttpServletRequest request,HttpServletResponse response){
		
		List<Product_type> producttype= pService.findAllProducttype();
		System.out.println(producttype);
		request.setAttribute("producttype", producttype);
		return "/addproduct.jsp";
	}
	
	@RequestMapping(value="addproduct")
	public String insertProduct(@RequestParam(value="picture")MultipartFile mf,
			 HttpSession session, HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		//获取upload这个文件夹的绝对路径
		String path=session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		//获取文件名
		String oldFileName=mf.getOriginalFilename();
		//将路径和文件名包装到File对象生成文件对象
		File file=new File(path+File.separator+oldFileName);	
		//将当前文件数据to给谁，这里to给tomcat目录下生成图片
		mf.transferTo(file);
		Product product=new Product(request.getParameter("name"),Double.valueOf(request.getParameter("price")),
				          Double.valueOf(request.getParameter("rprice")),oldFileName,Integer.parseInt(request.getParameter("pt_id")));
		
		
		productService.insertProduct(product);
		System.out.println(product);
		response.getWriter().println("<script>alert('添加成功');window.location='main.jsp'</script>");
		return  null;
	}
	
	@RequestMapping(value="productlist", method = RequestMethod.GET)
	public String selectProduct(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Product> products=productService.findAll();
		request.setAttribute("products", products);
		return "/productlist.jsp";
	}
	
	 @RequestMapping(value="deleteProduct",method= RequestMethod.GET)
	    public void deleteProductType(HttpServletRequest request,HttpSession session,HttpServletResponse response)throws Exception{
	    	request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String path=session.getServletContext().getRealPath("/upload");
			int pid=Integer.parseInt(request.getParameter("pid"));
		    productService.deleteProduct(pid,path);
			response.getWriter().println("<script>alert('删除成功');window.location='productlist'</script>");
	    }
	 
	/* @RequestMapping(value="updateproduct",method= RequestMethod.GET)
	 public String updateProduct(@RequestParam("file")MultipartFile file, HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		 String path = request.getServletContext().getRealPath("/Productimg/")+"upload/";
		 Product product=new Product(request.getParameter("name"),
				              Double.valueOf("price"),Double.valueOf("rprice"),request.getParameter("picture"));
		 product.setPid(Integer.parseInt(request.getParameter("pid")));
		 productService.UpProduct(product, file, path);
		 response.getWriter().print("<script type=\"text/javascript\">alert('修改成功！');window.location.href='productlist'</script>");
		 return null;
	 } */
	
}
