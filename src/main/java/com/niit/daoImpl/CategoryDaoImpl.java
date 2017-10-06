package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;
import com.niit.model.Cart;
import com.niit.model.Category;

@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)  {
		this.sessionFactory = sessionFactory;
	}

	public void save(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		session.close();	
		
	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> category=session.createCriteria(Category.class).list();
		session.getTransaction().commit();
		return category;
		
	}

	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = (Category) session.get(Category.class, id);
		session.delete(category);
		session.getTransaction().commit();
		session.close();
		
	}

}
