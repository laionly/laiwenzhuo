package com.ep.ep.service;

import com.ep.ep.entity.Shop_cart;

public interface Shop_CartService {
	//通过商品id查询购物车商品项
	public Shop_cart findShop_cartByPid(Integer pid,Integer uid,Integer fid);
	//通过商品id查询购物车商品项
	public Shop_cart addShop_cartByPid(Integer pid,Integer uid);
	//从收藏夹添加商品进购物车
	public void addShop_cart(Integer uid,Integer pid,Integer shoppingnum);
	//更新购物车信息
	public void updataShop_Cart(Shop_cart shop_cart);
	//添加购物车
	public void addShopcart(Integer uid,Integer pid,Integer shoppingnum);
	//删除购物车
	public  void deleteShopcartById(Integer cid);
	//清空购物车
	public void deleteShopcart(Integer uid);

}
