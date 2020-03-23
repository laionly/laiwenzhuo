package com.ep.ep.service;

import java.util.List;

import com.ep.ep.entity.Orderitem;

public interface OrderItemService {
  public List<Orderitem> findAllOrderitem(Integer oderbase_id);
}
