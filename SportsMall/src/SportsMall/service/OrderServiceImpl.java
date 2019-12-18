package SportsMall.service;


import java.util.List;


import SportsMall.dao.order.impl.OrderDaoImpl;
import SportsMall.entity.Order;
import SportsMall.entity.OrderItem;
import SportsMall.entity.User;

public class OrderServiceImpl implements OrderService {
	OrderDaoImpl orderDao = new OrderDaoImpl();

	@Override
	public void addOrder(Order order)  {
		
		
			//����OrderDao�������Ӷ���
			orderDao.addOrder(order);
			//����������
			for (OrderItem item : order.getOrderItems()) {
				orderDao.addOrderItems(item);
			}
			
			
		
		
	}


	@Override
	public List<Order> findAllOrders() {
		return orderDao.findAllOrders();		
	}

	





	@Override
	public List<Order> findAllRecords(User user) {
		
		
		return orderDao.findAllRecords(user);
	}



	@Override
	public Order findOrderByid(String id) {
		
		return orderDao.findOrderByid(id);
	}


	
	
}
