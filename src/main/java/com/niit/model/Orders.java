package com.niit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int orderid;
	private String productid;
	private double paymenttotal;
	private String username;
	private String address;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public double getPaymenttotal() {
		return paymenttotal;
	}
	public void setPaymenttotal(double paymenttotal) {
		this.paymenttotal = paymenttotal;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
