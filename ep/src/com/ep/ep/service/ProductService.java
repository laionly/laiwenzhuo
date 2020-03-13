package com.ep.ep.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ep.ep.entity.Product;

public interface ProductService {
	 public List<Product> findAll();
	   
	   public Product findProductById(Integer pid);
	   
	   public boolean deleteProduct(Integer pid,String path);
	   
	   public boolean updateProduct(Product product);
	   
	   public boolean UpProduct(Product product, MultipartFile file, String path);
	   
	   public void insertProduct(Product product);
}
