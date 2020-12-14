package com.tudux.testing.delphibackendtest.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudux.testing.delphibackendtest.domain.Payment;
import com.tudux.testing.delphibackendtest.repository.PaymentRepository;
import com.tudux.testing.delphibackendtest.views.MeanMedianView;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public MeanMedianView getPaymentMeanMedian() {

		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		MeanMedianView meanMedianView = null; 

		paymentRepository.findAll();
		List<Payment> payments = StreamSupport.stream(paymentRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());

		// Add the data from the array
		for (Payment payment : payments) {
			stats.addValue(payment.getAmount().doubleValue());
		}

		double mean = stats.getMean();
		double median = stats.getPercentile(50);
		return new MeanMedianView(mean,median);

	}

}
