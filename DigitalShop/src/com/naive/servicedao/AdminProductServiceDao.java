package com.naive.servicedao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;

public interface AdminProductServiceDao {
	/**
	 * 	添加商品
	 * @param product
	 * @return
	 */
	public boolean addProduct(Product product);
	/**
	 * 	查询全部商品
	 * @return
	 */
	public List<Product> findAllProduct();
	/**
	 * 	删除商品
	 * @param productid 商品id
	 * @param path 商品图片路径
	 * @return true成功，false失败
	 */
	public boolean DelProduct(int productid, String path);
	/**
	 * 	修改商品
	 * @param product 商品实体类
	 * @return true成功，false失败
	 */
	public boolean UpdateProduct(Product product);
	/**
	 * 	修改商品时对图片操作
	 * @param product 商品实体类
	 * @param file 上传的文件
	 * @param path 文件上传的路径
	 * @return true成功，false失败
	 */
	public boolean UpProduct(Product product, MultipartFile file, String path);
	/**
	 * 	查询单个商品
	 * @param productid
	 * @return
	 */
	public Product selProduct(int productid);
	/**
	 * 	商品分页
	 * @param pageNum 当前页
	 * @return
	 */
	public Page<Product> ProductPage(int pageNum);
}
