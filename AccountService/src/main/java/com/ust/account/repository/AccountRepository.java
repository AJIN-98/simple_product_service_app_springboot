package com.ust.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.account.model.User;

public interface AccountRepository extends JpaRepository<User, String> {
	
	User getByAccountId(int accountId);
}
