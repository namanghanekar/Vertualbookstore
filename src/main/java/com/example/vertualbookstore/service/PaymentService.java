package com.example.vertualbookstore.service;

public interface PaymentService {
    String createPaymentIntent(Double amount) throws Exception;
}
