package SportsMall.dao.order;

import java.sql.Connection;
import java.util.List;

import SportsMall.entity.Order;
import SportsMall.entity.OrderItem;
import SportsMall.entity.User;

/**  
 * 
 * @Title:   Order.java
 * @Package   SportsMall.dao.order.impl
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: ���ɷ�     
 * @date: 2019��11��14�� ����8:45:04  
 * @version V1.0 
 */
public interface OrderDao {
	void addOrder(Order order);//��Ӷ���

	void addOrderItems(OrderItem item);//��Ӷ�������

	List<Order> findAllRecords(User user);//�����û���ѯ���еĶ�����¼

	Order findOrderByid(String id);//����id����ѯ����

	List<Order> findAllOrders() ;//��ѯ���ж���
}
