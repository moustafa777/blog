package com.mum.ea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SingupController {
	
	@GetMapping("/test")
	public void test() {
		
		System.out.println("helloo");
	}

}
