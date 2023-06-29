package com.rutatalk.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.infra.entity.UserEntity;
import com.rutatalk.infra.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// session에서 userId 불러오기위한 과정 -추후 삭제
	@Transactional(readOnly = true)
	public UserEntity getUserByLoginId(String loginId) {
		UserEntity user = userRepository.findByLoginId(loginId);
		return user;
	}
	
	@Transactional(readOnly = true)
	public int getUserByLoginIdPassword(String loginId, String password) {
		
		log.info(loginId + " BO 부분 로그인아이디 입니다.");
		UserEntity user = userRepository.findByLoginId(loginId);
		log.info(user + " 레퍼지토리에서 나온 값입니다.");
		
		if(user != null && passwordEncoder.matches(password, user.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Transactional
	public int addUser(String loginId, String password, String nickname, String email) {
		
		// password 암호화
		password = passwordEncoder.encode(password);
		
		UserEntity user1 = new UserEntity();
		user1.setLoginId(loginId);
		user1.setPassword(password);
		user1.setNickname(nickname);
		user1.setEmail(email);
		
		log.info(user1 + "BO 부분 회원가입");
		
		UserEntity result = userRepository.save(user1);
		
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}

}
