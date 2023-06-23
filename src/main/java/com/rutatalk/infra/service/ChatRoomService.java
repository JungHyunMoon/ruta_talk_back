package com.rutatalk.infra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.ChatRoomEntity;
import com.rutatalk.infra.repository.ChatRoomRepository;

@Service
public class ChatRoomService {
	
	@Autowired
	private ChatRoomRepository chatRoomRepository;
	
	@Transactional
	public int createChatRoom (ChatRoomEntity chatRoomEntity) {
		
		ChatRoomEntity saveRoom = chatRoomRepository.save(chatRoomEntity);
		if(saveRoom != null) {
			return 1;
		} else return 0;
		
	}
	
	@Transactional(readOnly = true)
	public List<ChatRoomEntity> findAllRoom(){
		// 채팅방 생성 순서 최근 순으로 반환
		List<ChatRoomEntity> chatRoomEntityList = chatRoomRepository.findAllOrderByIdDesc();
		return chatRoomEntityList;
	}
	
	@Transactional(readOnly = true)
	public ChatRoomEntity selectRoomById(Long roomCode) {
		ChatRoomEntity roomInfo = chatRoomRepository.findByRoomCode(roomCode);
		return roomInfo;
	}
	
}
