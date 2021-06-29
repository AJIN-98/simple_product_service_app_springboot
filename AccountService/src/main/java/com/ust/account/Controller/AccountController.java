package com.ust.account.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.account.Converter.DtoConvert;
import com.ust.account.Exception.userNotFoundException;
import com.ust.account.Service.AccountService;
import com.ust.account.dto.accountDto;

import io.swagger.annotations.Api;

@Api
@RestController
public class AccountController {

	@Autowired AccountService service;
	@Autowired DtoConvert convert;
	
	@PostMapping("user/create")
	public ResponseEntity<String> Create(@RequestBody accountDto user) {
	try {
		service.addUser(user);
		return new ResponseEntity<String>("user added",HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<String>("Failed to create",HttpStatus.CONFLICT);
	}
}
	@PutMapping("user/update")
	public ResponseEntity<String> update(@RequestBody accountDto user){
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("user updated",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to update",HttpStatus.CONFLICT);
		}
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) {
		try {
			accountDto user=service.getUser(id);
			if(user!=null) {
			return new ResponseEntity<accountDto>(service.getUser(id), HttpStatus.OK);
			}
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		} catch (userNotFoundException e) {
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("user/fnamesort")
	public ResponseEntity<?> fsort(){
		
			List<accountDto> list =service.sortByFirstName();
			return new ResponseEntity <List<accountDto>> (list, HttpStatus.OK);
		}
	@GetMapping("user/lnamesort")
	public ResponseEntity<?> lsort(){
		
			List<accountDto> list =(service.sortByLastName());
			return new ResponseEntity <List<accountDto>> (list, HttpStatus.OK);
		}
	@GetMapping("user/agesort")
	public ResponseEntity<?> ageSort(){
		
			List<accountDto> list =service.sortByAge();
			return new ResponseEntity <List<accountDto>> (list, HttpStatus.OK);
		}
	}
	
