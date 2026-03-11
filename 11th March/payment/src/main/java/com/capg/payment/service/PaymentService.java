package com.capg.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.payment.entity.Payment;
import com.capg.payment.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPayment(int id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
