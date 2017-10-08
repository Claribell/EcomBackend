package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Query;
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
  
   @Transactional
   public boolean save(Cart cart) {
   	try
   	{
   		sessionFactory.getCurrentSession().save(cart);
   		return true;
   	}
   	catch(Exception e)
   	{
   		System.out.println("Exception arised:"+e);
   		return false;
   	}
   		
   }
public boolean update(Cart cart) {
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
public boolean delete(Cart cart) {
	try
   	{
   		sessionFactory.getCurrentSession().delete(cart);
   		return true;
   	}
   	catch(Exception e)
   	{
   		System.out.println("Exception arised:"+e);
   		return false;
   	}
}
public List<Cart> getAllCart(String user) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Cart where user=:user and status='NP' ");
	query.setParameter("user", user);
	List<Cart> listCartItem=query.list();
	return listCartItem;
}
public Cart findById(int id) {
	Session session=sessionFactory.openSession();
	Cart cart=(Cart)session.get(Cart.class,id);
	session.close();
	return cart;
}
  
	
}


