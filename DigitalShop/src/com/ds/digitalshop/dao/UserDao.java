package com.ds.digitalshop.dao;

import java.util.List;

import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;

public interface UserDao {
	public void addUser(User user);
	public User Userlogin(String username,String password);
	public User findUserByid(int userid);
	public User updateUser(User user);
	public User findUserByUE(String username,String email);
	public User updatehead_portrait(String head_portrait,int userid);
	public User removeUserCollectbycid(int cid);
	public Integer findOrderCount(int userid);
	public List<Order> OrderPager(Page<Order> page,int userid);

}
