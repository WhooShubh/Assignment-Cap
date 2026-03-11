package com.capg.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
