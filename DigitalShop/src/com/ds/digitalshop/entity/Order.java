package com.ds.digitalshop.entity;
// Generated 2019-12-25 16:55:57 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 订单实体类
 * @author Naive
 * @date: 2020年1月6日 上午9:31:01
 */
@Entity
@Table(name = "order", catalog = "digitalshop")
public class Order implements java.io.Serializable {

	private Integer orderid;//订单id
	private Set<ProductItem> productItems;//关联订单项
	private User user;//关联用户
	private String name;//收货人
	private int number;//购买数量
	private String address;//收货地址
	private String ordertime;//下单时间
	private String phone;//联系方式
	private String email;//邮箱
	private String orderprice;//订单价格
	

	public Order() {
	}

	public Order(User user,String name,int number, String address, String ordertime,String phone,String email,String orderprice) {
		this.user = user;
		this.name=name;
		this.number = number;
		this.address = address;
		this.ordertime = ordertime;
		this.phone=phone;
		this.email=email;
		this.orderprice=orderprice;
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "orderid", unique = true, nullable = false)
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	public Set<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(Set<ProductItem> productItems) {
		this.productItems = productItems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "number", nullable = false)
	public int getNumber() {
		return this.number;
	}
   
	public void setNumber(int number) {
		this.number = number;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordertime", nullable = false)
	public String getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "orderprice", nullable = false)
	public String getOrderprice() {
		return this.orderprice;
	}

	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}
}
