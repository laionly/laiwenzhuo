package com.ds.digitalshop.entity;
// Generated 2019-12-25 16:55:57 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.ds.digitalshop.entity.Appraise;
import com.ds.digitalshop.entity.Order;

/**
 * 用户实体类
 * @author Naive
 * @date: 2020年1月6日 上午9:30:33
 */
@Entity
@Table(name = "user", catalog = "digitalshop")
public class User implements java.io.Serializable {

	private Integer userid;//用户id
	private String username;//用户名
	private String password;//登陆密码
	private String email;//邮箱
	private String address;//地址
	private String phone;//手机
	private String head_portrait;//头像
	private Set<Appraise> appraises = new HashSet<Appraise>(0);//关联评论
	private Set<Order> orders = new HashSet<Order>(0);//关联订单
	private Set<Collect> collects = new HashSet<Collect>(0);//关联收藏


	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String email, String address, String phone) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public User(Integer userid,String username, String password, String email, String address, String phone) {
		this.userid=userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}
	
	

	public User(Integer userid, String username, String password, String email, String address, String phone,
			String head_portrait) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.head_portrait = head_portrait;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "userid", unique = true, nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "head_portrait")
	public String getHead_portrait() {
		return head_portrait;
	}
	
	public void setHead_portrait(String head_portrait) {
		this.head_portrait = head_portrait;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public Set<Appraise> getAppraises() {
		return this.appraises;
	}

	public void setAppraises(Set<Appraise> appraises) {
		this.appraises = appraises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public Set<Collect> getCollects() {
		return this.collects;
	}

	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}

}
