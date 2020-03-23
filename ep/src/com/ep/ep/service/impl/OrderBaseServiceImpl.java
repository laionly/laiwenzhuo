package com.ep.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ep.ep.dao.orderbase.OrderBaseDao;
import com.ep.ep.entity.Orderbase;

import com.ep.ep.service.OrderBaseService;
@Service
@Transactional
public class OrderBaseServiceImpl implements OrderBaseService{
    
	@Autowired
	private OrderBaseDao obd;
	@Override
	public List<Orderbase> findOrderbase() {
		List<Orderbase> orderbase=obd.findOrderbase();
		return orderbase;
	}

}
