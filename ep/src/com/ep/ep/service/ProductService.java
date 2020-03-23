package com.ep.ep.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ep.ep.entity.Product;
import java.util.Map;



public interface ProductService {
	 public List<Product> findAll();
	   
	   public Product findProductById(Integer pid);
	   
	   public boolean deleteProduct(Integer pid,String path);
	   
	   public boolean updateProduct(Product product);
	   
	   public boolean UpProduct(Product product, MultipartFile mf, String path);
	   
	   public void insertProduct(Product product);
	   
	   public List<Product> pageProduct(Map<String, Object> params);
	   
	   public int productCount();

	   public List<Product> findProductByName(Map<String, Object> params);

	   public  int productCountByName(String name);
	   
	 
}
