package com.rutatalk.infra.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.entity.ChatRoomEntity;
import com.rutatalk.infra.service.ChatMemberService;
import com.rutatalk.infra.service.ChatRoomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Api(value = "ChatRoomRestControllerV1")
@RestController
@RequestMapping("/v1/api/chat")
@Log4j2
public class ChatRoomApiController {
	
	@Autowired
	private ChatRoomService chatRoomService;
	
	@Autowired
	private ChatMemberService chatMemberService;
	
	/**
	 * 채팅방 초기 생성 API
	 * @param name
	 * @param roomImageUrl
	 * @param userIdList
	 * @param session
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
			@ApiParam(value = "채팅방 이미지", required = false, example = "채팅방 이미지") @RequestParam(value = "roomImageUrl", required = false) String roomImageUrl,
			@ApiParam(value = "채팅방 초대 유저 아이디 리스트", required = true) @RequestParam("userList") List<Long> userIdList,
			HttpSession session
			){
		
		Map<String, Object> result = new HashMap<>();
		ChatRoomEntity chatRoomEntity = ChatRoomEntity.builder().name(name).roomImageUrl(roomImageUrl).build();

		int row = chatRoomService.createChatRoom(chatRoomEntity);
		log.info(chatRoomEntity.getId() + "/ chatroom id입니다" + name + "/ chatroom 이름 입니다.");
		
		if(row > 0) {
			// session 관련 & ChatMember DB에 내용 저장
			Long userId = (Long) session.getAttribute("userId");
			
			// 1명일 경우
			/*ChatMemberEntity chatmemberBuild = ChatMemberEntity.builder().userId(userId).chatRoomId(chatRoomEntity.getId()).build();
			ChatMemberEntity chatmemberBuild = ChatMemberEntity.builder().userId(userId).chatRoomId(chatRoomEntity.getId()).build();
			log.info(chatmemberBuild + "create들어가기 전 데이터");
			chatMemberService.createChatMember(chatmemberBuild);*/
			
			// 다수일 경우
			Long chatRoomId = chatRoomEntity.getId();
			//List에 본인 아이디 추가
			userIdList.add(userId);
			int addRow = chatMemberService.addChatMembers(chatRoomId, userIdList);
			
			if (addRow > 0) {
				result.put("code", 5000);
				result.put("result", "채팅방 생성 되었습니다.");
			} else {
				result.put("code", 1100);
				result.put("result", "채팅방 생성 후 친구 초대가 실패하였습니다.");
			}
			
		} else {
			result.put("code", 1000);
			result.put("result", "채팅방 생성에 실패했습니다.");
		}
		
		return result;
		
	}
	
	
	
}
