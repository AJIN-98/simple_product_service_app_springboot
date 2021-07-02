package com.ust.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Subscription {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int subscriptionId;
@NotNull
private int accountId;
@NotNull
private int productId;
@NotNull
private LocalDate startDate;
@NotNull
private LocalDate endDate;


public Subscription() {
	super();
	this.startDate=LocalDate.now();
	this.endDate=LocalDate.now().plusDays(30);
}


public Subscription(int accountId, int productId) {
	super();
	this.accountId = accountId;
	this.productId = productId;
	this.startDate=LocalDate.now();
	this.endDate=LocalDate.now().plusDays(30);
}


public int getSubscriptionId() {
	return subscriptionId;
}


public void setSubscriptionId(int subscriptionId) {
	this.subscriptionId = subscriptionId;
}


public int getAccountId() {
	return accountId;
}


public void setAccountId(int accountId) {
	this.accountId = accountId;
}


public int getProductId() {
	return productId;
}


//public void setProductId(int productId) {
//	this.productId = productId;
//}


public LocalDate getStartDate() {
	return startDate;
}


//public void setStartDate(LocalDate startDate) {
//	this.startDate = startDate;
//}


public LocalDate getEndDate() {
	return endDate;
}


//public void setEndDate(LocalDate endDate) {
//	this.endDate = endDate;
//}



}
