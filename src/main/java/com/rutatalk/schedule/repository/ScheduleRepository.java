package com.rutatalk.schedule.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutatalk.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	public List<Schedule> findScheduleByChatRoomId(Long ChatRoomId);
}
