package com.ust.account.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class accountDto {
	
	private int accountId;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private LocalDate createdate;
	private LocalDate updatedate;
	
	public accountDto() {
		super();
		this.createdate =LocalDate.now();
		this.updatedate =LocalDate.now();
	}
	
	
	public accountDto(int accountId, String firstName, String middleName, String lastName, int age) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.createdate =LocalDate.now();
		this.updatedate =LocalDate.now();
	}

	
	
	
}
