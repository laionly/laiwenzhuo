package com.ep.ep.entity;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private Integer uid;
	private String username;
	private String password;
	private String address;
	private String phone;
	private String email;
	private List<Orderbase> orderbases;
	private List<Shop_cart> shop_carts;
	private List<Focustable> focustables;
	public User( String username, String password, String address, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public User(Integer uid, String username, String password, String address, String phone, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Orderbase> getOrderbases() {
		return orderbases;
	}
	public void setOrderbases(List<Orderbase> orderbases) {
		this.orderbases = orderbases;
	}
	
	public List<Shop_cart> getShop_carts() {
		return shop_carts;
	}

	public void setShop_carts(List<Shop_cart> shop_carts) {
		this.shop_carts = shop_carts;
	}

	public List<Focustable> getFocustables() {
		return focustables;
	}

	public void setFocustables(List<Focustable> focustables) {
		this.focustables = focustables;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", orderbases=" + orderbases + ", shop_carts=" + shop_carts
				+ ", focustables=" + focustables + "]";
	}

	

	
	
	

}
