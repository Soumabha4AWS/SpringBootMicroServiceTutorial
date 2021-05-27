package com.spring.microservice.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.microservice.user.entity.User;
import com.spring.microservice.user.repository.UserRepository;
import com.spring.microservice.user.valueobject.Department;
import com.spring.microservice.user.valueobject.ReponseTemplateValueObject;


@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

		
	public List<User> findAllUserId() {
		return userRepository.findAll();
	}
	
	public User findByUserId(Long UserId) {		
		return userRepository.findByUserId(UserId);									
	}


	public ReponseTemplateValueObject findWithDepartmentByUserId(Long userId) {
		ReponseTemplateValueObject reponseTemplateValueObject = new ReponseTemplateValueObject();
		User user = userRepository.findByUserId(userId);	
		Department department = restTemplate.getForObject("http://Department-Service/departments/"+user.getDepartmentId(), Department.class);
		reponseTemplateValueObject.setUser(user);
		reponseTemplateValueObject.setDepartment(department);
		return reponseTemplateValueObject;
	}


	
	
}
