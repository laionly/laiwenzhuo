package com.ep.ep.dao.adminuser;

import java.util.List;

import com.ep.ep.entity.User;

public interface AdminUserDao {
  
   
   public void deleteUser(Integer uid);
   
   public List<User> findAllUsers();
}
