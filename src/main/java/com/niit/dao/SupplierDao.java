package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao {
	
	 public void save(Supplier s);
		
		public void update(Supplier s);
		
		public Supplier getSupById(int id);
		
		public void delete(int id);
		
		public List<Supplier> getAllSuppliers();
		
}
