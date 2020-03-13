package com.ep.ep.entity;

import java.io.Serializable;

public class Product_type implements Serializable{
	private Integer ptid;
	private String typename;
	private Product product;
	public Product_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_type(String typename) {
		super();
		
		this.typename = typename;
	}
	public Integer getPtid() {
		return ptid;
	}
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Product_type [ptid=" + ptid + ", typename=" + typename + ", product=" + product + "]";
	}
	
}
