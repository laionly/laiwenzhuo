package SportsMall.dao.order.impl;

import java.sql.Connection;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import SportsMall.dao.HibernateUtil;
import SportsMall.dao.order.OrderDao;
import SportsMall.entity.Order;
import SportsMall.entity.OrderItem;
import SportsMall.entity.Product;
import SportsMall.entity.User;

/**  
 * 
 * @Title:   OrderDaoImpl.java
 * @Package   SportsMall.dao.order.impl
 * @Description:    TODO(��һ�仰�������ļ���ʲô)   
 * @author: ���ɷ�     
 * @date: 2019��11��14�� ����8:45:45  
 * @version V1.0 
 */
public class OrderDaoImpl implements OrderDao {

	/* 
	 * 1.添加订单
	 * 	 */
	@Override
	public void addOrder(Order order) {
		//1.创建session对象
		Session session = null;
		//2.开启事务
		Transaction tran = null;
		try {
			//获取session对象
			session = HibernateUtil.getCurrentSession();
			//��������ķ���
			tran = session.beginTransaction();
			//session����(��ɾ�Ĳ����)
			session.save(order);
			//�����ύ
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();//����ع��������쳣��ʱ�򷵻���һ�ε�״̬
			
		} 		
	}

	/* 2.�û��Լ���Ӷ������飨����һ���������飩
	 */
	@Override
	public void addOrderItems(OrderItem item) {
		// TODO Auto-generated method stub
		//1.��ȡsession����
				Session session = null;
				//2.��������
				Transaction tran = null;
				try {
					//��ȡsession�ķ���
					session = HibernateUtil.getCurrentSession();
					//��������ķ���
					tran = session.beginTransaction();
					//session����(��ɾ�Ĳ����)
					session.save(item);
					//�����ύ
					tran.commit();
				} catch (Exception e) {
					e.printStackTrace();
					tran.rollback();//����ع��������쳣��ʱ�򷵻���һ�ε�״̬
					
				} 
		
	}

	/* 3.�û���ѯ�Լ������ж�����¼
	 */
	@Override
	public List<Order> findAllRecords(User user) {
		// TODO Auto-generated method stub
		//1.��ȡsession����
		Session session = null;
		//2.��������
		Transaction tran = null;
		try {
			//��ȡsession�ķ���
			session = HibernateUtil.getCurrentSession();
			//��������ķ���
			tran = session.beginTransaction();
			//��ȡQuery���󣬲�ѯ
			Query query=session.createQuery("from Order where uid=?");//hql:�����û�idȷ����ǰ�û������ж���
			//ʹ��query�����list���������б����ʽ��ʾ�����ļ�¼
			List<Order> list=query.list();
			
			//�����ύ
			tran.commit();
			return list;//�����б�
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();//����ع��������쳣��ʱ�򷵻���һ�ε�״̬
			
		}
		return null;
	}

	/* 4.����Ա���ݶ���id��ѯ����
	 */
	@Override
	public Order findOrderByid(String id) {
		//1.��ȡsession����
				Session session = null;
				//2.��������
				Transaction tran = null;
				try {
					//��ȡsession�ķ���
					session = HibernateUtil.getCurrentSession();
					//��������ķ���
					tran = session.beginTransaction();
					//��ȡQuery���󣬲�ѯ
					Query query=session.createQuery("from Order where id=?");//hql:�����û�idȷ����ǰ�û������ж���
					//ʹ��query����
					query.setParameter(0, id);
					Order order=(Order) query.uniqueResult();//����ǿתת����obejct-->Order
					
					//�����ύ
					tran.commit();
					return order;//�����б�
				} catch (Exception e) {
					e.printStackTrace();
					tran.rollback();//����ع��������쳣��ʱ�򷵻���һ�ε�״̬
					
				}
				return null;
	}

	/* ����Ա��ѯ���ж���
	 */
	@Override
	public List<Order> findAllOrders() {
		//1.��ȡsession����
				Session session = null;
				//2.��������
				Transaction tran = null;
				try {
					//��ȡsession�ķ���
					session = HibernateUtil.getCurrentSession();
					//��������ķ���
					tran = session.beginTransaction();
					//��ȡQuery���󣬲�ѯ
					Query query=session.createQuery("from Order ");//hql:�����û�idȷ����ǰ�û������ж���
					//ʹ��query�����list���������б����ʽ��ʾ�����ļ�¼
					List<Order> list=query.list();
					
					//�����ύ
					tran.commit();
					return list;//�����б�
				} catch (Exception e) {
					e.printStackTrace();
					tran.rollback();//����ع��������쳣��ʱ�򷵻���һ�ε�״̬
					
				}
				return null;
		
	}

	
	

	
}
