package com.rutatalk.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.ChatMemberEntity;

public interface ChatMemberRepository extends JpaRepository<ChatMemberEntity, Long>{

	public List<ChatMemberEntity> findAllById(Long userId);
	
}
