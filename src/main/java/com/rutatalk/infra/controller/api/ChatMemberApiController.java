package com.rutatalk.infra.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.service.ChatMemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Api(value = "ChatMemberRestControllerV1")
@RestController
@RequestMapping("/v1/api/chat")
@Log4j2
public class ChatMemberApiController {

	@Autowired
	private ChatMemberService chatMemberService;
	
	/**
	 * 채팅방 초대
	 * @param chatRoomId
	 * @param userIdList
	 * @return
	 */
	@ApiOperation(value = "addChatMember", notes = "채팅방 초대")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "not found")
	})
	@PostMapping(value = "/room-invite")
	public Map<String, Object> addChatMembers(
			@ApiParam(value = "채팅방 아이디", required = true) @RequestParam("chatRoomId") Long chatRoomId,
			@ApiParam(value = "채팅방 초대 유저 아이디 리스트", required = true) @RequestParam("userList") List<Long> userIdList
			) {
		Map<String, Object> result = new HashMap<>();
		
		int row = chatMemberService.addChatMembers(chatRoomId, userIdList);
		
		if (row > 0) {
			result.put("code", 5000);
			result.put("result", "친구 초대가 성공하였습니다.");
		} else {
			result.put("code", 1000);
			result.put("result", "친구 초대가 실패하였습니다.");
		}
		
		return result; 
	}
	
	@ApiOperation(value = "deleteChatMember", notes = "채팅방 퇴장")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "not found")
	})
	@DeleteMapping(value = "/room-exit")
	public Map<String, Object> deleteChatMember(
			@ApiParam(value = "채팅방 아이디", required = true) @RequestParam("chatRoomId") Long chatRoomId,
			@ApiParam(value = "채팅방 퇴장 유저 아이디", required = true) @RequestParam("userList") Long exitUserId,
			HttpSession session
			) {
		Map<String, Object> result = new HashMap<>();
		
		// 세션 유저
		Long userId = (Long)session.getAttribute("userId");
		
		if (exitUserId != userId) {
			result.put("code", 1300);
			result.put("result", "해당 권한이 없습니다.");
			return result;
		}
		
		chatMemberService.deleteChatMember(chatRoomId, userId);
		
		result.put("code", 5000);
		result.put("result", "채팅방 퇴장에 성공하였습니다.");
		
		return result;
	}
}
