package com.niit.dao;

import java.util.List;

import com.niit.model.Orders;

public interface OrdersDao {
	public void save(Orders order);
	public void update(Orders order);
	public void delete(int id);
    public Orders findById(int id);
    public List<Orders> listallOrders();

}
