package com.codeoart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codeoart.model.Accounts;
import com.codeoart.model.Customer;
import com.codeoart.repository.AccountsRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountsRepository accountsRepository;
	
	@GetMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts accounts = accountsRepository.findByCustomerId(customer.getId());
		if (accounts != null ) {
			return accounts;
		}else {
			return null;
		}
	}
}
