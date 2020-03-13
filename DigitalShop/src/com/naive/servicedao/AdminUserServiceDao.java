package com.naive.servicedao;


import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;

public interface AdminUserServiceDao {
	/**
	 * 	用户分页
	 * @param pageNum 当前页
	 * @return
	 */
	public Page<User> UsersPage(int pageNum);
	/**
	 * 	删除用户
	 * @param id 用户id
	 * @return
	 */
	public boolean DelUsers(int id);
	/**
	 * 	修改用户密码
	 * @param id 用户id
	 * @param password 用户密码
	 * @return
	 */
	public boolean UpdatePassword(int id, String password);
	/**
	 * 	查询用户
	 * @param userid 用户id
	 * @return
	 */
	public User selectUser(int userid);
	/**
	 * 	删除收藏
	 * @param cid 收藏项id
	 * @return
	 */
	public boolean DelCollect(int cid);
	/**
	 * 模糊查询用户
	 * @param pageNum
	 * @param username
	 * @return
	 */
	public Page<User> queryUserPage(int pageNum, String username);
	/**
	 * 查询订单详情
	 * @param orderid
	 * @return
	 */
	public Order userOrder(int orderid);
}
