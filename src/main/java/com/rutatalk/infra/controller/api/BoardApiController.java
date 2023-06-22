package com.rutatalk.infra.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rutatalk.infra.entity.BoardEntity;
import com.rutatalk.infra.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Api(value = "BoardRestControllerV1")
@RequestMapping("/v1/api/board")
@RestController
@Log4j2
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	/**
	 * 글쓰기 API
	 * @param scheduleId
	 * @param subject
	 * @param content
	 * @param imageUrl
	 * @return
	 */
	@ApiOperation(value = "createBoard", notes = "게시글 생성")
	@ApiResponses({
		@ApiResponse(code = 200, message = "ok"),
		@ApiResponse(code = 500, message = "server error"),
		@ApiResponse(code = 404, message = "not found")
	})
	@PostMapping(value = "/board")
	public Map<String, Object> createBoard(
			@ApiParam(value = "게시글", required = true, example = "게시글 Entity") @RequestBody BoardEntity boardEntity
			) {
		
		log.info(boardEntity.getUserId() + " Restconroller 유저아이디 입니다.");
		
		// schedule 객채를 통채로 parameter로 가져올지 논의
		boardService.createBoard(boardEntity);
		Map<String, Object> result = new HashMap<>();
		result.put("code", "5000");
		result.put("result", "글이 성공적으로 게시되었습니다");
		return result;
	};
	
	@ApiOperation(value = "deleteBoard", notes = "must need boardId")
	@DeleteMapping(value = "{boardId}")
	public Map<String, Object> deleteBoard(
			@ApiParam(value = "게시글 ID", required = true, example = "1") @PathVariable("boardId") Long boardId
			) {
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 5000);
		result.put("result", "글이 성공적으로 삭제되었습니다");
		return result;
	}
	
}
