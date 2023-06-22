package com.rutatalk.infra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.BoardEntity;
import com.rutatalk.infra.repository.BoardRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public void createBoard(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);
	}
	
	@Transactional(readOnly = true)
	public void deleteBoard(Long boardId) {
		boardRepository.deleteById(boardId);;
	}
	
	@Transactional(readOnly = true)
	public List<BoardEntity> getBoardListByChatRoomId(Long chatRoomId) {
		boardRepository.getById(chatRoomId);
		List<BoardEntity> boardList = new ArrayList<>();
		return boardList;
	}
	
	
}
