package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Service.SubService;
import com.ust.model.Subscription;


@RestController
public class SubController {
	
	@Autowired
	SubService service;
	
	@PostMapping("/sub/add")
	public ResponseEntity<String> add(@RequestBody Subscription order){
		try {
			service.addSubscription(order);
			return new ResponseEntity<String>("added!",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to add",HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping("/sub/{id}")
	public ResponseEntity<?> getpro(@PathVariable int id){
		try {
			Subscription od = service.getbysubId(id);
			
			return new ResponseEntity<Subscription>(od,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("user not found",HttpStatus.CONFLICT);
		}
	}
}
