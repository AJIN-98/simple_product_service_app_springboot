package com.ust.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@NotNull
	private String productName;
	@NotNull
	private String productDesc;
	@NotNull
	private String productPrice;
	@NotNull
	private String subscriptionType;
	@NotNull
	private LocalDate createDate;
	@NotNull
	private LocalDate updateDate;
	
	public Product() {
		super();
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}

	public Product(String productName, String productDesc, String productPrice, String subscriptionType) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.subscriptionType = subscriptionType;
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}

	public int getProductId() {
		return productId;
	}

//	public void setProductId(int productId) {
//		this.productId = productId;
//	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

//	public LocalDate getCreateDate() {
//		return createDate;
//	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
