package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	public void save(Category category);
	public void update(Category category);
	public void delete(int id);
	public Category findById(int id);
	public List<Category>getAllCategories();
}



