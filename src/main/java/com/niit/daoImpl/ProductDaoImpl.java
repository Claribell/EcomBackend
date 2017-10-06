package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDao;
import com.niit.model.Cart;
import com.niit.model.Product;

@Repository("ProductDaoImpl")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> product=session.createCriteria(Product.class).list();
		session.getTransaction().commit();
		return product;
		
	}

	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class,id);
		session.getTransaction().commit();
		return product;
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		session.delete(product);
		session.getTransaction().commit();
		session.close();	
	}

	public void save(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		session.close();
		
	}

	public void update(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
		
	}


}
