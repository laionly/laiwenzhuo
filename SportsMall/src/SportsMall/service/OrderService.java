package SportsMall.service;

import java.util.List;


import SportsMall.entity.Order;
import SportsMall.entity.OrderItem;
import SportsMall.entity.User;

public interface OrderService {

	void addOrder(Order order);//��Ӷ���


	List<Order> findAllRecords(User user);//�����û���ѯ���еĶ�����¼

	Order findOrderByid(String id);//����id����ѯ����

	List<Order> findAllOrders() ;//��ѯ���ж���

}
