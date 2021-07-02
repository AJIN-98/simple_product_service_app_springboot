package com.ust.account.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.account.Converter.DtoConvert;
import com.ust.account.Exception.userNotFoundException;
import com.ust.account.dto.accountDto;
import com.ust.account.model.User;
import com.ust.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository repository;
	@Autowired
	DtoConvert convert;

	@Override
	public boolean addUser(accountDto user) {					//add user
		try {
			repository.save(convert.dtoToEntity(user));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateUser(accountDto user) {				//update user
		try {
			User us=repository.getByAccountId(user.getAccountId());
			if(us!=null) {
				us.setFirstName(user.getFirstName());
				us.setLastName(user.getLastName());
				us.setMiddleName(user.getMiddleName());
				us.setAge(user.getAge());
				repository.save(us);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public accountDto getUser(int accountId) throws userNotFoundException { //get user by id
		try {
			User us=repository.getByAccountId(accountId);
			return convert.entityToDto(us);
		} catch (Exception e) {
			throw new userNotFoundException("user not found");
		}
			
	}

	@Override
	public List<accountDto> sortByFirstName() {							//sort by first name
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
		return convert.entityToDto(list);
	}

	@Override
	public List<accountDto> sortByLastName() {							//sort by last name
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparing(User::getLastName)).collect(Collectors.toList());
		return convert.entityToDto(list);
	}

	@Override
	public List<accountDto> sortByAge() {	//sort by age
		List<User> list=repository.findAll();
		list=list.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
		return convert.entityToDto(list);
	}

}
