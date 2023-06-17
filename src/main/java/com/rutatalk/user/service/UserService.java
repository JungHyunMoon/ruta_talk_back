package com.rutatalk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rutatalk.user.entity.User;
import com.rutatalk.user.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public int getUserByLoginIdPassword(String loginId, String password) {
		
		log.info(loginId + " BO 부분 로그인아이디 입니다.");
		User user1 = userRepository.findByLoginId(loginId);
		log.info(user1 + " 레퍼지토리에서 나온 값입니다.");
		
		/*
		String encodedPassword = user1.getPassword();
		log.info(encodedPassword + " encodedPassword 나옴");
		log.info(password + " password파라미터값 나옴");
		*/
		
		if(user1 != null && passwordEncoder.matches(password, user1.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Transactional
	public int addUser(String loginId, String password, String nickname, String email) {
		
		// password 암호화
		password = passwordEncoder.encode(password);
		
		User user1 = new User();
		user1.setLoginId(loginId);
		user1.setPassword(password);
		user1.setNickname(nickname);
		user1.setEmail(email);
		
		log.info(user1 + "BO 부분 회원가입");
		
		User result = userRepository.save(user1);
		
		if (result != null) {
			return 1;
		} else {
			return 0;
		}
	}

}
