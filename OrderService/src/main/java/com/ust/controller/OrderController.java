package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Converter.DtoConvert;
import com.ust.Service.OrderService;
import com.ust.dto.OrderDto;
import com.ust.model.productOrder;


@RestController
public class OrderController {
	
	@Autowired
	OrderService service;

	
	@PostMapping("order/cart")
	public ResponseEntity<String> place(@RequestBody OrderDto order){
		try {
			service.placeorder(order);
			return new ResponseEntity<String>("order placed",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to place",HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("order/update")
	public ResponseEntity<String> updateodr(@RequestBody OrderDto order){
		try {
			service.updateorder(order);
			return new ResponseEntity<String>("order updated",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to update",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("order/{id}")
	public ResponseEntity<?> place(@PathVariable int id){
		try {
			OrderDto od = service.getById(id);
			return new ResponseEntity<OrderDto>(od,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("user not found",HttpStatus.CONFLICT);
		}
	}
	
		
	}
