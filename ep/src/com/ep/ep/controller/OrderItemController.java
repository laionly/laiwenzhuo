package com.ep.ep.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ep.ep.entity.Orderitem;
import com.ep.ep.service.OrderItemService;

@Controller
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;
    
    @RequestMapping(value="orderitem")
    public String orderItem(HttpServletRequest request,HttpServletResponse response,int oderbase_id)throws SecurityException,IOException{
       request.setCharacterEncoding("utf-8");
  	   response.setCharacterEncoding("utf-8");
  	   response.setContentType("text/html;charset=utf-8");
//     Integer oderbase_id=Integer.parseInt(request.getParameter("oderbase_id"));
  	   List<Orderitem> orderitems=orderItemService.findAllOrderitem(oderbase_id);
  	   request.setAttribute("orderitems", orderitems);
    	return "adminorderitem";
    }
}
