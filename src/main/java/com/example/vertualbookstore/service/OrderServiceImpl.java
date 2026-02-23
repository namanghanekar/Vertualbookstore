package com.example.vertualbookstore.service;

import com.example.vertualbookstore.entity.*;
import com.example.vertualbookstore.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    @Override
    public Order placeOrder(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Cart> cartItems = cartRepository.findByUser(user);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        double total = cartItems.stream()
                .mapToDouble(c -> c.getBook().getPrice())
                .sum();

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(total);
        order.setStatus(OrderStatus.PENDING);

        // Important: make sure Order entity me List<Book> books ho
        order.setBooks(
                cartItems.stream()
                        .map(Cart::getBook)
                        .toList()
        );

        Order saved = orderRepository.save(order);

        cartRepository.deleteAll(cartItems);

        return saved;
    }
}
