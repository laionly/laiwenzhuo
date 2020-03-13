package com.ep.ep.entity;

import java.io.Serializable;

public class Focustable implements Serializable{
	private int fid;
	private int pid;
	private int uid;
	private Product product;
	private User user;
	public Focustable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Focustable(int fid, int pid, int uid, Product product, User user) {
		super();
		this.fid = fid;
		this.pid = pid;
		this.uid = uid;
		this.product = product;
		this.user = user;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Focustable [fid=" + fid + ", pid=" + pid + ", uid=" + uid + ", product=" + product + ", user=" + user
				+ "]";
	}
	
	
	
	

}
