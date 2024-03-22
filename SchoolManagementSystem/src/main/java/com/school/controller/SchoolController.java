package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SecurityContextLogoutHandler securityContextLogoutHandler;

		@GetMapping("/all")
		public String allProfile() {
			return "Welcome to all to the profile";
		}

		@GetMapping("/studentProfile")
		public String studentProfile() {
			return "Welcome student";
		}
        
		
		@GetMapping("/teacherProfile")
		public String teacherProfile() {
			return "Welcome teacher";
		}
		@GetMapping("/studentProfile/logout")
		public String studentlogout(HttpServletRequest request, HttpServletResponse response) {
			securityContextLogoutHandler.logout(request, response, null);
			return "Successfully logged out";
		}
		
		@GetMapping("/teacherProfile/logout")
		public String teacherlogout(HttpServletRequest request, HttpServletResponse response) {
			securityContextLogoutHandler.logout(request, response, null);
			return "Successfully logged out";
		}
	}

	
