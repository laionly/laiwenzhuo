package com.Spring.TransactionManager.entity;

public class Account {
	private Integer id;
	private Integer uid;
	private double money;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(Integer id, Integer uid, double money) {
		super();
		this.id = id;
		this.uid = uid;
		this.money = money;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"uid\":\"" + uid + "\", \"money\":\"" + money + "\"}";
	}
	

}
