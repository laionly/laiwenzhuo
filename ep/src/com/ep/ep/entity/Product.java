package com.ep.ep.entity;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{
	private Integer pid;
	private String name;
	private double price;
	private double rprice;
	private String picture;
	private Product_type product_type;
	private Integer pt_id;
	private Shop_cart shop_cart;
	private Orderitem orderitem;
	private List<Focustable> focustables;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, double price, double rprice, String picture,Integer pt_id) {
		super();
	
		this.name = name;
		this.price = price;
		this.rprice = rprice;
		this.picture = picture;
		this.pt_id = pt_id;
		
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Product_type getProduct_type() {
		return product_type;
	}
	public void setProduct_type(Product_type product_type) {
		this.product_type = product_type;
	}
	public Shop_cart getShop_cart() {
		return shop_cart;
	}
	public void setShop_cart(Shop_cart shop_cart) {
		this.shop_cart = shop_cart;
	}
	public Orderitem getOrderitem() {
		return orderitem;
	}
	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}
	
	public List<Focustable> getFocustables() {
		return focustables;
	}
	public void setFocustables(List<Focustable> focustables) {
		this.focustables = focustables;
	}
	
	public Integer getPt_id() {
		return pt_id;
	}
	public void setPt_id(Integer pt_id) {
		this.pt_id = pt_id;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", rprice=" + rprice + ", picture="
				+ picture + ", product_type=" + product_type + ", pt_id=" + pt_id + ", shop_cart=" + shop_cart
				+ ", orderitem=" + orderitem + ", focustables=" + focustables + "]";
	}
	
	
	

}
