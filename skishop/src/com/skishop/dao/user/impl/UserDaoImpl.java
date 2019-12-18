package com.skishop.dao.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skishop.dao.DBUtil;
import com.skishop.dao.user.UserDao;
import com.skishop.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into user(surname,name,email,password) values(?,?,?,?)");
			pstm.setString(1, user.getSurname());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getPassword());
			pstm.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean UsersLogin(String email, String password) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where email=? and password=?");
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rSet=pstm.executeQuery();
			if(rSet.next()){
				//表示获取到符合条件的数据库表记录 即登录成功
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("update user set surname=?,name=?,password=? where email=?");
			pstm.setString(1, user.getSurname());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getEmail());
			int result=pstm.executeUpdate();
//			System.out.println(user);
			if(result>0){
				System.out.println(user);
				return true;
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User selectUser(String email) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where email=?");
			pstm.setString(1, email);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setSurname(rs.getString(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				return user;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> viewUser(String email) {
		try{
			List<User> list =new ArrayList<User>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where email=?");
			pstm.setString(1, email);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setSurname(rs.getString(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				list.add(user);
			}
			return list;
		}catch(Exception e){
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
				user.setSurname(rs.getString(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setId(rs.getInt(5));
				list.add(user);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUser(String email) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from user where email=?");
			pstm.setString(1, email);
			pstm.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
