package com.skishop.entity;
/**
 * 
 *<p>Title:CartItem</p>
 *<p>Description:购物项类：商品，商品数量，价格</p>
 * @author 赖文卓
 * @date 2019年10月14日
 */
public class CartItem {
	private Product product;
	private int count;
	private int price;
	
	
	public CartItem() {
	}
	public CartItem(Product product, int count, int price) {
		super();
		this.product = product;
		this.count = count;
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		this.price=this.product.getDiscountprince()*this.count;
		
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
