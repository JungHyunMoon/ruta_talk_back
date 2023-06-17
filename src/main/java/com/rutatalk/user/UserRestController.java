package com.rutatalk.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;

@Api(value = "SwaggerControllerV1")
@RequestMapping("/v1/api")
@RestController
@Log4j2
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 로그인 API
	 * @param loginId
	 * @param password
	 * @return
	 */
	@ApiOperation(value = "signIn", notes = "로그인 테스트")
	@PostMapping(value = "/sign-in")
	public Map<String, Object> signIn(
			@ApiParam(value = "아이디", required = true, example = "test") @RequestParam("loginId") String loginId,
			@ApiParam(value = "비번", required = true, example = "123") @RequestParam("password") String password) {
		Map<String, Object> result = new HashMap<>();
		
		log.info(loginId + " Restconroller 로그인아이디 입니다.");
		
		// select DB
		int userCount = userService.getUserByLoginIdPassword(loginId, password);
		
		if(userCount > 0) {
			result.put("code", 5000);
			result.put("result", "기존 유저가 있습니다.");
		} else {
			result.put("code", 1100);
			result.put("result", "유저를 찾을 수 없습니다.");
		}
		return result;
	}
	
	@ApiOperation(value = "signUp", notes = "회원가입 테스트")
	@PostMapping(value = "/sign-up")
	public Map<String, Object> signUp(
			@ApiParam(value = "아이디", required = true, example = "test") @RequestParam("loginId") String loginId,
			@ApiParam(value = "비번", required = true, example = "123") @RequestParam("password") String password,
			@ApiParam(value = "닉네임", required = true, example = "nickname") @RequestParam("nickname") String nickname,
			@ApiParam(value = "이메일", required = true, example = "email") @RequestParam("email") String email
			) {
		Map<String, Object> result = new HashMap<>();
		
		int row = userService.addUser(loginId, password, nickname, email);
		
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
