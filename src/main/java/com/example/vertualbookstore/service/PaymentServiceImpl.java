package com.example.vertualbookstore.service;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Value("${stripe.secret}")
    private String stripeSecret;

    @Override
    public String createPaymentIntent(Double amount) throws Exception {

        Stripe.apiKey = stripeSecret;

        Map<String, Object> params = new HashMap<>();
        params.put("amount", (int)(amount * 100)); // paise
        params.put("currency", "inr");

        PaymentIntent intent = PaymentIntent.create(params);

        return intent.getClientSecret();
    }
}
