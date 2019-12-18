package com.skishop.dao.product;

import java.util.List;
import com.skishop.entity.Product;

public interface ProductDao {
	public List<Product> findAll();// 查询商品

	public boolean saveProduct(Product product);// 添加商品

	public boolean deleteProduct(int id);// 删除商品

	public boolean updateProduct(Product product);// 修改商品

	public Product selectProduct(int id);// 根据id查询对应的商品
	
	public List<Product> findProductByPage(int pageNum,int pageSize);
	public int findCount();//获取数据库总条数

}
