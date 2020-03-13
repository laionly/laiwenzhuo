package com.ds.digitalshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.ProductDao;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.service.ProductService;

@Service("pserviceImpl")
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> findAll() {
		List<Product> list = productDao.findAll();
		return list;
	}
	
	@Override
	public Product selectproduct(Integer productid){
		Product product =productDao.selectproduct(productid);
		return product;
	}

	@Override
	public Page<Product> productpage(int pagenum) {
	       try{
	    	   Page<Product> page = new Page<>(pagenum,3);
	    	   page.setTotalCount(productDao.findProductCount());
	    	   page.setList(productDao.productpage(page));
	    	   return page;
	       }catch(Exception e){
	    	   e.printStackTrace();
	       }
			return null;
		}
		
	}

