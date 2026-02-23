package com.example.vertualbookstore.service;

import com.example.vertualbookstore.entity.Book;
import com.example.vertualbookstore.entity.Cart;
import com.example.vertualbookstore.entity.User;
import com.example.vertualbookstore.repository.BookRepository;
import com.example.vertualbookstore.repository.CartRepository;
import com.example.vertualbookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void addToCart(Long bookId) {

        User user = getCurrentUser();
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Cart cart = Cart.builder()
                .user(user)
                .book(book)
                .quantity(1)
                .build();

        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getMyCart() {
        return cartRepository.findByUser(getCurrentUser());
    }

    @Override
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
