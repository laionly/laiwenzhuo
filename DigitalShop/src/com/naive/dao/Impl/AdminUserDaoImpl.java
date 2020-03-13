package com.naive.dao.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;
import com.naive.dao.AdminUsersDao;
/**
 * 	管理用户类
 * @author Naive
 * @date 2020年1月1日
 */
@Repository
public class AdminUserDaoImpl implements AdminUsersDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> UsersPageList(Page<User> page) {
		String hql = "from User";
		Query<?> query = getSession().createQuery(hql);
		query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return (List<User>) query.list();
	}

	@Override
	public Integer findUsersCount() {
		String hql = "select count(*) from User as user";
		Long long1 = (Long) getSession().createQuery(hql).uniqueResult();
		return long1.intValue();
	}

	@Override
	public boolean DelUsers(User user) {
		getSession().delete(user);
		return true;
	}

	@Override
	public Integer UpdateUserPassword(int id, String password) {
		String hql = "update User u set u.password=? where u.userid=?";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter(0, password);
		query.setParameter(1, id);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> userQueryList(Page<User> page, String username) {
		String hql = "from User u where u.username like :neme";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("neme", "%"+username+"%");
		query.setFirstResult((page.getPageNum()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return (List<User>) query.list();
	}

	@Override
	public Integer userQueryCount(String username) {
		String hql = "select count(*) from User as u where u.username like :neme";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("neme", username);
		Long long1 = (Long) query.uniqueResult();
		return long1.intValue();
	}

}
