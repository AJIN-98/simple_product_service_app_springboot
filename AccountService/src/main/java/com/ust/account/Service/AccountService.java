package com.ust.account.Service;

import java.util.List;
import com.ust.account.dto.accountDto;

import com.ust.account.Exception.userNotFoundException;
import com.ust.account.model.User;

public interface AccountService {				
	boolean addUser(accountDto user);
	boolean updateUser(accountDto user) throws userNotFoundException;
	accountDto getUser(int accountId) throws userNotFoundException;
	List<accountDto> sortByFirstName();
	List<accountDto> sortByLastName();
	List<accountDto> sortByAge();
}
