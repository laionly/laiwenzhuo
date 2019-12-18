package SportsMall.entity;

public class Product {
	private int id;
	private String name;
	private String listimg;
	private int price;
	private int discountprice;

	public Product(String name, String listimg, int price, int discountprice) {
		this.name = name;
		this.listimg = listimg;
		this.price = price;
		this.discountprice = discountprice;
	}

	public Product() {

	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getListimg() {
		return listimg;
	}

	public void setListimg(String listimg) {
		this.listimg = listimg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountprice() {
		return discountprice;
	}

	public void setDiscountprice(int discountprice) {
		this.discountprice = discountprice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", listimg=" + listimg + ", price=" + price + ", discountprice="
				+ discountprice + "]";
	}
//11
}
