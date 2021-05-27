package com.spring.microservice.user.valueobject;

import com.spring.microservice.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTemplateValueObject {
	
	private User user;
	private Department department;

}
