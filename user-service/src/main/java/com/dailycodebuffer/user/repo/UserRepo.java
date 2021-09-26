package com.dailycodebuffer.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{

	User findByUserId(Long userId);

}
