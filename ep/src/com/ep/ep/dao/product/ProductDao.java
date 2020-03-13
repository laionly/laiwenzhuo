package com.ep.ep.dao.product;

import java.util.List;

import com.ep.ep.entity.Product;

public interface ProductDao {
   public List<Product> findAll();
   
   public Product findProductById(Integer pid);
   
   public boolean deleteProduct(Integer pid);
   
   public boolean updateProduct(Product product);
   
   public void insertProduct(Product product);
}
