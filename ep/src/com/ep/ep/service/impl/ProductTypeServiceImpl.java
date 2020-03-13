package com.ep.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ep.ep.entity.Product_type;
import com.ep.ep.dao.producttype.ProductTypeDao;
import com.ep.ep.service.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {
	@Autowired
	private ProductTypeDao productTypeDao;

	@Override
	public void deleteProductType(Integer ptid) {
	   productTypeDao.deleteProductType(ptid);
 
	}

	@Override
	public void saveProductType(Product_type product_type) {
		productTypeDao.saveProductType(product_type);

	}

	@Override
	public Product_type findProductType(Integer ptid) {
		Product_type product_type=productTypeDao.findProductType(ptid);
		return product_type;
	}

	@Override
	public List<Product_type> findAllProducttype() {
		List<Product_type> list=productTypeDao.findAllProducttype();
		return list;
	}

}
