package com.ds.digitalshop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.dao.ProductReviewsDao;
import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Product;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.entity.Page;

@Repository
public class ProductReviewsDaoImpl implements ProductReviewsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// 添加商品评价
	@Override
	public void addproductreviews(Appraise productreviews) {
		this.getSession().save(productreviews);

	}

	// 删除商品评价
	@Override
	public void delproductreviews(int aid) {
		try {
			String hql = "delete from Appraise where aid=?";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, aid);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 显示单个商品所有的评价
	@Override
	public List<Appraise> findAll(int productid) {
		try {

			String hql = "from Appraise where productid=?";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, productid);
			List<Appraise> prlist = query.list();
			System.out.println(prlist);
			return prlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 查询用户名
	@Override
	public User getuserbyname(String name) {
		try {
			System.out.println(name);
			String hql = "from User where username=?";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, name);
			User user = (User) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 根据商品id查询商品
	@Override
	public List<Product> findoneproductid(int productid) {
		try {
			String hql = "from Product where productid=?";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, productid);
			List<Product> lp = query.list();
			return lp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 商品模糊查询
	@Override
	public List<Product> findproduct(String name) {
		try {
			String hql = "from Product where name like '%" + name + "%'";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> lp = query.list();
			return lp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
//商品评论分页
	@Override
	public ArrayList<Appraise> FindPrPage(Page<Product> page) {
		try {
			String hql = "from Appraise ";
			Query<?> query = getSession().createQuery(hql);
			query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
			query.setMaxResults(page.getPageSize());
			return (ArrayList<Appraise>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public int findCount() {
		try {
			String hql = "select count(*) from Appraise as appraise";
			Long long1 = (Long) getSession().createQuery(hql).uniqueResult();
			return long1.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
