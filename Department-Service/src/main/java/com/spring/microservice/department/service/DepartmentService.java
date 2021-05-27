package com.spring.microservice.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.microservice.department.entity.Department;
import com.spring.microservice.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {		
		return departmentRepository.findByDepartmentId(departmentId);									
	}

	public List<Department> findAllDepartmentId() {
		return departmentRepository.findAll();
	}

}
