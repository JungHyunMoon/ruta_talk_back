package com.rutatalk.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.schedule.entity.Schedule;
import com.rutatalk.schedule.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRespository;
	
	@Transactional(readOnly = true)
	public List<Schedule> getSchedulesByRoomId(Long ChatRoomId) {
		List<Schedule> schedules = scheduleRespository.findScheduleByChatRoomId(ChatRoomId);
		return schedules;
	}
}
