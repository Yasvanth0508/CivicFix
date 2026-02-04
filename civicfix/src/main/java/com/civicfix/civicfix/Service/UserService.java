package com.civicfix.civicfix.Service;

import com.civicfix.civicfix.Endity.UserEndity;
import com.civicfix.civicfix.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepository;
	
	public UserEndity createUser(UserEndity user)
	{
		return userRepository.save(user);
	}
	
	public List<UserEndity> readAllUsers()
	{
		return userRepository.findAll();
	}
	
	public UserEndity readUserById(Long id)
	{
		return userRepository.findById(id).orElse(null);
	}
	
	public UserEndity updateUser(Long id, UserEndity newUser)
	{
		UserEndity existingUser = userRepository.findById(id).orElse(null);
		if(existingUser != null)
		{
			existingUser.setName(newUser.getName());
			existingUser.setEmail(newUser.getEmail());
			existingUser.setPh_no(newUser.getPh_no());
			return userRepository.save(existingUser);
		}
		return null;
	}
	
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}
}
