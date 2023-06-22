package com.rutatalk.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.infra.entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long>{
	
	public List<ScheduleEntity> findScheduleByChatRoomId(Long ChatRoomId);
}
