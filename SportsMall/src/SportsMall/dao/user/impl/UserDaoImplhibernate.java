package SportsMall.dao.user.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import SportsMall.dao.HibernateUtil;
import SportsMall.entity.User;

public class UserDaoImplhibernate {
	
	public String save(User user) {
		
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tran = session.beginTransaction();
			session.save(user);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			return null;
		} finally {
			if (null != session) {
				session.close();
			}
		}
		return null;
	}

	public void delete(int id) {
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateUtil.getCurrentSession();
			tran = session.beginTransaction();
			User user=session.get(User.class, id);
			session.delete(user);
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
	
	public boolean updata(User user){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran =session.beginTransaction();
			session.update(user);
			tran.commit();
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null !=session){
				session.close();
			}
		}return false;
	}
	
	public User select(int id){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			User user=(User)session.get(User.class, id);
			tran.commit();
			return user;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session){
				session.close();
			}
		}return null;
	}
	
	public List<User> findAll(){
		Session session=null;
		Transaction tran =null;
	
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<User> query= session.createQuery("from User");
			List<User> list = query.getResultList();
			tran.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session);
			session.close();
		}
		return null;
	}

}
