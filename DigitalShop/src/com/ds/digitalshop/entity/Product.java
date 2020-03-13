package com.ds.digitalshop.entity;
// Generated 2019-12-25 16:55:57 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 商品实体类
 * @author Naive
 * @date: 2020年1月6日 上午9:30:20
 */
@Entity
@Table(name = "product", catalog = "digitalshop")
public class Product implements java.io.Serializable {

	private Integer productid;
	private String name;
	private String description;
	private String listimg;
	private Integer price;
	private Integer discountprice;
	private Set<Collect> collects = new HashSet<Collect>(0);
	private Set<Appraise> appraises = new HashSet<Appraise>(0);

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public Product(String name, String description, String listimg, Integer price, Integer discountprice) {
		this.name = name;
		this.description = description;
		this.listimg = listimg;
		this.price = price;
		this.discountprice = discountprice;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "productid", unique = true, nullable = false)
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "listimg")
	public String getListimg() {
		return this.listimg;
	}

	public void setListimg(String listimg) {
		this.listimg = listimg;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "discountprice")
	public Integer getDiscountprice() {
		return this.discountprice;
	}

	public void setDiscountprice(Integer discountprice) {
		this.discountprice = discountprice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Collect> getCollects() {
		return this.collects;
	}

	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Appraise> getAppraises() {
		return this.appraises;
	}

	public void setAppraises(Set<Appraise> appraises) {
		this.appraises = appraises;
	}
    
  
}
