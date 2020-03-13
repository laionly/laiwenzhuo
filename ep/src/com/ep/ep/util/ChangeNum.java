package com.ep.ep.util;

public class ChangeNum {
	private int cid;
	private double amount;
	private int shoppingnum;
	private double allAmount;
	
	public ChangeNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChangeNum(int cid, double amount, int shoppingnum, double allAmount) {
		super();
		this.cid = cid;
		this.amount = amount;
		this.shoppingnum = shoppingnum;
		this.allAmount = allAmount;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
	public double getAllAmount() {
		return allAmount;
	}
	public void setAllAmount(double allAmount) {
		this.allAmount = allAmount;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "ChangeNum [cid=" + cid + ", amount=" + amount + ", shoppingnum=" + shoppingnum + ", allAmount="
				+ allAmount + "]";
	}
	
	
	

}
