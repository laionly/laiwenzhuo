package com.ep.ep.service;


import java.util.List;
import java.util.Map;

import com.ep.ep.entity.Orderbase;
import com.ep.ep.entity.Orderitem;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.entity.User;

public interface UserService {
	//用户注册
	public void addUser(User user);
	//用户登录
	public User login(String username,String password);
	//通过Uid查找用户（查看个人信息）
	public User findUserByUid(Integer uid);
	//更新用户
	public void updataUser(User user);
	//查看个人/用户收藏夹
	public User checkFoucstable(Integer uid);
	//用户查看购物车
	public List<Shop_cart> checkShopCart(Integer uid);
	//更新购物车
	public void updateProductnum(Shop_cart shop_cart);
	//通过购物车项cid查看购物车（用于变更商品数量时更新总价）
	public Shop_cart findShop_CartByCid(Integer cid);
	//用户下单
	public void place_orderByUid(Orderbase orderbase);
	//级联插入订单详情
	public void place_orderByOrid(Orderitem orderitem);
	//计算购物车总价
	public double Amount(Integer uid);
	//下单的同时清除购物车
	public void deleteShop_cartByCid(Integer cid);
	//查看订单
	public List<Orderbase> checkOrderByUid(Map<String, Object> params);
	//计算用户订单总数
	public int count(Integer uid);
	//查看详情订单（包括商品名称，数量，单价，折后价）
	public List<Orderitem> checkOrderItemByOrdi(Map<String, Object> params);
	//计算每项订单商品总数
	public int productCount(Integer orid);
	//删除收藏夹里的商品项（取消收藏）
	public void deleteFocustable(Integer fid);
	//通过用户名查找用户
	public User findUserByUname(String username);
	//注册时检测邮箱地址是否重复
	public User findByEmail(String email);
	//注册时检测手机号是否重复
	public User findByPhone(String phone);
	//用户添加商品进收藏夹
	public void addWishList(Integer uid,Integer pid);
	//清空收藏夹
	public void removeAllFocustableByUid(Integer uid);
	
	

}
