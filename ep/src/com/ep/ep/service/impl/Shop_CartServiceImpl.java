package com.ep.ep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ep.ep.dao.focustable.IFocustableDao;
import com.ep.ep.dao.shop_cart.IShop_CartDao;
import com.ep.ep.entity.Product;
import com.ep.ep.entity.Shop_cart;
import com.ep.ep.service.Shop_CartService;
@Service
public class Shop_CartServiceImpl implements Shop_CartService {
	@Autowired
	IShop_CartDao sc;
	@Autowired
	IFocustableDao fd;

	@Override
	public Shop_cart findShop_cartByPid(Integer pid,Integer uid,Integer fid) {
		Shop_cart shop_cart=sc.findShop_cartByPid(pid,uid);
		fd.deleteFocustableByFid(fid);
		return shop_cart;
	}

	@Override
	public Shop_cart addShop_cartByPid(Integer pid, Integer uid) {
		Shop_cart shop_cart=sc.findShop_cartByPid(pid,uid);
		return shop_cart;
	}

	@Override
	public void addShop_cart(Integer uid, Integer pid, Integer shoppingnum) {
		sc.addShop_cart(uid, pid, shoppingnum);
	}

	@Override
	public void updataShop_Cart(Shop_cart shop_cart) {
		sc.updataShop_Cart(shop_cart);
	}

	@Override
	public void addShopcart(Integer uid,Integer pid,Integer shoppingnum) {
		sc.addShopcart(uid,pid,shoppingnum);	
	}

	@Override
	public void deleteShopcartById(Integer cid) {
		sc.deleteShopcartById(cid);
		
	}

	@Override
	public void deleteShopcart(Integer uid) {
		sc.deleteShopcart(uid);
		
	}

    
}
