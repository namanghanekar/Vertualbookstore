package com.example.vertualbookstore.controller;

import com.example.vertualbookstore.entity.Order;
import com.example.vertualbookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 🔥 Place order from cart
    @PostMapping("/place")
    public Order placeOrder(Authentication authentication) {

        String email = authentication.getName();

        return orderService.placeOrder(email);
    }

}
