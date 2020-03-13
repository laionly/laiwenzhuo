package com.ds.digitalshop.service;



import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;

public interface UserService {
	public void addUser(User user);
	public User UserLogin(String username,String password);
	public User findUserByid(int userid);
	public User updateUser(User user);
	public User findUserByUE(String username,String email);
	public User updatehead_portrait(String head_portrait,int userid);
	public User removeUserCollectbycid(int cid);
	public Page<Order> OrderPage(int pageNum,int userid);

}
