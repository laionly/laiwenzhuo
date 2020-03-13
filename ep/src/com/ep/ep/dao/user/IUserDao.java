package com.ep.ep.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;
@Component
public interface IUserDao {
	//用户注册
	public void addUser(User user);
	//通过用户名查找用户
	public User findUserByUname(String username);
	//注册时检测邮箱地址是否重复
	public User findByEmail(String email);
	//注册时检测手机号是否重复
	public User findByPhone(String phone);
	//用户登录
	public User login(@Param("username")String username,@Param("password")String password);
	//通过uid查找用户
	public User findUserByUid(Integer uid);
	//更新用户
	public void updateUser(User user);
	//用户查看收藏夹
	public User checkFocustable(Integer uid);
	//用户查看购物车
	public List<Shop_cart> checkShopCart(Integer uid);
	//用户下订单
	public void place_orderByUid(Orderbase orderbase);
	//级联插入订单详情
	public void place_orderByOrid(Orderitem orderitem);
	//查看订单
	public List<Orderbase> checkOrderByUid(Map<String, Object> params);
	//查询订单总数
	public int count(Integer uid);
	//查看详情订单
	public List<Orderitem> checkOrderItemByOrdi(Map<String, Object> params);
	//查看商品数量
	public int productCount(Integer orid);
	
	

}
