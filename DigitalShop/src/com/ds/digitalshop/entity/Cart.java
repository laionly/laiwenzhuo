package com.ds.digitalshop.entity;
//实现购物车
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ds.digitalshop.entity.CartItem;
import com.ds.digitalshop.entity.Product;

public class Cart {
	private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
	private int count;
	private int price;
	

	public Map<Integer, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<Integer, CartItem> map) {
		this.map = map;
	}
	
	
    public int getCount(){
    	int number=0;
    	for(Entry<Integer,CartItem> entry : map.entrySet()){
    		CartItem cartItem=map.get(entry.getKey());
    		number=number+cartItem.getCount();
    		this.count=number;
    	}
    	return count;
    }
    
    public void setCount(int count){
    	this.count=count;
    }
	
	public int getPrice() {
		int totalPrice = 0;
		for (Entry<Integer, CartItem> entry : map.entrySet()) {
			CartItem cartItem = map.get(entry.getKey());
			totalPrice = totalPrice + cartItem.getPrice();
			this.price = totalPrice;
		}
		return price;
	}
 
	public void setPrice(int price) {
		this.price = price;
	}

	public void addItem(Product product) {
		if (map.containsKey(product.getProductid())) {
			CartItem cartItem = map.get(product.getProductid());
			cartItem.setCount(cartItem.getCount() + 1);
		} else {
			CartItem item = new CartItem();

			item.setProduct(product);
			item.setCount(1);
			map.put(product.getProductid(), item);

		}
	}

	public boolean deleteItem(Product product) {
		if (map.containsKey(product.getProductid())) {
			CartItem cartItem = map.get(product.getProductid());
			if (cartItem.getCount() != 0) {
				cartItem.setCount(cartItem.getCount() - 1);
				if (cartItem.getCount() == 0) {
					map.remove(product.getProductid());
				}
			}
		}
		return false;
	}
}
