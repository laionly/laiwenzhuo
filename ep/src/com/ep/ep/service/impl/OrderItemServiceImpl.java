package com.ep.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ep.ep.dao.orderitem.OrderItemDao;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.service.OrderItemService;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService{
   @Autowired
   private OrderItemDao itemdao;

@Override
public List<Orderitem> findAllOrderitem(Integer oderbase_id) {
	List<Orderitem> orderitems=itemdao.findAllOrderitem(oderbase_id);
	return orderitems;
}
   
   
}
