package com.tudux.testing.delphibackendtest.statistics;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tudux.testing.delphibackendtest.domain.Payment;
import com.tudux.testing.delphibackendtest.repository.PaymentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SimpleStatisticsIT {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Test
	public void calculateMeanAllPayments() {
		
		DescriptiveStatistics stats = new DescriptiveStatistics();
		

		
		paymentRepository.findAll();
		List<Payment> payments = Lists.newArrayList( paymentRepository.findAll());
		
		// Add the data from the array
		for( Payment payment : payments) {
		        stats.addValue(payment.getAmount().doubleValue());
		}
		
//		for(Payment payment : payments) {
//			System.out.println(payment.getAmount());
//			System.out.println(payment.toString());
//			
//		}
//		
		
		double mean = stats.getMean();
		double median = stats.getPercentile(50);
		System.out.println("The mean obtained is " + mean);
		System.out.println("The median obtained is " + median);
		
		assertTrue(mean > 0);
		assertTrue(median > 0);
		 		 
		
	}
}
