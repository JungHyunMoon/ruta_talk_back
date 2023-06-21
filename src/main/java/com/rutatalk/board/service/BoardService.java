package com.rutatalk.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.board.entity.Board;
import com.rutatalk.board.repository.BoardRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public void createBoard(Long scheduleID, Long userId, String subject, String content, String imageUrl) {
		Board board = new Board();
//		board.setChatRoomId(schedule.getChatRoomId()); // schdule 객체에서 roomId 추출
		board.setSchduleId((long) 1); // test code
		board.setUserId(userId);
		board.setContent(content);
		board.setSubject(subject);
		board.setImageUrl(imageUrl); // file 기능 아직 미구현
		boardRepository.save(board);
		
	}
}
