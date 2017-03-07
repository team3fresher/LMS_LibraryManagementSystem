package com.team3.LMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.team3.LMS.dao.PaymentDao;
import com.team3.LMS.dto.Payment;

@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;

	public List<Payment> getPaymentList() {
		return (List<Payment>) paymentDao.findAll();
	}

	public Page<Payment> findAll(Pageable pageable) {
		return paymentDao.findAll(pageable);
	}

	public void addPayment(Payment payment) {
		paymentDao.save(payment);
	}

	public void removePayment(int paymentId) {
		paymentDao.delete(paymentId);
	}

	public Payment getPayment(int paymentId) {
		return paymentDao.findOne(paymentId);
	}
}
