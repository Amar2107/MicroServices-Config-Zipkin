package com.dailycodebuffer.departmentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.departmentservice.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>{

	Department findByDepartmentId(Long departmentId);

}
