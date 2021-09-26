package com.dailycodebuffer.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.repo.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	public Department saveDepartment(Department department) {
		log.info("inside DepartmentService's saveDepartment");
		return departmentRepo.save(department);
	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("inside DepartmentServices's findDepartmentById");
		return departmentRepo.findByDepartmentId(departmentId);
	}
	
}