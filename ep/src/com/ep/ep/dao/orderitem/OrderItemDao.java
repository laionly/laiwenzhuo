package com.ep.ep.dao.orderitem;

import java.util.List;

import com.ep.ep.entity.Orderitem;

public interface OrderItemDao {
  public List<Orderitem> findAllOrderitem(Integer oderbase_id);
}
