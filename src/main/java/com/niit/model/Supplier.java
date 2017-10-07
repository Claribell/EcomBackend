package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@SuppressWarnings("unused")
@Entity
@Component
@Table(name="Supplier")
public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(name="Supplier_ID",nullable=false)
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSup_name() {
		return sup_name;
	}
	public void setSup_name(String sup_name) {
		this.sup_name = sup_name;
	}
	@Column(name="Supplier Name",nullable=false)
	private String sup_name;
	
	

}
