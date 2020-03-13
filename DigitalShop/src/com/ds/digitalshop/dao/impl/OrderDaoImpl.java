package com.ds.digitalshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.digitalshop.dao.OrderDao;
import com.ds.digitalshop.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao{
	@Autowired
	private SessionFactory sessionFactory;

	public Session getsession() {
		return sessionFactory.getCurrentSession();
	}
 @Override
  public void addOrder(Order order){
	 try{
		this.getsession().save(order);
	 }catch(Exception e){
		 e.printStackTrace();
	 }
 }
@Override
public List<Order> selectOrder(int productid) {
	try{
		String hql="from Order";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, productid);
		List<Order> order=query.list();
		return order;
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}
@Override
public Order selectOneOrder(int orderid) {
	try{
		String hql="from Order where orderid=?";
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, orderid);
		Order order=(Order)query.uniqueResult();
		return order;
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}
}
