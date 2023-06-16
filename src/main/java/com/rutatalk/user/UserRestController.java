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
	@ApiOperation(value = "sample", notes = "테스트")
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
}
