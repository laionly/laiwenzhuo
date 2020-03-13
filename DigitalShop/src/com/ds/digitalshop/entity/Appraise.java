package com.ds.digitalshop.entity;
// Generated 2019-12-25 16:55:57 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 评价实体类
 * @author Naive
 * @date: 2020年1月6日 上午9:36:00
 */
@Entity
@Table(name = "appraise", catalog = "digitalshop")
public class Appraise implements java.io.Serializable {
	private Integer aid;//评论id
	private Product product;//关联评价商品
	private User user;//关联评价用户
	private String appraise;//评价内容

	public Appraise() {
	}

	public Appraise(Product product, User user, String appraise) {
		this.product = product;
		this.user = user;
		this.appraise = appraise;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "appraise", nullable = false)
	public String getAppraise() {
		return this.appraise;
	}

	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}

	@Override
	public String toString() {
		return "Appraise [aid=" + aid + ", product=" + product + ", user=" + user + ", appraise=" + appraise + "]";
	}

}
