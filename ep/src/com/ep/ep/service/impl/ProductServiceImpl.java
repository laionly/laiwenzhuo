package com.ep.ep.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ep.ep.dao.product.ProductDao;
import com.ep.ep.entity.Product;
import com.ep.ep.service.ProductService;
import com.ep.ep.util.FileAccepterUtil;
import java.util.Map;



@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		List<Product> products=productDao.findAll();
		return products;
	}

	@Override
	public Product findProductById(Integer pid) {
	Product product=productDao.findProductById(pid);
		return product;
	}

	@Override
	public boolean deleteProduct(Integer pid,String path) {
		try {
			Product product = productDao.findProductById(pid);
			FileAccepterUtil accepterUtil = new FileAccepterUtil();
			//删除商品同时删除本地图片
			if (productDao.deleteProduct(pid) && accepterUtil.FileDelete(path, product.getPicture())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		productDao.updateProduct(product);
			return true;	
	}

	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);

	}

	@Override
	public boolean UpProduct(Product product, MultipartFile mf, String path)  {
		FileAccepterUtil accepterUtil = new FileAccepterUtil();
		if (mf.getOriginalFilename()==null||mf.getOriginalFilename()=="") {
			return updateProduct(product);
		}else {
			String fileName = accepterUtil.FileUpload(mf, path);
			if (fileName!=null && accepterUtil.FileDelete(path, product.getPicture())) {
				product.setPicture(fileName);;
				return updateProduct(product);
			}else {
				return false;
			}
		}
		
	}

	@Override
	public List<Product> pageProduct(Map<String, Object> params) {
		List<Product> products=productDao.pageProduct(params);
		return products;
	}

	@Override
	public int productCount() {
		int productCount=productDao.productCount();
		return productCount;
	}

	@Override
	public List<Product> findProductByName(Map<String, Object> params) {
		List<Product> products=productDao.findProductByName(params);
		return products;
	}

	@Override
	public int productCountByName(String name) {
		int count=productDao.productCountByName(name);
		return count;
	}


}
