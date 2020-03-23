package com.ep.ep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.service.OrderBaseService;

@Controller
public class OrderBaseController {
   @Autowired
   private OrderBaseService orderBaseService;
   
   @RequestMapping(value="findorder")
   public String order(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	   request.setCharacterEncoding("utf-8");
	   response.setCharacterEncoding("utf-8");
	   response.setContentType("text/html;charset=utf-8");
	   List<Orderbase> orderbases=orderBaseService.findOrderbase();
	   request.setAttribute("orderbases",orderbases);
	   return "adminorder";
   }
}
