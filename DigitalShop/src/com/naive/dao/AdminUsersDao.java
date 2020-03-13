package com.naive.dao;

import java.util.List;

import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;

public interface AdminUsersDao {
	/**
	 * 	用户列表分页
	 * @param page
	 * @return
	 */
	public List<User> UsersPageList(Page<User> page);
	/**
	 * 	查询用户总数
	 * @return
	 */
	public Integer findUsersCount();
	/**
	 * 删除用户
	 * @param id 用户id
	 * @return
	 */
	public boolean DelUsers(User user);
	/**
	 * 	修改用户密码
	 * @param id 用户id
	 * @param password 用户密码
	 * @return
	 */
	public Integer UpdateUserPassword(int id, String password);
	/**
	 * 用户模糊查询
	 * @param page
	 * @param username
	 * @return
	 */
	public List<User> userQueryList(Page<User> page, String username);
	/**
	 * 模糊查询数量
	 * @return
	 */
	public Integer userQueryCount(String username);
}
