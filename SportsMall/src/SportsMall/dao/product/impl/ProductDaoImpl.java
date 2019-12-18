package SportsMall.dao.product.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import SportsMall.dao.DBUtil;
import SportsMall.dao.product.ProductDao;
import SportsMall.entity.Product;
import SportsMall.entity.Product_zuqiu;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product_zuqiu> findAll_zuqiu() {
		try {
			List<Product_zuqiu> list_zq = new ArrayList<Product_zuqiu>();
			Connection con = DBUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from product_zuqiu");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product_zuqiu p = new Product_zuqiu();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountprice(rs.getInt(5));
				list_zq.add(p);
			}
			return list_zq;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> finAll_lanqiu() {
		try {
			List<Product> list_lq = new ArrayList<Product>();
			Connection con = DBUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from product_lanqiu");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountprice(rs.getInt(5));
				list_lq.add(p);
			}
			return list_lq;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> finAll_yumaoqiu() {
		try {
			List<Product> list_ymq = new ArrayList<Product>();
			Connection con = DBUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from product_yumaoqiu");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountprice(rs.getInt(5));
				list_ymq.add(p);
			}
			return list_ymq;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Product> finAll_pingpangqiu() {
		try {
			List<Product> list_ppq = new ArrayList<Product>();
			Connection con = DBUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from product_pingpangqiu");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountprice(rs.getInt(5));
				list_ppq.add(p);
			}
			return list_ppq;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product_zuqiu selectProduct_zq(int id) {
		try{
			Connection con=DBUtil.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product_zuqiu where id=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product_zuqiu p=new Product_zuqiu();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setListimg(rs.getString(3));
				p.setPrice(rs.getInt(4));
				p.setDiscountprice(rs.getInt(5));
				return p;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
