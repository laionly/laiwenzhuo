package com.mybatis.mapper;

import java.util.List;

import com.mybatis.entity.Role;

public interface RoleMapper {
	//查询所有角色
	List<Role> findAll();

}
