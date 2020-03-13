package com.naive.servicedao;

import com.naive.entity.Admin;
import com.naive.entity.SysStatus;

public interface AdminServiceDao {
	public Admin AdminLogin(String adminName, String password);
	public boolean AdminUpdata(Admin admin);
	public boolean AdminRegister(Admin admin);
	public SysStatus selStatus();
}
