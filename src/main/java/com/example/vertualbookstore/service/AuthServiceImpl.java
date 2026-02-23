package com.example.vertualbookstore.service;

import com.example.vertualbookstore.config.JwtUtil;
import com.example.vertualbookstore.dto.AuthResponse;
import com.example.vertualbookstore.dto.LoginRequest;
import com.example.vertualbookstore.dto.RegisterRequest;
import com.example.vertualbookstore.dto.RegisterResponse;
import com.example.vertualbookstore.entity.User;
import com.example.vertualbookstore.entity.Role;
import com.example.vertualbookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return new RegisterResponse("User Registered Successfully");
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token, "Login Successful");
    }
}