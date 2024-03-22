package com.user.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserSecurityController {
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome this end point is not secure";
	}

	@GetMapping("/user/userprofile")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String Useprofile() {
		return "welcome to user profile";

	}

	@GetMapping("/admin/adminprofile")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String adminprofile() {
		return "welcome to admin profile";
	}

}
