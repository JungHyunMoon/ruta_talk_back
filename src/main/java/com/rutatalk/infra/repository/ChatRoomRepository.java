package com.rutatalk.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.ChatRoomEntity;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long>{

	public List<ChatRoomEntity> findAllById(Long chatRoomId);

}
