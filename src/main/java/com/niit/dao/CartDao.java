package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDao {
	public boolean save(Cart cart);
	public void update(Cart cart);
	public void delete(int id);
	public List<Cart> getAllCart();
	
	

}
