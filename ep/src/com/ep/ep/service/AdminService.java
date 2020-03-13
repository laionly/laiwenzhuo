package com.ep.ep.service;



import com.ep.ep.entity.Admin;

public interface AdminService {
 public void insertAdmin(Admin admin);
 
 public void deleteAdmin(Integer id);
 
 public Admin loginAdmin(String name,String password);
}
