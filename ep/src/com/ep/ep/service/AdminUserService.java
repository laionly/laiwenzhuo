package com.ep.ep.service;

import java.util.List;

import com.ep.ep.entity.User;

public interface AdminUserService {
   
   
   public void deleteUser(Integer uid);
   
   public List<User> findAllUsers();
}
