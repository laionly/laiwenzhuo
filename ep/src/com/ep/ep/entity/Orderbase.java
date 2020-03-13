package com.ep.ep.entity;

import java.util.Date;
import java.util.List;

public class Orderbase {
	private Integer orid;
	private Integer user_id;
	private double amount;
	private String orderdate;
	private String address;
	private String phone;
	private String name;
	private List<Orderitem> orderitems;
	public Orderbase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orderbase(Integer user_id, double amount, String orderdate, String address, String phone, String name) {
		super();
		this.user_id = user_id;
		this.amount = amount;
		this.orderdate = orderdate;
		this.address = address;
		this.phone = phone;
		this.name = name;
	}
	public Integer getOrid() {
		return orid;
	}
	public void setOrid(Integer orid) {
		this.orid = orid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Orderitem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	@Override
	public String toString() {
		return "Orderbase [orid=" + orid + ", user_id=" + user_id + ", amount=" + amount + ", orderdate=" + orderdate
				+ ", address=" + address + ", phone=" + phone + ", name=" + name + ", orderitems=" + orderitems + "]";
	}
	

	
	
	
	
	

}
