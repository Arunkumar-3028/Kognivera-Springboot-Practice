package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home";
	}

	@GetMapping("/user")
	public String normaluser() {
		return "normal user page";
	}

	@GetMapping("/admin")
	public String adminuser() {
		return "admin user page";
	}
}
