package com.skishop.entity;
/*
 * 实体类
 */
public class Product {
	
	private int id;
	private String name;
	private String description;
	private String listimg;
//	private String img1;
//	private String img2;
//	private String img3;
	private int prince;
	private int discountprince;
	public Product(int id, String name, String description, String listimg, int prince, int discountprince) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.listimg = listimg;
		this.prince = prince;
		this.discountprince = discountprince;
	}
	public Product(){
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getListimg() {
		return listimg;
	}
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
//	public String getImg1() {
//		return img1;
//	}
//	public void setImg1(String img1) {
//		this.img1 = img1;
//	}
//	public String getImg2() {
//		return img2;
//	}
//	public void setImg2(String img2) {
//		this.img2 = img2;
//	}
//	public String getImg3() {
//		return img3;
//	}
//	public void setImg3(String img3) {
//		this.img3 = img3;
//	}
	public int getPrince() {
		return prince;
	}
	public void setPrince(int prince) {
		this.prince = prince;
	}
	public int getDiscountprince() {
		return discountprince;
	}
	public void setDiscountprince(int discountprince) {
		this.discountprince = discountprince;
	}
	
}
