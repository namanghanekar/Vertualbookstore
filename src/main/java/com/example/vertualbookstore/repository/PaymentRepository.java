package com.example.vertualbookstore.repository;

import com.example.vertualbookstore.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

