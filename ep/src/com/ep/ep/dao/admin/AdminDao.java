package com.ep.ep.dao.admin;


import org.apache.ibatis.annotations.Param;

import com.ep.ep.entity.Admin;

public interface AdminDao {
  public void insertAdmin(Admin admin);
  
  public void deleteAdmin(Integer id);
  
  public Admin loginAdmin(@Param("name")String name,@Param("password")String password);
}
