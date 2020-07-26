package com.generalsuggestions.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.generalsuggestions.domain.User;
import com.generalsuggestions.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@GetMapping(value = "/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping(value ="/register")
	public String register(ModelMap model)
	{
		model.put("user", new User());
		return "register";
	}
	@PostMapping(value="/register")
	public String rgisterPost(User user)
	{
		User savedUser=userService.save(user);
		System.out.println("non-saved "+user);
		System.out.println("saved "+savedUser);
		return "redirect:/login";
	}

}
