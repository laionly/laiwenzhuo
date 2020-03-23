package com.ep.ep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ep.ep.entity.Product_type;
import com.ep.ep.service.ProductTypeService;

@Controller
public class ProductTypeController {
    @Autowired
	ProductTypeService pService;
    
    //跳转到添加类型界面
    @RequestMapping(value="addtotype")
    public String addtotype(){
    	return "addtype";
    }
    
    //添加类型
    @RequestMapping(value="saveproducttype" ,method = RequestMethod.GET)
    public void saveProducttype(HttpServletRequest request,HttpServletResponse response,HttpSession session)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String typename=request.getParameter("typename");
		Product_type product_type=new Product_type(typename);
		pService.saveProductType(product_type);
		session.setAttribute("producttype", pService.findAllProducttype());
		response.getWriter().println("<script>alert('添加成功');window.location='main.jsp'</script>");
    }
    
    //跳转到删除类型界面
    @RequestMapping(value="todelettype" ,method = RequestMethod.GET)
    public String toDeleteType(Product_type product_type,HttpServletRequest request,HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Product_type> producttype= pService.findAllProducttype();
		request.setAttribute("producttype", producttype);
    	return "deletetype";	
    }
    
    //删除类型界面
    @RequestMapping(value="deleteProductType",method= RequestMethod.GET)
    public void deleteProductType(HttpServletRequest request,HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int ptid=Integer.parseInt(request.getParameter("ptid"));
		pService.deleteProductType(ptid);
		response.getWriter().println("<script>alert('删除成功');window.location='todelettype'</script>");
    }
    
}
