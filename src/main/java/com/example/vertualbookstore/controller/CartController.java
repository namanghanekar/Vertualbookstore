package com.example.vertualbookstore.controller;


import com.example.vertualbookstore.entity.Cart;
import com.example.vertualbookstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // Add Book to Cart
    @PostMapping("/add/{bookId}")
    public String addToCart(@PathVariable Long bookId) {
        cartService.addToCart(bookId);
        return "Book added to cart";
    }

    // View My Cart
    @GetMapping("/my")
    public List<Cart> getMyCart() {
        return cartService.getMyCart();
    }

    // Remove from cart
    @DeleteMapping("/remove/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
        return "Removed from cart";
    }
}

