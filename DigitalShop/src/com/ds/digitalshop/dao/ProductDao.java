package com.ds.digitalshop.dao;

import java.util.List;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;

public interface ProductDao {
  public List<Product> findAll();//查询所有商品
  
  public Product selectproduct(Integer productid);//根据ID查询商品
  
  public List<Product> productpage(Page<Product> page);//实现分页
  
  public Integer findProductCount();//查询总数据
  
 
}
