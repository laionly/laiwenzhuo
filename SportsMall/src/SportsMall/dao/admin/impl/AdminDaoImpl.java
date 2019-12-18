package SportsMall.dao.admin.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SportsMall.dao.DBUtil;
import SportsMall.dao.HibernateUtil;
import SportsMall.dao.admin.AdminDao;

import SportsMall.entity.Myadmin;

public class AdminDaoImpl implements AdminDao {
	
	
	// hibernate 操作sql语句管理员 登录
		@Override
		public Myadmin adminmessage(String loginname, String password) {
			
			Session session = null;
			Transaction tran = null;
			Myadmin admin = null;
			
			try{
				session = HibernateUtil.getCurrentSession();
				tran = session.beginTransaction();
				
				//当使用myadmin时 报错：myadmin is not mapped [from myadmin where loginname=? and password=?]
				//原因myadmin未映射；；及实体类中映射文件设置是 Myadmin；而不是myadmin
				//Query query = session.createQuery("from myadmin where loginname=? and password=?");
				
				Query query = session.createQuery("from Myadmin where loginname=? and password=?");
				
			     query.setParameter(0, loginname);
			     query.setParameter(1, password);
			     
			     admin = (Myadmin) query.uniqueResult();
			     
			     System.out.println("admin+"+admin);
			     
			     tran.commit();
			     
			     return admin;
			     
			}catch(Exception e){
				e.printStackTrace();
				tran.rollback();
			}finally{
				if(session != null){
					session.close();
				}
			}
			return null;
		}
	
	
	// jdbc 操作sql语句管理员 登录
//		@Override
//		public Myadmin adminmessage(String username, String password) {
//			try{
//				Connection con=DBUtil.getCon();
//				PreparedStatement pstm=con.prepareStatement("select * from myadmin where loginname=? and password=?");
//				pstm.setString(1, username);
//				pstm.setString(2, password);
//				ResultSet rs=pstm.executeQuery();
//				Myadmin user=null;
//				while(rs.next()){
//					user=new Myadmin();
//					user.setId(rs.getInt(1));
//					user.setLoginname(rs.getString(2));
//					user.setPassword(rs.getString(3));
//					user.setPhone(rs.getString(4));
//					user.setEmail(rs.getString(5));
//					user.setAddress(rs.getString(6));
//					user.setCode(rs.getInt(7));
//				//	System.out.println(user);
//				}
//				return user;
//			}catch(Exception e){
//				e.printStackTrace();
//				return null;
//			}
//			
//		}
	
		// hibernate 操作sql语句updateAdmin
//		@Override
//		public boolean updateAdmin(Myadmin admin) {
//			Session session=null;
//			Transaction tran =null;
//			try{
//				session=HibernateUtil.getCurrentSession();
//				tran=session.beginTransaction();
//				
//				session.update(admin);
//				
//				System.out.println("user+"+admin.getCode());
//				
//				tran.commit();
//				
//			}catch(Exception e){
//				e.printStackTrace();
//				tran.rollback();
//			}finally{
//				if(null!=session){
//					session.close();
//				}
//			}return false;
//		}
		
		// jdbc 操作sql语句 updateAdmin
	@Override
	public boolean updateAdmin(Myadmin admin) {
		try {
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("update myadmin set loginname=?,password=?,phone=?,email=?,address=? where id=?");
			
			pstm.setString(1, admin.getLoginname());
			pstm.setString(2, admin.getPassword());
			pstm.setString(3, admin.getPhone());
			pstm.setString(4, admin.getEmail());
			pstm.setString(5, admin.getAddress());
			pstm.setLong(6, admin.getId());
			int result=pstm.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// hibernate 操作sql语句 deleteAdmin
	
		@Override
		public boolean deleteAdmin(int id) {
		     Session session = null;
		     Transaction tran = null;
		     Myadmin admin = null;
		     try{
		    	 
		    	 session = HibernateUtil.getCurrentSession();
		    	 tran = session.beginTransaction();
		    	 
		    	 admin = session.get(Myadmin.class, id);
		    	 
		    	 session.delete(admin);
		    	 
		    	 tran.commit();
		    	 
		     }catch(Exception e){
		    	 e.printStackTrace();
		    	 tran.rollback();
		     }finally{
		    	 if(session != null){
		    		 session.close();
		    	 }
		     }
		     return false;
		}
	
		// jdbc 操作sql语句 deleteAdmin
//	@Override
//	public boolean deleteAdmin(int id) {
//		try {
//			Connection con = DBUtil.getCon();
//			PreparedStatement pstm = con.prepareStatement("delete from myadmin where id=?");
//			pstm.setInt(1, id);
//			pstm.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	

}
