package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.mybatis.entity.User;
@CacheNamespace(blocking = true)
public interface UserDao {
	// 查询所有用户
	@Select("select * from user")
	@Results(id="userMap",value = {
			@Result(id=true,column = "id",property="UserId"),
			@Result(column = "username",property="userName"),
			@Result(column = "sex",property="UserSex"),
			@Result(column = "address",property="UserAddress"),
			@Result(column = "birthday",property="UserBirthday"),
			@Result(property = "accounts",column = "id",
			many = @Many(select = "com.mybatis.dao.AccountDao.findAccountByUid",
			fetchType = FetchType.LAZY))
	})
	List<User> findAll();

	// 根据用户id查找用户
	@Select("select * from user where id=#{id}")
	@ResultMap(value = {"userMap"})
	User findUserById(Integer id);

	// 根据用户名模糊查询
//	@Select("select * from user where username like concat('%',#{username},'%')")
	@Select("select * from user where username like '%${value}%'")
	@ResultMap(value = {"userMap"})
	List<User> findUsersByName(String username);


}
