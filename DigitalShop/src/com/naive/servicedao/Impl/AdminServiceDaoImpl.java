package com.naive.servicedao.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naive.dao.AdminDao;
import com.naive.dao.AdminProductDao;
import com.naive.dao.AdminUsersDao;
import com.naive.entity.Admin;
import com.naive.entity.SysStatus;
import com.naive.servicedao.AdminServiceDao;
/**
 * 管理员Service 
 * @author Naive
 * @date: 2019年12月17日 下午4:45:11
 */
@Service
@Transactional
public class AdminServiceDaoImpl implements AdminServiceDao {
	@Resource
	private AdminDao adminDao;
	@Resource
	private AdminUsersDao adminUsersDao;
	@Resource
	private AdminProductDao adminProductDao;

	@Override
	public Admin AdminLogin(String adminName, String password) {
		try {
			Admin admin = adminDao.AdminLogin(adminName, password);
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean AdminUpdata(Admin admin) {
		try {
			if (adminDao.AdminUpdata(admin)!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public boolean AdminRegister(Admin admin) {
		try {
			if (adminDao.AdminRegister(admin)!=null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public SysStatus selStatus() {
		SysStatus status = new SysStatus();
		try {
			status.setProductCount(String.valueOf(adminProductDao.findProductCount()));
			status.setUsersCount(String.valueOf(adminUsersDao.findUsersCount()));
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
