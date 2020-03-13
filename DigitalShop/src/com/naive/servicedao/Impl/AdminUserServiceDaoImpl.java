package com.naive.servicedao.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.CollectDao;
import com.ds.digitalshop.dao.OrderDao;
import com.ds.digitalshop.dao.UserDao;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;
import com.naive.dao.AdminUsersDao;
import com.naive.servicedao.AdminUserServiceDao;
/**
 * 	管理用户service
 * @author Naive
 * @date 2020年1月1日
 */
@Service
@Transactional
public class AdminUserServiceDaoImpl implements AdminUserServiceDao {
	@Resource
	private AdminUsersDao adminUsersDao;
	@Resource
	private UserDao userDao;
	@Resource
	private CollectDao collectDao;
	@Resource
	private OrderDao orderDao;
	
	@Override
	public Page<User> UsersPage(int pageNum) {
		try {
			Page<User> page = new Page<>(pageNum, 5);
			page.setTotalCount(adminUsersDao.findUsersCount());
			page.setList(adminUsersDao.UsersPageList(page));
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean DelUsers(int id) {
		try {
			User user = userDao.findUserByid(id);
			return adminUsersDao.DelUsers(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean UpdatePassword(int id, String password) {
		try {
			if (adminUsersDao.UpdateUserPassword(id, password)!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User selectUser(int userid) {
		try {
			return userDao.findUserByid(userid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean DelCollect(int cid) {
		try {
			collectDao.deleteCollect(cid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Page<User> queryUserPage(int pageNum, String username) {
		try {
			Page<User> page = new Page<>(pageNum, 5);
			page.setTotalCount(adminUsersDao.userQueryCount(username));
			page.setList(adminUsersDao.userQueryList(page, username));
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Order userOrder(int orderid) {
		try {
			return orderDao.selectOneOrder(orderid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
