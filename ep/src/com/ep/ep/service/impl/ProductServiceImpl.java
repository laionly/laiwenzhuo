package com.ep.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ep.ep.dao.product.ProductDao;
import com.ep.ep.entity.Product;
import com.ep.ep.service.ProductService;
import com.ep.ep.util.FileAccepterUtil;

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
	public boolean UpProduct(Product product, MultipartFile file, String path) {
		FileAccepterUtil accepterUtil = new FileAccepterUtil();
		if (file.getOriginalFilename()==null||file.getOriginalFilename()=="") {
			return updateProduct(product);
		}else {
			String fileName = accepterUtil.FileUpload(file, path);
			if (fileName!=null && accepterUtil.FileDelete(path, product.getPicture())) {
				product.setPicture(fileName);
				return updateProduct(product);
			}else {
				return false;
			}
		}
	}

}
