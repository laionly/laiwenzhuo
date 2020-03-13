package com.ep.ep.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ep.ep.dao.admin.AdminDao;
import com.ep.ep.entity.Admin;
import com.ep.ep.service.AdminService;

@Service("adminservice")
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
	private AdminDao adminDao;

	@Override
	public void insertAdmin(Admin admin) {
		adminDao.insertAdmin(admin);	
	}

	@Override
	public void deleteAdmin(Integer id) {
		
		adminDao.deleteAdmin(id);
	}
	
	@Override
	public Admin loginAdmin(String name,String password) {
		Admin admin=adminDao.loginAdmin(name, password);
		return admin;
	}

	
    
}
