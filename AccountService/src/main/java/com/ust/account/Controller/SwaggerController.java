package com.ust.account.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
	
	@GetMapping("/")
	public String redirectToSwagger() {
		return "redirect:/swagger-ui.html";
	}
}
