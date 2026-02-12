package com.civicfix.civicfix.auth.repository;

import com.civicfix.civicfix.auth.entity.AuthIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthIdentityRepository extends JpaRepository<AuthIdentity, Long> {

    Optional<AuthIdentity> findByEmail(String email);
}
