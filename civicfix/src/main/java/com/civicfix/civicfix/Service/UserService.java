package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.UserEndity;
import com.civicfix.civicfix.Repository.UserRepository;

import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public UserEndity createUser(@NonNull UserEndity user)
	{
		return userRepository.save(user);
	}
	
	public List<UserEndity> readAllUsers()
	{
		return userRepository.findAll();
	}
	
	public UserEndity readUserById(@NonNull Long id)
	{
		return userRepository.findById(id).orElse(null);
	}
	
	public UserEndity updateUser(@NonNull Long id, UserEndity newUser)
	{
		UserEndity existingUser = userRepository.findById(id).orElse(null);
		if(existingUser != null)
		{
			existingUser.setName(newUser.getName());
			existingUser.setEmail(newUser.getEmail());
			existingUser.setPassword(newUser.getPassword());
			return userRepository.save(existingUser);
		}
		return null;
	}
	
	public void deleteUser(@NonNull Long id)
	{
		userRepository.deleteById(id);
	}
}
