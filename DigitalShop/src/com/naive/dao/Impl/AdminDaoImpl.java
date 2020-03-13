package com.naive.dao.Impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import com.naive.dao.AdminDao;
import com.naive.entity.Admin;
/**
 * 实现管理员接口
 * @author Naive
 * @date: 2019年12月17日 下午3:35:46
 */
@Repository
public class AdminDaoImpl implements AdminDao {
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Admin AdminLogin(String adminName, String password) {
		String hql = "from Admin where adminName = ? and password = ?";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter(0, adminName);
		query.setParameter(1, password);
		Admin admin = (Admin) query.uniqueResult();
		return admin;
	}

	@Override
	public Integer AdminUpdata(Admin admin) {
		String hql = "update Admin admin set admin.adminName=:adminName , admin.password=:password where admin.id=:id";
		Query<?> query = getSession().createQuery(hql);
		query.setParameter("adminName", admin.getAdminName());
		query.setParameter("password", admin.getPassword());
		query.setParameter("id", admin.getId());
		return query.executeUpdate();
	}

	@Override
	public Integer AdminRegister(Admin admin) {
		return (Integer) getSession().save(admin);
	}

}
