package com.rutatalk.infra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutatalk.infra.entity.ChatMemberEntity;
import com.rutatalk.infra.repository.ChatMemberRepository;

@Service
public class ChatMemberService {
	
	@Autowired
	private ChatMemberRepository chatMemberRepository;
	
	// 채팅방 생성시 정보 저장
	public void createChatMember(ChatMemberEntity chatMemberEntity) {
		chatMemberRepository.save(chatMemberEntity);
	}
	
	// 채팅방 정보 불러오기
	public List<ChatMemberEntity> selectListChatMember(Long userId){
		List<ChatMemberEntity> chatMemberList = chatMemberRepository.findAllById(userId);
		return chatMemberList;
	}

}
