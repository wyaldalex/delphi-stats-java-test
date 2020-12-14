package com.tudux.testing.delphibackendtest.repository;

import org.springframework.data.repository.CrudRepository;

import com.tudux.testing.delphibackendtest.domain.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
	
	

}
