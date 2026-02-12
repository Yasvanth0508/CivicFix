package com.civicfix.civicfix.auth.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_identity")
public class AuthIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;   // LOGIN KEY

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;    // USER / WORKER / ADMIN

    @Column(nullable = false)
    private Long referenceId;

    private boolean enabled = true;

    public AuthIdentity() {}

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
