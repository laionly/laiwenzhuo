package com.ds.digitalshop.dao;

import java.util.List;

import com.ds.digitalshop.entity.Order;

public interface OrderDao {
  public void addOrder(Order order);
  
  public List<Order> selectOrder(int productid);
  
  public Order selectOneOrder(int orderid);

}
