package com.civicfix.civicfix.auth.controller;

import com.civicfix.civicfix.auth.entity.AuthIdentity;
import com.civicfix.civicfix.auth.service.AuthService;
import com.civicfix.civicfix.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService,
            JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> req) {

        String email = req.get("email");
        String password = req.get("password");

        AuthIdentity auth = authService.authenticate(email, password);

        String token = jwtUtil.generateToken(
                auth.getEmail(),
                auth.getRole(),
                auth.getReferenceId());

        return Map.of("token", token);
    }

    
}
