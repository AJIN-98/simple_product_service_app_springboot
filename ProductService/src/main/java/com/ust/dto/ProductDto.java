package com.ust.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductDto {

	private int productId;
	private String productName;
	private String productDesc;
	private String productPrice;
	private String subscriptionType;
	private LocalDate createDate;
	private LocalDate updateDate;
	
	
	
	public ProductDto() {
		super();
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}



	public ProductDto(int productId, String productName, String productDesc, String productPrice,
			String subscriptionType) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.subscriptionType = subscriptionType;
		this.createDate=LocalDate.now();
		this.updateDate=LocalDate.now();
	}
}
