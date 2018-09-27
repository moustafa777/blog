package com.mum.ea.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mum.ea.entities.Greeting;
import com.mum.ea.service.WebUtils;

@Controller
public class LoginController {

	@Autowired
	UserDetailsService userService;
//	
//	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//	public Model login(Model model) {
//		model.addAttribute("user", new User());
//		return model;
//	}

//	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public ModelAndView login() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("user", new User());
//        model.setViewName("login");
//        return model;
//    }
//
//	@GetMapping
//	public String loginPage(Model model) {
//		System.out.println("ryan");
//		model.addAttribute("user", new User());
//		return "login";
//	}
//	@GetMapping("/login")
//	public String login(Model model) {
//		model.addAttribute("user", new User());
//		return "login";
//	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
     
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        return "userInfoPage";
    }

//	
	@PostMapping("/login")
	public UserDetails logingPage(@RequestParam("userName") String userName, @RequestParam("password") String password) {

		return userService.loadUserByUsername(userName);

//		 return "login";
	}

//	@PostMapping("/login")
//	public String login(@ModelAttribute User user, Model model) {
//		if (userService.loadUserByUsername(user.getUserName()) != null) {
//			return "redirect:/";
//		} else {
//			model.addAttribute("error", "User Name or Password is wrong");
//			return "login";
//		}
//	}



}
