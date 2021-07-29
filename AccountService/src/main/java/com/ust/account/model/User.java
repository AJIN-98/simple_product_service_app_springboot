package com.ust.account.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity	
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	@NotNull
	private String firstName;
	@NotNull
	private String middleName;
	@NotNull
	private String lastName;
	@NotNull
	private int age;
	private LocalDate createdate;
	private LocalDate updatedate;
	
	public User() {
		super();
		this.createdate =LocalDate.now();
		this.updatedate =LocalDate.now();
	}

	public User(String firstName, String middleName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.createdate =LocalDate.now();
		this.updatedate =LocalDate.now();
	}

	public int getAccountId() {
		return accountId;
	}

//	public void setAccountId(String accountId) {
//		this.accountId = accountId;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public LocalDate getCreatedate() {
//		return createdate;
//	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public LocalDate getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}
	
	
}