package com.user.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class UserSecurityConfig {
//user creation
	@Bean
	// InMemoryUserDetailsManager
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("Arun").password(encoder.encode("123")).roles("USER", "ADMIN").build();
		UserDetails user  = User.withUsername("AK").password(encoder.encode("456")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	// configuring http security
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request.requestMatchers("/auth/welcome").permitAll())
				.authorizeHttpRequests(request -> request.requestMatchers("/auth/user/**").authenticated())
				.authorizeHttpRequests(request -> request.requestMatchers("/auth/admin/**").authenticated())
				.formLogin(withDefaults()).build();
	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests.requestMatchers("/auth/welcome").permitAll())
//                .authorizeHttpRequests(requests -> requests.requestMatchers("/auth/user/***").authenticated()).authorizeHttpRequests(requests -> requests
//                .requestMatchers("/auth/admin/**").authenticated()).formLogin(withDefaults()).build();
//
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
	
}
