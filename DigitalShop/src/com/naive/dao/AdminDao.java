package com.naive.dao;

import com.naive.entity.Admin;

/**
 * 管理员接口
 * @author Naive
 * @date: 2019年12月17日 下午3:26:43
 */
public interface AdminDao {
	/**
	 *  管理员登陆
	 * @param adminName 用户名
	 * @param password 密码
	 * @return Admin
	 */
	public Admin AdminLogin(String adminName, String password);
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	public Integer AdminUpdata(Admin admin);
	/**
	 * 新增管理员
	 * @param admin
	 * @return 
	 */
	public Integer AdminRegister(Admin admin);
}
