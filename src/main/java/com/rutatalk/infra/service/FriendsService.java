package com.rutatalk.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.FriendsEntity;
import com.rutatalk.infra.repository.FriendsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FriendsService {

	@Autowired
	private FriendsRepository friendsRepository;
	
	@Transactional
	public int addFriend(Long userId, Long followId) {
		FriendsEntity friends = FriendsEntity.builder().userId(userId).followId(followId).build();
		
		FriendsEntity result = friendsRepository.save(friends);
		
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
