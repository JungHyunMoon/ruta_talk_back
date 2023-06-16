package com.rutatalk.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rutatalk.user.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Controller
public class testController {

	@GetMapping("/test")
	public String test() {
		return "/polygon";
	}
	
	@Operation(summary = "get posts", description = "지역에 대한 posts들 가져오기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @Parameters({
            @Parameter(name = "province", description = "시", example = "경기도"),
            @Parameter(name = "city", description = "도", example = "고양시"),
            @Parameter(name = "hashtag", description = "검색한 해시태그", example = "['#자장면', '#중국집']")
    })
    @ResponseBody
    @GetMapping("/swagger-test")
    public User getPosts(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "loginId") String loginId,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nickname") String nickname,
            @RequestParam(value = "profileUrl") String profileUrl,
            @RequestParam(value = "email") String email
    ) {
        return new User();
    }
}
