package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.model.Cart;
import com.niit.model.User;

@Repository("usertDaoImpl")
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public UserDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}*/

	public void save(User u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(User u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		session.close();
		
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User u = (User) session.get(User.class, id);
		session.delete(u);
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> u=session.createCriteria(User.class).list();
		session.getTransaction().commit();
		return u;
		
	}

	

}
