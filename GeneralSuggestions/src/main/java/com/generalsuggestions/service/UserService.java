package com.generalsuggestions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.generalsuggestions.domain.User;
import com.generalsuggestions.repositories.UserRepository;
import com.generalsuggestions.security.Authority;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user)
	{
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Authority authorit= new Authority();
		authorit.setAuthority("ROLE_USER");
		authorit.setUser(user);
		
		user.getAuthorities().add(authorit);
		return userRepo.save(user);
	}
}
