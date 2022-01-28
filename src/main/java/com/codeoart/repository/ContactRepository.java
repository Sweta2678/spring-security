package com.codeoart.repository;

import org.springframework.data.repository.CrudRepository;

import com.codeoart.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	
	
}
