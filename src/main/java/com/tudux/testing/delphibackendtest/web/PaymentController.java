package com.tudux.testing.delphibackendtest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tudux.testing.delphibackendtest.domain.Payment;
import com.tudux.testing.delphibackendtest.repository.PaymentRepository;
import com.tudux.testing.delphibackendtest.service.PaymentService;
import com.tudux.testing.delphibackendtest.views.MeanMedianView;

@RestController
public class PaymentController {
	
	@Autowired PaymentRepository paymentRepository;
	
	@Autowired PaymentService paymentService;
	
	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public Iterable<Payment> getAllPayments(){
		return paymentRepository.findAll();
	}

	
	@RequestMapping(value = "/payments-median-mean", method = RequestMethod.GET)
	public MeanMedianView getPaymentsMeanMedianView(){
		return paymentService.getPaymentMeanMedian();
	}
}
