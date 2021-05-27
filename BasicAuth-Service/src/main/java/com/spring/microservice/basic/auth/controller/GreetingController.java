package com.spring.microservice.basic.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@GetMapping("/admin-auth/greeting")
	public String authGreeting() {
		return "Hello GoodMorning Admin !! How are You ? ";
	}
	
	@GetMapping("/user-auth/greeting")
	public String userAuthGreeting() {
		return "Hello GoodMorning User !! How are You ? ";
	}
	
	
	@GetMapping("/no-auth/greeting")
	public String noAuthGreeting() {
		return "Hello GoodMorning No Auth Users !! How are You ? ";
	}

}