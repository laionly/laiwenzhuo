package SportsMall.dao.product.impl;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.List;

import org.hibernate.Session;

import SportsMall.dao.HibernateUtil;
import SportsMall.entity.Myadmin;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;

public class ProductDaoImplhibernate {
	public void delete(int id) {
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tran = session.beginTransaction();
			Product_zuqiu product=session.get(Product_zuqiu.class, id);
			session.delete(product);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			if (null != session) {
				session.close();
			}
		}
	}
	
	public boolean updata(Product_zuqiu product){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			session.update(product);
			tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session){
				session.close();
			}
		}return false;
	}
	
	public Product_zuqiu Select(int id){
		Session session=null;
		Transaction tran=null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			Product_zuqiu product=(Product_zuqiu)session.get(Product_zuqiu.class, id);
			tran.commit();
			return product;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session){
				session.close();
			}
		}return null;
	}
	
	public List<Product_zuqiu> select(String name){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			Query query = session.createQuery("from Product_zuqiu product where product.like :Name");
			query.setParameter("Name", name + "%");
			List<Product_zuqiu> products=query.list();
			return products;
		}catch(Exception e){
			e.printStackTrace();
		}return null;
  }
	public List<Product_zuqiu> finAll(){
		Session session=null;
		Transaction tran =null;
//		Query query=null;
		try {
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			
			Query<Product_zuqiu> query=session.createQuery("from Product_zuqiu");
			List<Product_zuqiu> list=query.getResultList();
			tran.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session);
			session.close();
		}
		return null;
	}
}