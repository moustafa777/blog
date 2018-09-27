package com.mum.ea.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mum.ea.entities.*;
import com.mum.ea.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user,Model model) {
		userService.saveUser(user);
            return "redirect:/";
      
         
       
        


	}
}
