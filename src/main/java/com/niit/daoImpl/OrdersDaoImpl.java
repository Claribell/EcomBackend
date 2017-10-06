package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.OrdersDao;
import com.niit.model.Cart;
import com.niit.model.Orders;

@Repository("ordersDaoImpl")
public class OrdersDaoImpl implements OrdersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrdersDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}

	public void save(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Orders order) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Orders order = (Orders) session.get(Orders.class, id);
		session.delete(order);
		session.getTransaction().commit();
		session.close();
		
	}

	public Orders findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Orders> listallOrders() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Orders> order=session.createCriteria(Orders.class).list();
		session.getTransaction().commit();
		return order;
	}

	

}
