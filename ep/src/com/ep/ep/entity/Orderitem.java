package com.ep.ep.entity;

import java.io.Serializable;
import java.util.List;

public class Orderitem implements Serializable{
	private Integer oid;
	private Integer oderbase_id;
	private Integer product_id;
	private Integer shopnum;
	private Orderbase orderbase;
	private String productname;
	private double price;
	private double rprice;
	private String picture;
	private List<Product> products;
	public Orderitem() {
		super();
	}
	public Orderitem(Integer oderbase_id, Integer product_id, Integer shopnum) {
		super();
		this.oderbase_id = oderbase_id;
		this.product_id = product_id;
		this.shopnum = shopnum;
	}
	
	
	public Orderitem(Integer oderbase_id, Integer product_id, Integer shopnum, String productname, double price,
			double rprice, String picture) {
		super();
		this.oderbase_id = oderbase_id;
		this.product_id = product_id;
		this.shopnum = shopnum;
		this.productname = productname;
		this.price = price;
		this.rprice = rprice;
		this.picture = picture;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getOderbase_id() {
		return oderbase_id;
	}
	public void setOderbase_id(Integer oderbase_id) {
		this.oderbase_id = oderbase_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getShopnum() {
		return shopnum;
	}
	public void setShopnum(Integer shopnum) {
		this.shopnum = shopnum;
	}
	public Orderbase getOrderbase() {
		return orderbase;
	}
	public void setOrderbase(Orderbase orderbase) {
		this.orderbase = orderbase;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRprice() {
		return rprice;
	}
	public void setRprice(double rprice) {
		this.rprice = rprice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Orderitem [oid=" + oid + ", oderbase_id=" + oderbase_id + ", product_id=" + product_id + ", shopnum="
				+ shopnum + ", orderbase=" + orderbase + ", productname=" + productname + ", price=" + price
				+ ", rprice=" + rprice + ", picture=" + picture + ", products=" + products + "]";
	}
	
	
	
	

}
