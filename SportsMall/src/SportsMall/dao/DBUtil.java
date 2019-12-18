package SportsMall.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getCon(){
		try{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sm?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false","root","12570071");
			return con;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
