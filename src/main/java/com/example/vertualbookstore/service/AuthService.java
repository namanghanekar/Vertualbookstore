package com.example.vertualbookstore.service;

import com.example.vertualbookstore.dto.AuthResponse;
import com.example.vertualbookstore.dto.LoginRequest;
import com.example.vertualbookstore.dto.RegisterRequest;
import com.example.vertualbookstore.dto.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
