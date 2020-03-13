package com.ds.digitalshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.dao.CollectDao;
import com.ds.digitalshop.entity.Collect;

@Repository
public class CollectDaoImpl implements CollectDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCollect(Collect collect) {
		try {
		 this.getsession().save(collect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCollect(int cid) {
		try {
			String hql = "delete from Collect where cid=?";
			Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, cid);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Collect> selectCollect() {
		try{
			String hql="from Collect";
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			List<Collect> collect=query.list();
			return collect;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collect selectCollect(int userid,int productid) {
		try{
			String hql="from Collect where userid=? and productid=?";
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			query.setParameter(0, userid);
			query.setParameter(1, productid);
			Collect collect=(Collect)query.uniqueResult();
			return collect;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
