package com.codeoart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	
	@GetMapping("/balance")
	public String getBalanaceDetails() {
		return "Balance details";
	}
}
