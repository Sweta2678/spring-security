package com.codeoart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public String sayWelcome() {
		return "Welcome to the Demo Spring Security Project";
		
	}
}
