package com.ep.ep.dao.shop_cart;

import org.apache.ibatis.annotations.Param;

import com.ep.ep.entity.Shop_cart;

public interface IShop_CartDao {
	//更新购物车信息
	public void updataShop_Cart(Shop_cart shop_cart);
	//级联查询购物车，商品信息
	public Shop_cart findShop_CartByCid(Integer cid);
	//通过购物车项ID删除购物项(用于下单的同时清空购物车)
	public void deleteShop_CartByCid(Integer cid);
	//通过商品id查询购物车商品项
	public Shop_cart findShop_cartByPid(Integer pid);
	//从收藏夹添加商品进购物车
	public void addShop_cart(@Param(value = "uid")Integer uid,@Param(value = "pid")Integer pid,@Param(value = "shoppingnum")Integer shoppingnum);

}
