package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ust.Service.ProductService;
import com.ust.dto.ProductDto;


@ComponentScan
@RestController
public class productController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("product/add")
	public ResponseEntity<String> add(@RequestBody ProductDto product){
		try {
			service.addProduct(product);
			return new ResponseEntity<String>("product added",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to add",HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("product/update")
	public ResponseEntity<String> update(@RequestBody ProductDto product){
		try {
			service.updateProduct(product);
			return new ResponseEntity<String>("updated",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to update",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("product/{productId}")
	public ResponseEntity<?> getbyid(@PathVariable int productId){
		try {
			return new ResponseEntity<ProductDto>(service.getProduct(productId), HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
	}
}
