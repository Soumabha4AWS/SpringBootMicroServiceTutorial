package com.spring.microservice.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.jwt.model.JwtRequest;
import com.spring.microservice.jwt.model.JwtResponse;
import com.spring.microservice.jwt.service.UserService;
import com.spring.microservice.jwt.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jWTUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String Home() {
		return "Welcome to HomeController";
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials ", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());
		final String token = jWTUtility.generateToken(userDetails);

		return new JwtResponse(token);
	}

}
