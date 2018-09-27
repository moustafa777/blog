package com.mum.ea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mum.ea.entities.User;
import com.mum.ea.service.UserService;

@RestController
@RequestMapping("/signup")
public class SingupController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public void register(@RequestBody User user) {
		
		// validate user existence
		
		userService.saveUser(user);
	}
	@GetMapping("/test")
	public void test() {
		System.out.println("hhh");
	}

}
