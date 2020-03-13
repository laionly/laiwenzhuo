package com.ds.digitalshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.digitalshop.dao.UserDao;
import com.ds.digitalshop.entity.Collect;
import com.ds.digitalshop.entity.Order;
import com.ds.digitalshop.entity.Page;
import com.ds.digitalshop.entity.User;
import com.ds.digitalshop.service.UserService;
@Service("uservice")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;

	@Override
	public void addUser(User user) {
		ud.addUser(user);
	}

	@Override
	public User UserLogin(String username, String password) {
		System.out.println("开始进行登录");
		User loginok =ud.Userlogin(username, password);
		if (loginok!=null) {
			System.out.println("登录成功");
			return loginok;
		}else{
			System.out.println("登录失败");
			return null;
		}
		
	}

	@Override
	public User findUserByid(int userid) {
		User user=ud.findUserByid(userid);
		return user;
	}

	@Override
	public User updateUser(User user) {
		ud.updateUser(user);
		return user;
	}

	@Override
	public User findUserByUE(String username, String email) {
		User user=ud.findUserByUE(username, email);
		return user;
	}

	@Override
	public User updatehead_portrait(String head_portrait, int userid) {
		User user=ud.updatehead_portrait(head_portrait, userid);
		return user;
	}

	@Override
	public User removeUserCollectbycid(int cid) {
		User user=ud.removeUserCollectbycid(cid);
		return user;
	}
	
	@Override
	public Page<Order> OrderPage(int pageNum,int userid) {
		try{
			Page<Order> order=new Page<>(pageNum,5);
			order.setTotalCount(ud.findOrderCount(userid));
			order.setList(ud.OrderPager(order, userid));
			return order;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	

}
