package com.rutatalk.infra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.ChatRoomEntity;
import com.rutatalk.infra.repository.ChatRoomRepository;

@Service
public class ChatRoomService {
	
	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	// 채팅방 생성
	@Transactional
	public int createChatRoom (ChatRoomEntity chatRoomEntity) {
		
		ChatRoomEntity saveRoom = chatRoomRepository.save(chatRoomEntity);
		if(saveRoom != null) {
			return 1;
		} else return 0;
		
	}
	
	// 채팅방 전체 반환
	@Transactional(readOnly = true)
	public List<ChatRoomEntity> selectListChatRoomById(Long chatRoomId){
		// 채팅방 생성 순서 최근 순으로 반환
		List<ChatRoomEntity> chatRoomEntityList = chatRoomRepository.findAllById(chatRoomId);
		return chatRoomEntityList;
	}
	
	// 룸코드로 채팅방 있는지 확인
	@Transactional(readOnly = true)
	public ChatRoomEntity selectRoomById(Long roomCode) {
		ChatRoomEntity roomInfo = chatRoomRepository.findByRoomCode(roomCode);
		return roomInfo;
	}
	
}
