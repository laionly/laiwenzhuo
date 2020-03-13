package com.ds.digitalshop.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.dao.ProductDao;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Product> findAll() {
		try {
			String hql = "from Product";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	//根据ID查询商品 用来实现购物车
	public Product selectproduct(Integer productid){
		try{
			String hql="from Product where productid=?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, productid);
			Product product=(Product)query.uniqueResult();
			return product;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> productpage(Page<Product> page) {
	    try{
	    	String hql="from Product";
	    	Query<?> query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
			query.setMaxResults(page.getPageSize());
			return (List<Product>) query.list();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return null;
	}

	@Override
	public Integer findProductCount() {
		String hql = "select count(*) from Product as product";
		Long long1 = (Long) this.sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		return long1.intValue();
		}
	
	}
	

