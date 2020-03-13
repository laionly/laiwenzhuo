package com.naive.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;
import com.naive.dao.AdminProductDao;
/**
 *商品实现类
 * @author Naive
 * @date 2019年12月23日
 */
@Repository
public class AdminProductDaoImpl implements AdminProductDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Integer addProduct(Product product) {
		return (Integer) getSession().save(product);
	}

	@Override
	public boolean DeleteProduct(Product product) {
		getSession().delete(product);
		return true;
	}

	@Override
	public Integer UpdateProduct(Product product) {
		String hql = "update Product p set p.name=:name, p.description=:description, p.listimg=:listimg, p.price=:price, p.discountprice=:discountprice where p.productid=:productid";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("name", product.getName());
		query.setParameter("description", product.getDescription());
		query.setParameter("listimg", product.getListimg());
		query.setParameter("price", product.getPrice());
		query.setParameter("discountprice", product.getDiscountprice());
		query.setParameter("productid", product.getProductid());
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> ProductPager(Page<Product> page) {
		String hql = "from Product";
		Query<?> query = getSession().createQuery(hql);
		query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return (List<Product>) query.list();
	}

	@Override
	public Integer findProductCount() {
		String hql = "select count(*) from Product as product";
		Long long1 = (Long) getSession().createQuery(hql).uniqueResult();
		return long1.intValue();
	}

	@Override
	public Product selProduct(int productid) {
		String hql = "from Product as p where p.productid=?";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter(0, productid);
		return (Product) query.uniqueResult();
	}

}
