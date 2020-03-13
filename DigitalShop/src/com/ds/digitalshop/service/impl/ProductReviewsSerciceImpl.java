package com.ds.digitalshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.ProductReviewsDao;
import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.ProductReviewsService;

@Service("ProductReviewsServiceImpl")
@Transactional
public class ProductReviewsSerciceImpl implements ProductReviewsService {
	// 注入dao层
	@Autowired
	private ProductReviewsDao prdao;

	// 显示单个商品所有的评价
	@Override

	public List<Appraise> findAll(int productid) {
		List<Appraise> prList = prdao.findAll(productid);
		return prList;
	}

	// 添加商品评价
	@Override
	public void addproductreview(Appraise productreviews) {
		prdao.addproductreviews(productreviews);

	}

	// 删除商品评价
	public void delproductreview(int aid) {
		prdao.delproductreviews(aid);

	}

	@Override
	// 查询用户名
	public User getuserbyname(String name) {
		return prdao.getuserbyname(name);
	}

	// 根据id查询商品
	@Override
	public List<Product> findoneproductid(int productid) {
		return prdao.findoneproductid(productid);
	}

	// 商品模糊查询
	@Override
	public List<Product> findproduct(String name) {
		return prdao.findproduct(name);
	}
	//商品评论分页
	@Override
	public ArrayList<Appraise> FindPrPage(Page<Product> page) {
		return prdao.FindPrPage(page);
	}

	@Override
	public int findCount() {
		return prdao.findCount();
	}

}
