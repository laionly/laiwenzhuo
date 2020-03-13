package com.ep.ep.service;

import com.ep.ep.entity.Shop_cart;

public interface Shop_CartService {
	//通过商品id查询购物车商品项
	public Shop_cart findShop_cartByPid(Integer pid);
	//从收藏夹添加商品进购物车
	public void addShop_cart(Integer uid,Integer pid,Integer shoppingnum);
	//更新购物车信息
	public void updataShop_Cart(Shop_cart shop_cart);

}
