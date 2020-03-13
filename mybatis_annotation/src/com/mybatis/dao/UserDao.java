package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.entity.User;

public interface UserDao {
	// 查询所有用户
	@Select("select * from user")
	List<User> findAll();
	//添加用户
	@Insert(value = "insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void saveUser(User user);
	//更新用户
	@Update(value = "update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id}")
	void updateUser(User user);
	//删除用户
	@Delete("delete from user where id=#{id}")
	void deleteUser(Integer id);
	//根据用户id查找用户
	@Select("select * from user where id=#{id}")
	User findUserById(Integer id);
	//根据用户名模糊查询
//	@Select("select * from user where username like concat('%',#{username},'%')")
	@Select("select * from user where username like '%${value}%'")
	List<User> findUsersByName(String username);
	//查询用户总数
	@Select("select count(*) from user")
	int findTotalUser();

}
