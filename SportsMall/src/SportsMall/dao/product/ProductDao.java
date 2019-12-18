package SportsMall.dao.product;

import java.util.List;

import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;


public interface ProductDao {
	public List<Product_zuqiu> findAll_zuqiu();
	public List<Product> finAll_lanqiu();
	public List<Product> finAll_yumaoqiu();
	public List<Product> finAll_pingpangqiu();
	public Product_zuqiu selectProduct_zq(int id);

}
