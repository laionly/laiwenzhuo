package com.ds.digitalshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.OrderDao;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.service.OrderService;
@Service("OrderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderdao;
    
	@Override
	public void addOrder(Order order) {
		orderdao.addOrder(order);	
	}

	@Override
	public List<Order> selectOrder(int productid) {
		List<Order> order=orderdao.selectOrder(productid);
		return order;
	}

	@Override
	public Order selectOneOrder(int productid) {
		Order order=orderdao.selectOneOrder(productid);
		return order;
	}  
}
