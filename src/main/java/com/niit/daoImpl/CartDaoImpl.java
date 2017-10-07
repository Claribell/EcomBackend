package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Repository("cartDao")
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public CartDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}*/
   /*@Transactional
	public void save(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cart);
		session.getTransaction().commit();
		session.close();
		}*/
   @Transactional
	public void update(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();
		
	}
   @Transactional
	public List<Cart> getAllCart() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cart=session.createCriteria(Cart.class).list();
		session.getTransaction().commit();
		return cart;
		
		
	}

   @Transactional
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = (Cart) session.get(Cart.class, id);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();
	}
   @Transactional
public boolean save(Cart cart) {
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception arised:"+e);
		return false;
	}
	
}

}
