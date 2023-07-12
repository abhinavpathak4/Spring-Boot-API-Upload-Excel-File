package com.excel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "excelProducts")
public class Product {

	@Id
	private Integer productId;
	private String productName;
	private int productQty;
	private double productPrice;
	public Product(Integer productId, String productName, int productQty, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}
