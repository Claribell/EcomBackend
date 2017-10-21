package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
public class Product implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)                                
	@Column(name = "Product_Id")
	private int id;
	
	@Column(name = "Product_Name")
	@NotEmpty(message = "Product Name is mandatory")
	private String productname;
	
	
	private String description;
	
	
	@NotNull(message="Please provide some price")
	private double price;
	
	
	private int stock;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private String manufacturer;
	
	@Transient
	@Column(name="Image")
	private MultipartFile productImage;
	
	
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	/*@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", description=" + description + ", price="
				+ price + ", stock=" + stock + ", code=" + code + ", manufacturer=" + manufacturer + ", productImage="
				+ productImage + "]";
	}
	
  public Product() {
		
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		
	}*/
	
}
