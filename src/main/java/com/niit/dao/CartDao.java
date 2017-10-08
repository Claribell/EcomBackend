package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart cart);
	public List<Cart> getAllCart(String user);
	public Cart findById(int id);
	
	

}
