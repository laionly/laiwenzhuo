package com.naive.servicedao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ds.digitalshop.dao.ProductDao;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.naive.dao.AdminProductDao;
import com.naive.servicedao.AdminProductServiceDao;
import com.naive.util.FileAccepterUtil;
/**
 *管理员商品Service 
 * @author Naive
 * @date 2019年12月23日
 */
@Service
@Transactional
public class AdminProductServiceDaoImpl implements AdminProductServiceDao {
	@Resource
	private AdminProductDao adminProductDao;
	@Resource
	private ProductDao productDao;
	
	@Override
	public boolean addProduct(Product product) {
		try {
			if (adminProductDao.addProduct(product)!=0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public List<Product> findAllProduct() {
		try {
			return productDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean DelProduct(int productid, String path) {
		try {
			Product product = productDao.selectproduct(productid);
			FileAccepterUtil accepterUtil = new FileAccepterUtil();
			//删除商品同时删除本地图片
			if (adminProductDao.DeleteProduct(product) && accepterUtil.FileDelete(path, product.getListimg())) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public boolean UpdateProduct(Product product) {
		if (adminProductDao.UpdateProduct(product)!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean UpProduct(Product product, MultipartFile file, String path) {
		FileAccepterUtil accepterUtil = new FileAccepterUtil();
		if (file.getOriginalFilename()==null||file.getOriginalFilename()=="") {
			return UpdateProduct(product);
		}else {
			String fileName = accepterUtil.FileUpload(file, path);
			if (fileName!=null && accepterUtil.FileDelete(path, product.getListimg())) {
				product.setListimg(fileName);
				return UpdateProduct(product);
			}else {
				return false;
			}
		}
	}

	@Override
	public Product selProduct(int productid) {
		try {
			return productDao.selectproduct(productid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Page<Product> ProductPage(int pageNum) {
		try {
			Page<Product> page = new Page<>(pageNum, 5);
			page.setTotalCount(adminProductDao.findProductCount());
			page.setList(adminProductDao.ProductPager(page));
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
