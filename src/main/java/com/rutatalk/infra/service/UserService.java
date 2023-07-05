package com.rutatalk.infra.service;

import com.rutatalk.auth.JwtTokenUtil;
import com.rutatalk.exception.CustomException;
import com.rutatalk.exception.ErrorCode;
import com.rutatalk.infra.dto.UserLoginRequest;
import com.rutatalk.infra.dto.UserLoginResponse;
import com.rutatalk.infra.entity.TokenEntity;
import com.rutatalk.infra.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private TokenRepository tokenRepository;
	@Value("${jwt.token.secret}")
	private String secretKey;
	private long accessExpireTimeMs = 1000 * 60 * 60;
	//    private long accessExpireTimeMs = 1000 * 3;
	private long refreshExpireTimeMs = 1000 * 60 * 60 * 6;
//    private long refreshExpireTimeMs = 1000 * 30;

	@Transactional
	public UserEntity findUserByLoginId(String loginId){
		return userRepository.findByLoginId(loginId);
	}
	@Transactional(readOnly = true)
	public int getUserByLoginIdPassword(String loginId, String password) {
		
		log.info(loginId + " BO 부분 로그인아이디 입니다.");
		UserEntity user1 = userRepository.findByLoginId(loginId);
		log.info(user1 + " 레퍼지토리에서 나온 값입니다.");
		
		/*
		String encodedPassword = user1.getPassword();
		log.info(encodedPassword + " encodedPassword 나옴");
		log.info(password + " password파라미터값 나옴");
		*/
		
		if(user1 != null && bCryptPasswordEncoder.matches(password, user1.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
	public UserLoginResponse login(UserLoginRequest req){
		UserEntity user = userRepository.findByLoginId(req.getLoginId());

		if(!bCryptPasswordEncoder.matches(req.getPassword(), user.getPassword())){
			throw new CustomException(ErrorCode.INVALID_PASSWORD);
		}
		String jwtToken = JwtTokenUtil.createToken(user.getLoginId(), secretKey, accessExpireTimeMs);
		String refreshToken = JwtTokenUtil.createToken(user.getLoginId(), secretKey, refreshExpireTimeMs);

		tokenRepository.save(TokenEntity.builder()
						.accessToken(jwtToken)
						.refreshToken(refreshToken)
				.build());
		return new UserLoginResponse(jwtToken, refreshToken);
	}
	@Transactional
	public int addUser(String loginId, String password, String realName, String email) {
		
		// password 암호화
		password = bCryptPasswordEncoder.encode(password);
		
		UserEntity user1 = new UserEntity();
		user1.setLoginId(loginId);
		user1.setPassword(password);
		user1.setRealName(realName);
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
