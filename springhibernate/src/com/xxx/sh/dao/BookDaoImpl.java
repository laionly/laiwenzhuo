package com.xxx.sh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xxx.sh.exception.AccountException;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public double findBookPriceByIsbn(String isbn) {
		String hql = "select price from Book where isbn=?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, isbn);
		// 返回对象
		double result = (double) query.uniqueResult();
		// 返回值
		// double price = (double)
		// this.getSession().createQuery(hql).setString(0, isbn).uniqueResult();
		return result;
	}

	@Override
	public void updateBookStock(String isbn) {
		// 验证书的库存是否充足
		String hql2 = "select stock from Book where isbn=?";
		int stock = (int) this.getSession().createQuery(hql2).setString(0, isbn).uniqueResult();
		if (stock == 0) {
			System.out.println("书的库存不足");
		}
		String hql = "update Book set stock=stock-1 where isbn=?";
		this.getSession().createQuery(hql).setString(0, isbn).executeUpdate();
	}

	@Override
	public void updateMoney(String name, double price) {
		// 验证用户余额是否充足
		String hql2 = "select money from Account where name=?";
		double money = (double) this.getSession().createQuery(hql2).setString(0, name).uniqueResult();
		System.out.println(price);
		System.out.println(money);
		if (money < price && money > 0) {
			System.out.println("余额不足");
			throw new AccountException("余额不足");
		}
		String hql = "update Account set money=money-? where name=?";
		this.getSession().createQuery(hql).setDouble(0, price).setString(1, name).executeUpdate();

	}

}
