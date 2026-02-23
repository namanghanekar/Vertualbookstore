package com.example.vertualbookstore.repository;

import com.example.vertualbookstore.entity.Order;
import com.example.vertualbookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}


