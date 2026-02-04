package com.civicfix.civicfix.Controller;

import com.civicfix.civicfix.Endity.UserEndity;
import com.civicfix.civicfix.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/civicfix")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/create")
	public UserEndity create(@RequestBody UserEndity user)
	{
		return userService.createUser(user);
	}
	
	@GetMapping("/user/readall")
	public List<UserEndity> readAll()
	{
		return userService.readAllUsers();
	}
	
	@GetMapping("/user/readbyid/{id}")
	public UserEndity readById(@PathVariable Long id)
	{
		return userService.readUserById(id);
	}
	
	@PutMapping("/user/update/{id}")
	public UserEndity update(@PathVariable Long id, @RequestBody UserEndity user)
	{
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Long id)
	{
		userService.deleteUser(id);
	}
}
