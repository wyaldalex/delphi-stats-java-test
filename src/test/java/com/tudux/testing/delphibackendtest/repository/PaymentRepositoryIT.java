package com.tudux.testing.delphibackendtest.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tudux.testing.delphibackendtest.domain.Payment;

//@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PaymentRepositoryIT {
	
	@Autowired
	private PaymentRepository paymentRepository;
		
	@Test
	public void testExtractAllPayments() {
		
		
		paymentRepository.findAll();
		List<Payment> payments = Lists.newArrayList( paymentRepository.findAll());
		
		for(Payment payment : payments) {
			System.out.println(payment.getAmount());
			System.out.println(payment.toString());
			
		}
		
		 		 
		
	}

}
