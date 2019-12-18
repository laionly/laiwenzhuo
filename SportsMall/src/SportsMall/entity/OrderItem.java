package SportsMall.entity;

/**  
 * 
 * @Title:   OrderItem.java
 * @Package   SportsMall.entity
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: ���ɷ�     
 * @date: 2019��11��14�� ����8:44:51  
 * @version V1.0 
 */
public class OrderItem {
	private String id;//��������id
	private double discountprice;//��Ʒ�ĵ���
	private int count;//��Ʒ������
	private double price;//��Ʒ���ܼ�=����*����
	private Product_zuqiu product;//��Ʒ�����
	private Order order;//���������
	public OrderItem() {
		super();
	}

	
	public OrderItem(String id, double discountprice, int count, double price, Product_zuqiu product, Order order) {
		super();
		this.id = id;
		this.discountprice = discountprice;
		this.count = count;
		this.price = price;
		this.product = product;
		this.order = order;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getDiscountprice() {
		return discountprice;
	}
	public void setDiscountprice(double discountprice) {
		this.discountprice = discountprice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	


	public Product_zuqiu getProduct() {
		return product;
	}


	public void setProduct(Product_zuqiu product) {
		this.product = product;
	}


	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", discountprice=" + discountprice + ", count=" + count + ", subtotal="
				+ price + ", product=" + product + ", order=" + order + "]";
	}
	
	
}
