package com.ds.digitalshop.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.dao.UserDao;
import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addUser(User user) {
		getSession().save(user);

	}

	@Override
	public User Userlogin(String username, String password) {
		try {
			String hql="from User where username=? and password=?";
			Query<?> query=getSession().createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, password);
			User user = (User) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 
	}

	@Override
	public User findUserByid(int userid) {
		String hql="from User where userid=?";
		Query<?> query=getSession().createQuery(hql);
		query.setParameter(0, userid);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public User updateUser(User user) {
		getSession().update(user);
		return user;
	}

	@Override
	public User findUserByUE(String username, String email) {
		try {
			String hql="from User where username=? and email=?";
			Query<?> query=getSession().createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, email);
			User user = (User) query.uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public User updatehead_portrait(String head_portrait,int userid) {
		try {
			String hql="update User set head_portrait=? where userid=?";
			Query<?> query=getSession().createQuery(hql);
			query.setParameter(0, head_portrait);
			query.setParameter(1, userid);
			query.executeUpdate();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public User removeUserCollectbycid(int cid) {
		try {
			String sql="delete from collect where cid=?";
			getSession().createSQLQuery(sql).setInteger(0, cid).executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Integer findOrderCount(int userid) {
		String hql="select count(*) from Order as order where userid=?";
		Query<?> query=getSession().createQuery(hql);
		query.setParameter(0, userid);
		Long long1=(Long)query.uniqueResult();
		return long1.intValue();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> OrderPager(Page<Order> page,int userid) {
		String hql="from Order where userid=?";
		Query<?> query=getSession().createQuery(hql);
		query.setParameter(0, userid);
		query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return (List<Order>) query.list();
	}

	

}
