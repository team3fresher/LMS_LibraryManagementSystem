/*package com.team3.LMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.LMS.dto.Payment;
import com.team3.LMS.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	PaymentService service;

	@RequestMapping(value = "/payment/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Payment> getPaymentList() {
		return service.getPaymentList();
	}

	@RequestMapping(value = "/payment/findAll", method = RequestMethod.GET)
	@ResponseBody
	public Page<Payment> findAll(Pageable pageable) {
		Page<Payment> payments = service.findAll(pageable);
		return payments;
	}

	@RequestMapping(value = "/payment/add", method = RequestMethod.POST)
	public void addPayment(@RequestBody Payment payment) {
		service.addPayment(payment);
	}
	
	@RequestMapping("/payment/remove/{paymentId}")
	public void removePayment(@PathVariable int paymentId) {
		service.removePayment(paymentId);
	}
	
	@RequestMapping(value = "/payment/get/{paymentId}", method = RequestMethod.GET)
	@ResponseBody
	public Payment getPayment(@PathVariable int paymentId) {
		return service.getPayment(paymentId);
	}
}
*/