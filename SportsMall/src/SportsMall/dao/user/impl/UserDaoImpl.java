package SportsMall.dao.user.impl;

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
import SportsMall.dao.user.UserDao;
import SportsMall.entity.User;


public class UserDaoImpl implements UserDao {

	@Override
	public List<User> viewUser(int id) {
		try {
			List<User> list =new ArrayList<User>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where email=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getNString(4));
				user.setAddress(rs.getNString(5));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> listUser() {
		try{
			List<User> list =new ArrayList<User>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getNString(4));
				user.setAddress(rs.getNString(5));
				list.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User selectUser(int id) {
		try {
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where id=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setPhone(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setAddress(rs.getString(5));
				return user;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//hibernate操作sql语句updateUser
	@Override
	public boolean updateUser(User user) {
		Session session=null;
		Transaction tran =null;
		try{
			session=HibernateUtil.getCurrentSession();
			tran=session.beginTransaction();
			
			session.update(user);
			
			System.out.println("user+"+user);
			
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
	
	//jdbc操作sql语句updateUser
//	@Override
//	public boolean updateUser(User user) {
//		try {
//			Connection con=DBUtil.getCon();
//			PreparedStatement pstm=con.prepareStatement("update user set username=?,password=?,phone=?,email=?,address=? where id=?");
//			pstm.setString(1, user.getUsername());
//			pstm.setString(2, user.getPassword());
//			pstm.setString(3, user.getPhone());
//			pstm.setString(4, user.getEmail());
//			pstm.setString(5, user.getAddress());
//			pstm.setLong(6, user.getId());
//			int result=pstm.executeUpdate();
//			if(result>0){
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	// hibernate 操作sql 删除用户deleteUser
	
		@Override
		public boolean deleteUser(int id) {
			
			Session session = null;
			Transaction tran = null;
			User user = null;
			try{
				session = HibernateUtil.getCurrentSession();
				tran = session.beginTransaction();
				
				user = session.get(User.class, id);	
				session.delete(user);
				
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
	
		// jdbc 操作sql 删除用户deleteUser
//	@Override
//	public boolean deleteUser(int id) {
//		try {
//			Connection con = DBUtil.getCon();
//			PreparedStatement pstm = con.prepareStatement("delete from user where id=?");
//			pstm.setInt(1, id);
//			pstm.execute();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
		
		//hibernate操作sql登录
		public User login(String username,String password){
				
			//one 设置Session，创建工厂Transaction
				Session session=null;
				Transaction tran =null;
				User user=null;
				try{
					session=HibernateUtil.getCurrentSession();
					tran=session.beginTransaction();
				
					//查找表中id
//					Query query=session.createQuery("select * from user where id=?");
//					query.setParameter(0, id);
					
					Query query = session.createQuery("from User where username=? and password=?");
					
					
					query.setParameter(0, username);
					query.setParameter(1, password);
					
					
					user = (User) query.uniqueResult();

					System.out.println("user+"+user);   //测试user
					
					tran.commit();
					
					//返回对象user
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
	
		//jdbc操作sql登录login
//	@Override
//	public User login(String username, String password) {
//		
//		try{
//			Connection con=DBUtil.getCon();
//			PreparedStatement pstm=con.prepareStatement("select * from user where username=? and password=?");
//			pstm.setString(1, username);
//			pstm.setString(2, password);
//			ResultSet rs=pstm.executeQuery();
//			User user=null;
//			while(rs.next()){
//				user=new User();
//				
//				user.setId(rs.getInt(1));
//				user.setUsername(rs.getString(2));
//				user.setPassword(rs.getString(3));
//				user.setPhone(rs.getString(4));
//				user.setEmail(rs.getString(5));
//				user.setAddress(rs.getString(6));
//				user.setCode(rs.getInt(7));
//			}
//			return user;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
	

}
