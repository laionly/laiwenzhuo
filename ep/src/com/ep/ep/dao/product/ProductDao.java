package com.ep.ep.dao.product;

import java.util.List;

import com.ep.ep.entity.Product;
import java.util.Map;



public interface ProductDao {
   public List<Product> findAll();
   
   public Product findProductById(Integer pid);
   
   public boolean deleteProduct(Integer pid);
   
   public boolean updateProduct(Product product);
   
   public void insertProduct(Product product);
   
   public List<Product> pageProduct(Map<String, Object> params);
   
   public int productCount();

   public List<Product> findProductByName(Map<String, Object> params);

   public  int productCountByName(String name);


}
