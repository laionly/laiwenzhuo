package com.naive.entity;

public class SysStatus {
	private String peopleOnline;//在线人数
	private String productCount;//商品数量
	private String usersCount;//用户数量
	
	public SysStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPeopleOnline() {
		return peopleOnline;
	}
	public void setPeopleOnline(String peopleOnline) {
		this.peopleOnline = peopleOnline;
	}
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getUsersCount() {
		return usersCount;
	}
	public void setUsersCount(String usersCount) {
		this.usersCount = usersCount;
	}
	
	
}
