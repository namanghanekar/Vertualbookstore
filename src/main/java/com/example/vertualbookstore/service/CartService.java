package com.example.vertualbookstore.service;

import com.example.vertualbookstore.entity.Cart;

import java.util.List;

public interface CartService {

    void addToCart(Long bookId);

    List<Cart> getMyCart();

    void removeFromCart(Long cartId);
}
