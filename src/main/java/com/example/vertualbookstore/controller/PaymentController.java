package com.example.vertualbookstore.controller;

import com.example.vertualbookstore.entity.Order;
import com.example.vertualbookstore.entity.OrderStatus;
import com.example.vertualbookstore.repository.OrderRepository;
import com.example.vertualbookstore.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    // 🔹 Create Stripe PaymentIntent
    @PostMapping("/create/{orderId}")
    public ResponseEntity<?> createPayment(
            @PathVariable Long orderId,
            Authentication authentication
    ) throws Exception {

        String email = authentication.getName();

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getUser().getEmail().equals(email)) {
            return ResponseEntity.status(403).body("Unauthorized");
        }

        if (order.getStatus() == OrderStatus.PAID) {
            return ResponseEntity.badRequest().body("Already Paid");
        }

        String clientSecret =
                paymentService.createPaymentIntent(order.getTotalAmount());

        return ResponseEntity.ok(clientSecret);
    }

    // 🔹 After Stripe Success (Frontend confirmation ke baad)
    @PostMapping("/success/{orderId}")
    public ResponseEntity<?> paymentSuccess(
            @PathVariable Long orderId,
            Authentication authentication
    ) {

        String email = authentication.getName();

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getUser().getEmail().equals(email)) {
            return ResponseEntity.status(403).body("Unauthorized");
        }

        order.setStatus(OrderStatus.PAID);
        orderRepository.save(order);

        return ResponseEntity.ok("Payment Successful");
    }
}
