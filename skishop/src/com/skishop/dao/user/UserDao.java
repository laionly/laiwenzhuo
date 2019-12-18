package com.skishop.dao.user;

import java.util.List;

import com.skishop.entity.User;

public interface UserDao {
	public boolean addUser(User user);//注册用户
	public boolean UsersLogin(String email,String password);//登入
	public boolean updateUser(User user);//修改用户信息
	public User selectUser(String email);
	public List<User> viewUser(String email);
	public List<User> listUser();
	public boolean deleteUser(String email);
	

}
