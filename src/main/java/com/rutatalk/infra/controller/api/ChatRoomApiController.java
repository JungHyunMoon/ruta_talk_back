package com.rutatalk.infra.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.entity.ChatRoomEntity;
import com.rutatalk.infra.service.ChatRoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.log4j.Log4j2;

@Api(value = "ChatRoomRestControllerV1")
@RestController
@RequestMapping("/v1/api/chat")
@Log4j2
public class ChatRoomApiController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	/**
	 * 채팅방 생성 API
	 * @param name
	 * @param roomCode
	 * @param roomImageUrl
	 * @return
	 */
	@ApiOperation(value = "createChatRoom", notes = "채팅방 생성")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "not found")
	})
	@PostMapping(value = "/room-creation")
	public Map<String, Object> createChatRoom(
			@ApiParam(value = "채팅방 이름", required = true, example = "test") @RequestParam("name") String name,
			@ApiParam(value = "채팅방 코드", required = true, example = "1000") @RequestParam("roomCode") Long roomCode,
			@ApiParam(value = "채팅방 이미지", required = false, example = "채팅방 이미지") @RequestParam(value = "roomImageUrl", required = false) String roomImageUrl			
			){
		
		Map<String, Object> result = new HashMap<>();
		ChatRoomEntity chatRoomEntity = ChatRoomEntity.builder().name(name).roomCode(roomCode).roomImageUrl(roomImageUrl).build();
		log.info(chatRoomEntity.getId() + "/" + name + "chatroom id입니다 / chatroom 이름 입니다.");
		
		int row = chatRoomService.createChatRoom(chatRoomEntity);
		if(row > 0) {
			result.put("code", 5000);
			result.put("result", "채팅방 생성 되었습니다.");
		} else {
			result.put("code", 1000);
			result.put("result", "채팅방 생성에 실패했습니다.");
		}
		
		return result;
		
	}
	
	
	
}
