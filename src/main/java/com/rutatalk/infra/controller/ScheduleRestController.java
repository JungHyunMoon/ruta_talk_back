package com.rutatalk.infra.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.entity.ScheduleEntity;
import com.rutatalk.infra.service.ScheduleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "ScheduleRestControllerV1")
@RequestMapping("/v1/api/schedule")
@RestController
public class ScheduleRestController {

	@Autowired
	private ScheduleService scheduleService;
	
	/**
	 * 일정 API
	 */
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "schdule found")
	})
	@PostMapping(value = "/{roomId}")
	public Map<String, Object> getSchedulesByRoomId(
			@ApiParam(value = "방 아이디", required = true) @RequestParam("chatRoomId") Long chatRoomId) {
		List<ScheduleEntity> schedules = scheduleService.getSchedulesByRoomId(chatRoomId);
		Map<String, Object> result = new HashMap<>();
		result.put("schedules", schedules);
		
		return result;
	}
	
}
