package com.skishop.dao.product.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skishop.dao.DBUtil;
import com.skishop.dao.product.ProductDao;
import com.skishop.entity.Product;

public class ProductDaoImpl implements ProductDao{

	public List<Product> findAll(){
		try{
			List<Product> list=new ArrayList<Product>();
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product_1012");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrince(rs.getInt(5));
				p.setDiscountprince(rs.getInt(6));
				list.add(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveProduct(Product product) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into product_1012(id,name,description,listimg,price,discountprice) values(?,?,?,?,?,?)");
			pstm.setInt(1, product.getId());
			pstm.setString(2, product.getName());
			pstm.setString(3, product.getDescription());
			pstm.setString(4, product.getListimg());
			pstm.setInt(5, product.getPrince());
			pstm.setInt(6, product.getDiscountprince());
			pstm.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
	    try{
	    	Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from product_1012 where id=?");
			pstm.setInt(1, id);
			pstm.execute();
	    }catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try{
			
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("update product_1012 set name=?,description=?,price=?,discountprice=? where id=?");
			pstm.setString(1,product.getName());
			pstm.setString(2, product.getDescription());
			pstm.setInt(3, product.getPrince());
			pstm.setInt(4, product.getDiscountprince());
			pstm.setInt(5, product.getId());
			int result=pstm.executeUpdate();
			if(result>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		return false;
	}

	@Override
	public Product selectProduct(int id) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product_1012 where id=?");
			pstm.setInt(1,id);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrince(rs.getInt(5));
				p.setDiscountprince(rs.getInt(6));
				return p;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return null;
	}
	/*
	 * 实现分页功能
	 * pageNum:第几页，当前页
	 * pageSize:每页显示几条
	 */

	@Override
	public List<Product> findProductByPage(int pageNum, int pageSize) {
		try{
			List<Product> list=new ArrayList<Product>();
			Connection con=DBUtil.getCon();
			//mysql数据库中使用limit关键字进行分页,它有两个参数,第一个参数是起始位置,第二个参数是每页显示几条;
			PreparedStatement pstm=con.prepareStatement("select * from product_1012 limit ?,?");
			pstm.setInt(1, (pageNum-1)*pageSize);//(pageNum-1)*pageSize:起始位置
			pstm.setInt(2, pageSize);//pageSize:每页显示几条
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrince(rs.getInt(5));
				p.setDiscountprince(rs.getInt(6));
				list.add(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 获取总条数
	 */

	@Override
	public int findCount() {
		int result=0;
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select count(*) from product_1012");
			ResultSet rs=pstm.executeQuery();
			
			while(rs.next()){
				result = rs.getInt(1);//获取数据库第一个字段
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
