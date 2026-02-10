package com.civicfix.civicfix.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // PUBLIC
                .requestMatchers("/auth/**").permitAll()

                // USER ONLY
                .requestMatchers("/issue/user/**").hasRole("USER")

                // WORKER ONLY
                .requestMatchers("/issue/worker/**").hasRole("WORKER")
                .requestMatchers("/category/worker/**").hasRole("WORKER")

                // USER + WORKER
                .requestMatchers("/category/**").hasAnyRole("USER", "WORKER")

                // EVERYTHING ELSE
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
