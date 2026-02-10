package com.civicfix.civicfix.auth.service;

import com.civicfix.civicfix.auth.entity.AuthIdentity;
import com.civicfix.civicfix.auth.repository.AuthIdentityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthIdentityRepository authIdentityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthIdentityRepository authIdentityRepository,
            PasswordEncoder passwordEncoder) {
        this.authIdentityRepository = authIdentityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // STEP 2: create auth for USER
    public void createUserAuth(String email, String rawPassword, Long userId) {

        AuthIdentity auth = new AuthIdentity();
        auth.setEmail(email);
        auth.setPassword(passwordEncoder.encode(rawPassword));
        auth.setRole("USER");
        auth.setReferenceId(userId);

        authIdentityRepository.save(auth);
    }

    // STEP 3: authenticate (LOGIN)
    public AuthIdentity authenticate(String email, String rawPassword) {

        AuthIdentity auth = authIdentityRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!auth.isEnabled()) {
            throw new RuntimeException("Account disabled");
        }

        if (!passwordEncoder.matches(rawPassword, auth.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return auth;
    }

    public void createWorkerAuth(
            String email,
            String rawPassword,
            Long workerId) {
        AuthIdentity auth = new AuthIdentity();
        auth.setEmail(email);
        auth.setPassword(passwordEncoder.encode(rawPassword));
        auth.setRole("WORKER");
        auth.setReferenceId(workerId);

        authIdentityRepository.save(auth);
    }
}
