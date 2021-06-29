package com.ust.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class productOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@NotNull
	private int accountId;
	@NotNull
	private int productId;
	@NotNull
	private LocalDate createDate;
	@NotNull
	private LocalDate updateDate;
	@NotNull
	private boolean active;
	
	public productOrder() {
		super();
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}

	public productOrder(int orderId, int accountId, int productId, boolean active) {
		super();
		this.orderId = orderId;
		this.accountId = accountId;
		this.productId = productId;
		this.active = active;
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}

	public int getOrderId() {
		return orderId;
	}

//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

//	public void setCreateDate(LocalDate createDate) {
//		this.createDate = createDate;
//	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

//	public void setUpdateDate(LocalDate updateDate) {
//		this.updateDate = updateDate;
//	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
	
	

}
