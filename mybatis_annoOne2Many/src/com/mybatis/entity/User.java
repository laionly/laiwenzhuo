package com.mybatis.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	private Integer UserId;
	private String userName;
	private String UserSex;
	private String UserAddress;
	private Date UserBirthday;
	//一队多关系映射：一个用户对应多个账户
	private List<Account> accounts;
	
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return UserSex;
	}
	public void setUserSex(String userSex) {
		UserSex = userSex;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public Date getUserBirthday() {
		return UserBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		UserBirthday = userBirthday;
	}
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", userName=" + userName + ", UserSex=" + UserSex + ", UserAddress="
				+ UserAddress + ", UserBirthday=" + UserBirthday + "]";
	}
	
	
	

}
