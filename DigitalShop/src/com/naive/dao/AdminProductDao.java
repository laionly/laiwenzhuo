package com.naive.dao;

import java.util.List;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
/**
 * 管理员商品类
 * @author Naive
 * @date: 2019年12月23日 下午4:34:17
 */
public interface AdminProductDao {
	/**
	 * 增加商品
	 * @param product
	 * @return 新增商品的主键
	 */
	public Integer addProduct(Product product);
	/**
	 * 删除商品
	 * @param productid 商品id
	 * @return
	 */
	public boolean DeleteProduct(Product product);
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	public Integer UpdateProduct(Product product);
	/**
	 * 商品分页
	 * @return
	 */
	public List<Product> ProductPager(Page<Product> page);
	/**
	 * 查询总数据
	 * @return
	 */
	public Integer findProductCount();
	/**
	 * 查询单个商品
	 * @param id 商品id
	 * @return
	 */
	public Product selProduct(int productid);
}
