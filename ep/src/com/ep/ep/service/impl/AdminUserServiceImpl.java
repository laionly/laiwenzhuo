package com.ep.ep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ep.ep.dao.adminuser.AdminUserDao;
import com.ep.ep.entity.User;
import com.ep.ep.service.AdminUserService;
@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService{
    @Autowired
    private AdminUserDao adminuserdao;

	@Override
	public void deleteUser(Integer uid) {
		adminuserdao.deleteUser(uid);	
	}
	
	public List<User> findAllUsers(){
		List<User> user=adminuserdao.findAllUsers();
		return user;
		
	}

}
