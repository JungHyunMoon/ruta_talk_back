package com.rutatalk.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private static final String[] PERMIT_ALL = {
			"/",
			"/css/**", "/img/**",
			"/api/*/users/join",
			"/api/*/users/login",
			"/users/join",
	};
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().disable()
				.csrf().disable()			//csrf 방지
				.cors().and();

		httpSecurity.authorizeHttpRequests(requests -> requests
//				.requestMatchers(PERMIT_ALL).permitAll()
				.anyRequest().permitAll()
		);
		return httpSecurity.getOrBuild();
	}
}
