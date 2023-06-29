package com.rutatalk.infra.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.entity.UserEntity;
import com.rutatalk.infra.service.FriendsService;
import com.rutatalk.infra.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Api(value = "FriendsRestControllerV1")
@RequestMapping("/v1/api/freinds")
@RestController
@Log4j2
public class FriendsApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendsService friendsService;

	@ApiOperation(value = "addFriend", notes = "친구추가 테스트")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "not found")
	})
	@PostMapping(value = "/add-friend")
	public Map<String, Object> addFriend(
			@ApiParam(value = "추가할 아이디", required = true, example = "user123") @RequestParam("loginId") String loginId,
			HttpSession session
			) {
		Map<String, Object> result = new HashMap<>();
		
		UserEntity user = userService.getUserByLoginId(loginId);
		
		if (user == null) {
			result.put("code", 1100);
			result.put("result", "유저를 찾을 수 없습니다.");
			return result;
		} 
		
		Long userId = (Long)session.getAttribute("userId");
		
		int row = friendsService.addFriend(userId, user.getId());
		
		if(row > 0) {
			result.put("code", 5000);
			result.put("result", "올바른 요청입니다.");
		} else {
			result.put("code", 1000);
			result.put("result", "잘못된 요청입니다.");
		}
		
		return result;
	}
}
