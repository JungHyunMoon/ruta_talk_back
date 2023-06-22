package com.rutatalk.infra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.ScheduleEntity;
import com.rutatalk.infra.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRespository;
	
	@Transactional(readOnly = true)
	public List<ScheduleEntity> getSchedulesByRoomId(Long ChatRoomId) {
		List<ScheduleEntity> schedules = scheduleRespository.findScheduleByChatRoomId(ChatRoomId);
		return schedules;
	}
}
