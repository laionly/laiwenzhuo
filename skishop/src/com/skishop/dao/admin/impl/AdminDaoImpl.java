package com.skishop.dao.admin.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skishop.dao.DBUtil;
import com.skishop.dao.admin.AdminDao;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean AdminLogin(String email, String password) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from admin where email=? and password=?");
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rSet=pstm.executeQuery();
			if(rSet.next()){
				//表示获取到符合条件的数据库表记录 即登录成功
				return true;
			}else {
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

}
