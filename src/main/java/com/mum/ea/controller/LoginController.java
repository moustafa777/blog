package com.mum.ea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mum.ea.entities.User;

@RestController
public class LoginController {
	
	@Autowired
	UserDetailsService userService;
//	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//	public String login(Model model) {
//		model.addAttribute("user", new User());
//		return "login";
//	}

	@GetMapping
	public String loginPage() {
		System.out.println("ryan");
		return "login";
	}
	
	@PostMapping("/login")
	public void loginPage(@RequestParam("userName") String userName, @RequestParam("password") String password ) {
		
		userService.loadUserByUsername(userName);
		
		//return "login";
	}

}
