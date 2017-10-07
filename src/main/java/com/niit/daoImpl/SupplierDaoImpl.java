package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDao;
import com.niit.model.Cart;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Repository("SupplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/*public SupplierDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}*/

	public void save(Supplier s) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Supplier s) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(s);
		session.getTransaction().commit();
		session.close();
		
		
	}

	public Supplier getSupById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier s = (Supplier) session.get(Supplier.class, id);
		session.getTransaction().commit();
		return s;
	}


	public List<Supplier> getAllSuppliers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> s=session.createCriteria(Supplier.class).list();
		session.getTransaction().commit();
		return s;
	}
		

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Supplier s = (Supplier) session.get(Supplier.class, id);
		session.delete(s);
		session.getTransaction().commit();
		session.close();
		
	}


}
