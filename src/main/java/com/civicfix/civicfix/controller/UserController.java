package com.civicfix.civicfix.controller;

import com.civicfix.civicfix.entity.UserEndity;
import com.civicfix.civicfix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.civicfix.civicfix.auth.service.AuthService;

@RestController
@RequestMapping("/auth")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthService authService;

	@PostMapping("/user/register")
	public UserEndity create(@RequestBody UserEndity user) {
		UserEndity savedUser = userService.createUser(user);

		authService.createUserAuth(
				user.getEmail(),
				user.getPassword(),
				savedUser.getId() // use your actual user ID getter
		);
		return savedUser;

	}

}
