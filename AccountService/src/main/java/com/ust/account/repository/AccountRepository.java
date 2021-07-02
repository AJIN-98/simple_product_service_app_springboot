package com.ust.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.account.model.User;

public interface AccountRepository extends JpaRepository<User, String> {	//jpa repository
	
	User getByAccountId(int accountId);		//returns user details by id 
}
