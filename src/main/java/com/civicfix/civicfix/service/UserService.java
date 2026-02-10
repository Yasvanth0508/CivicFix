package com.civicfix.civicfix.service;

import com.civicfix.civicfix.entity.UserEndity;
import com.civicfix.civicfix.repository.UserRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserEndity createUser(@NonNull UserEndity user) {
		return userRepository.save(user);
	}

}
