package com.ust.account.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data //lombok annotation for initializing getter setter
public class accountDto {
	
	@Value("accountId")
	private int accountId;
	@Value("firstName")
	private String firstName;
	@Value("middleName")
	private String middleName;
	@Value("lastName")
	private String lastName;
	@Value("age")
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
