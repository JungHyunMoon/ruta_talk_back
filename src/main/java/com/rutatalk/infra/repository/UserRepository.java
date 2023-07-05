package com.rutatalk.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByLoginId(String loginId);
	UserEntity findByRealName(String realName);
}
