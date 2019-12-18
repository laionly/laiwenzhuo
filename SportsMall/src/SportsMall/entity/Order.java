package SportsMall.entity;

import java.util.ArrayList;
import java.util.Date;

/**  
 * 
 * @Title:   Order.java
 * @Package   SportsMall.entity
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: ���ɷ�     
 * @date: 2019��11��14�� ����8:44:38  
 * @version V1.0 
 */
public class Order {
	private String id;//�������id
	private Date ordertime;//�������ɵ�ʱ��
	private double price;//�������ܼ۸�
	private User user;//���һ�������û������ύ�������û�
	private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();//��������
	
	public Order() {
		super();
	}

	public Order(String id, Date ordertime, double price, User user, ArrayList<OrderItem> orderItems) {
		super();
		this.id = id;
		this.ordertime = ordertime;
		this.price = price;
		this.user = user;
		this.orderItems = orderItems;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", ordertime=" + ordertime + ", price=" + price + ", user=" + user + ", orderItems="
				+ orderItems + "]";
	}


}
