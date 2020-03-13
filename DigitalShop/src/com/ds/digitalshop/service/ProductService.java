package com.ds.digitalshop.service;

import java.util.List;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;

public interface ProductService {
  public List<Product> findAll();
  
  public Product selectproduct(Integer productid);
  
  public Page<Product> productpage(int pageNum);
  
 
}
