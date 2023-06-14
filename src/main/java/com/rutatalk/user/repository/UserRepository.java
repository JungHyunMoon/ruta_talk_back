package com.rutatalk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByLoginId(String loginId);
	
}
