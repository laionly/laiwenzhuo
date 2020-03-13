package com.ep.ep.entity;

import java.io.Serializable;
import java.util.List;

public class Shop_cart implements Serializable{
	private Integer cid;
	private Integer user_id;
	private Integer product_id;
	private Integer shoppingnum;
	public double amount;
	private User user;
	private Product products;
	public Shop_cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop_cart(Integer cid, Integer user_id, Integer product_id, Integer shoppingnum) {
		super();
		this.cid = cid;
		this.user_id = user_id;
		this.product_id = product_id;
		this.shoppingnum = shoppingnum;
	}
	
	
	public Shop_cart(Integer cid, Integer shoppingnum, double amount) {
		super();
		this.cid = cid;
		this.shoppingnum = shoppingnum;
		this.amount = amount;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(Integer shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Shop_cart [cid=" + cid + ", user_id=" + user_id + ", product_id=" + product_id + ", shoppingnum="
				+ shoppingnum + ", amount=" + amount + ", user=" + user + ", products=" + products + "]";
	}
	
	
	
	
	
	
	
	

}
