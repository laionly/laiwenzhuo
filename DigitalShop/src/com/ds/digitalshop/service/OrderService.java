package com.ds.digitalshop.service;

import java.util.List;

import com.ds.digitalshop.entity.Order;

public interface OrderService {
  public void addOrder(Order order);
  
  public List<Order> selectOrder(int productid);
  
  public Order selectOneOrder(int productid);
}
