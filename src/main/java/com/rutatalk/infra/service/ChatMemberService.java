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
	
	public int addChatMembers(Long chatRoomId, List<Long> userIdList) {
		int result = 0;
		for (Long id : userIdList) {
			ChatMemberEntity chatMeberEntity = ChatMemberEntity.builder().userId(id).chatRoomId(chatRoomId).build();
			ChatMemberEntity addChatMember = chatMemberRepository.save(chatMeberEntity);
			if (addChatMember != null) {
				result++;
			} 
		}
		if (result == userIdList.size()) {
			return 1;
		} else return 0;
	}
	
	// 채팅방 정보 불러오기
	public List<ChatMemberEntity> selectListChatMember(Long userId){
		List<ChatMemberEntity> chatMemberList = chatMemberRepository.findAllById(userId);
		return chatMemberList;
	}
	
	public void deleteChatMember(Long chatRoomId, Long userId) {
		ChatMemberEntity chatMeberEntity = ChatMemberEntity.builder().userId(userId).chatRoomId(chatRoomId).build();
		chatMemberRepository.delete(chatMeberEntity);
	}

}
