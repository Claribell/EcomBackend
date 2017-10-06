package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	
public void save(User u);
	
	public void update(User u);
	
	public User findById(int id);
	
	public void delete(int id);
	
	public List<User> getAllUsers();
	


}
