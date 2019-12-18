package SportsMall.entity;



public class CartItem {
	private Product_zuqiu product;
	private int count;
	private int price;
	public CartItem(){
		
	}
	public CartItem(Product_zuqiu product, int count, int price) {
		super();
		this.product = product;
		this.count = count;
		this.price = price;
	}
	
	public Product_zuqiu getProduct() {
		return product;
	}
	public void setProduct(Product_zuqiu product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		this.price=this.product.getDiscountprice()*this.count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count + ", price=" + price + "]";
	}
	

}
