package com.codeoart.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codeoart.model.Loans;

public interface LoanRepository extends CrudRepository<Loans,Long>{

	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
