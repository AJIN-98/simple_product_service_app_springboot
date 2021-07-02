package com.ust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
	
	@GetMapping("/")	//swagger 
	public String redirectToSwagger() {
		return "redirect:/swagger-ui.html";
	}
}
