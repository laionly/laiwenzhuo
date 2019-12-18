package SportsMall.dao.admin.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SportsMall.dao.HibernateUtil;
import SportsMall.entity.Myadmin;

public class AdminDaoImplhibernate {
   public String save(Myadmin admin){
	   Session session=null;
	   Transaction tran =null;
	   try{
		   session=HibernateUtil.getCurrentSession();
		   tran=session.beginTransaction();
		   session.save(admin);
		   tran.commit();
	   }catch(Exception e){
		   e.printStackTrace();
		   tran.rollback();
	   }finally{
		   if(null!=session){
			   session.close();
		   }
	   }
	   return null;
   }
   
   public boolean updata(Myadmin admin){
	   Session session=null;
	   Transaction tran=null;
	   try{
		   session=HibernateUtil.getCurrentSession();
		   tran=session.beginTransaction();
		   session.update(admin);
		   tran.commit(); 
	   }catch(Exception e){
		   e.printStackTrace();
		   tran.rollback();
	   }finally{
		   if(null!=session){
			   session.close();
		   }
	   }
	   return false;
   }
   
   public void delete(int id){
	   Session session=null;
	   Transaction tran=null;
	   try{
		   session=HibernateUtil.getCurrentSession();
		   tran=session.beginTransaction();
		   Myadmin admin=session.get(Myadmin.class, id);
		   session.delete(admin);
		   tran.commit();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   if(null!=session){
			   session.close();
		   }
	   }
   }
   
   public Myadmin select(int id){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			Myadmin admin=(Myadmin)session.get(Myadmin.class, id);
			tran.commit();
			return admin;
		}catch(Exception e){
			e.printStackTrace();
			tran.rollback();
		}finally{
			if(null!=session){
				session.close();
			}
		}return null;
	}
	
	public List<Myadmin> findAll(){
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			Query<Myadmin> query= session.createQuery("from Myadmin");
//			CriteriaQuery<Myadmin> criteriaQuery = session.getCriteriaBuilder().createQuery(Myadmin.class);
			
			List<Myadmin> list =  query.getResultList();
//			for (Myadmin admin : list) {
//				System.out.println(admin);
//			}
//			Myadmin myadmin = session.get(Myadmin.class, 1);
//			List<Myadmin> myadmins = new ArrayList<>();
//			myadmins.add(myadmin);
			tran.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			//tran.rollback();
		}finally{
			if(null!=session);
			session.close();
		}
		return null;
	}
}
