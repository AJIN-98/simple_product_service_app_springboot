package com.ust.dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class OrderDto {
	
	private int orderId;
	private int accountId;
	private int productId;
	private LocalDate createDate;
	private LocalDate updateDate;
	private boolean active;
	
	public OrderDto() {
		super();
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}
	
	public OrderDto(int orderId, int accountId, int productId, boolean active) {
		super();
		this.orderId = orderId;
		this.accountId = accountId;
		this.productId = productId;
		this.active = active;
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}

	
	
	
	
}
