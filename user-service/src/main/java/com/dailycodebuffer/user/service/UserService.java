package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("inside userService save User");
		return userRepo.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		
		log.info("inside userService get User with Departments");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		User user = userRepo.findByUserId(userId);
		
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		
		vo.setDepartment(department);
		vo.setUser(user);
		
		return vo;
	}
}
