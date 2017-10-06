package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	
	
	
		List<Product> getAllProducts();

		Product getProductById(int id);

		void delete (int id);

		void save (Product product);
		
		void update(Product product);

	}


