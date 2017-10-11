package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	
	
	
		public List<Product> getAllProducts();

		 public Product getProductById(int id);

		public void delete (int id);

		public void addProduct (Product product);
		
		public void update(Product product);

	}


