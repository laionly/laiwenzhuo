package com.ds.digitalshop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 订单项
 * @author Naive
 * @date: 2020年1月6日 上午9:30:06
 */
@Entity
@Table(name = "productitem", catalog = "digitalshop")
public class ProductItem {
	private int productItemid;//商品id
	private String name;//商品名
	private String description;//商品描述
	private String listimg;//商品图片
	private Integer price;//商品单价
	private Integer discountprice;//商品折后价
	private int count;//数量
	private int productItemprice;//订单项总价
	private Order order;//
	
	
	
	public ProductItem(){
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "productItemid", unique = true, nullable = false)
	public int getProductItemid() {
		return productItemid;
	}
	public void setProductItemid(int productItemid) {
		this.productItemid = productItemid;
	}
	
	@Column(name = "count", unique = false, nullable = false)
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Column(name = "price", unique = false, nullable = false)
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid", nullable = false)
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	@Column(name = "name", unique = false, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "description", unique = false, nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "listimg", unique = false, nullable = false)
	public String getListimg() {
		return listimg;
	}

	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	@Column(name = "discountprice", unique = false, nullable = false)
	public Integer getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(Integer discountprice) {
		this.discountprice = discountprice;
	}
	@Column(name = "productItemprice", unique = false, nullable = false)
	public int getProductItemprice() {
		return productItemprice;
	}

	public void setProductItemprice(int productItemprice) {
		this.productItemprice = productItemprice;
	}
	
}
