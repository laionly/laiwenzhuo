package com.ds.digitalshop.service;

import java.util.ArrayList;
import java.util.List;

import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;

public interface ProductReviewsService {
	// 显示商品评价
	public List<Appraise> findAll(int productid);

	// 添加商品评价
	public void addproductreview(Appraise productreviews);

	// 添加商品评价
	public void delproductreview(int aid);

	// 查询用户名
	public User getuserbyname(String name);

	// 根据商品id查询商品
	public List<Product> findoneproductid(int productid);

	// 商品模糊查询
	public List<Product> findproduct(String name);
	
	//商品评论分页
	public ArrayList<Appraise> FindPrPage(Page<Product> page);
		
	//查询单个商品评论总数
	public int findCount();

}
