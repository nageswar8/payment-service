package com.nag.payment_service.repository;

import com.nag.payment_service.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentTransaction, String> {
}
