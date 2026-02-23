package com.example.vertualbookstore.service;

import com.example.vertualbookstore.entity.Order;

public interface OrderService {

    Order placeOrder(String email);

}
