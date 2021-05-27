package com.spring.microservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.user.entity.User;
import com.spring.microservice.user.service.UserService;
import com.spring.microservice.user.valueobject.ReponseTemplateValueObject;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j

public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("****************** Inside saveUser function of UserController ********");
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/allUserId")
	public List<User> findAllUserId() {
		log.info("****************** Inside findAllUserId function of UserController ********");
		return userService.findAllUserId();		
	}
	
	@GetMapping("/{id}")
	public User findByUserId(@PathVariable("id") Long UserId) {
		log.info("****************** Inside findByUserId function of UserController ********");
		return userService.findByUserId(UserId);		
	}
	
	@GetMapping("/withDepartment/{id}")
	public ReponseTemplateValueObject findWithDepartmentByUserId(@PathVariable("id") Long UserId) {
		log.info("****************** Inside findWithDepartmentByUserId function of UserController ********");
		return userService.findWithDepartmentByUserId(UserId);		
	}

}
