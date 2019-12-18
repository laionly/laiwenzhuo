package com.skishop.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * <p>
 * Title:Cart
 * </p>
 * <p>
 * Description:购物车类:购物车项+价格+添加商品到购物车方法
 * </p>
 * 
 * @author 赖文卓
 * @date 2019年10月14日
 */
public class Cart {

	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private int price;

	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}

	// 总价
	public int getPrice() {
		int totalPrice = 0;

		// Set<Integer> keySet=map.keySet();
		// Set<Entry<Integer,CartItem>> entrySet=map.entrySet();
		// for循环：遍历整个购物项
		for (Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem carItem = map.get(entry.getKey());
			totalPrice = totalPrice + carItem.getPrice();
			this.price = totalPrice;
		}
		return price;

	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void addItem(Product product) {
		if (map.containsKey(product.getId())) {
			CartItem cartItem = map.get(product.getId());
			cartItem.setCount(cartItem.getCount() + 1);

		} else {
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setCount(1);
			// map.put(key, value)
			map.put(product.getId(), item);
		}

	}

	public void deleteItem(Product product) {
		if (map.containsKey(product.getId())) {
			CartItem cartItem = map.get(product.getId());
			cartItem.setCount(cartItem.getCount() - 1);
			if (cartItem.getCount()==0) {
				map.remove(product.getId());
			}
		}
	}
	public void clearCart(Product product){
		if (map.containsKey(product)){
			CartItem cartItem = map.get(product);
			cartItem.setCount(0);
		}
	}

}
