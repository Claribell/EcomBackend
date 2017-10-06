package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Repository("cartDaoImpl")
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}

	public void save(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
		session.close();
		}

	public void update(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();
		
	}

	public List<Cart> getAllCart() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cart=session.createCriteria(Cart.class).list();
		session.getTransaction().commit();
		return cart;
		
		
	}

	
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = (Cart) session.get(Cart.class, id);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();
	}

}
