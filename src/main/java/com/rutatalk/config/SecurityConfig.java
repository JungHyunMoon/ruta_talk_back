package com.rutatalk.config;

import com.rutatalk.auth.ExceptionHandlerFilter;
import com.rutatalk.auth.JwtTokenFilter;
import com.rutatalk.infra.service.UserService;
import com.rutatalk.security.AuthenticationManager;
import com.rutatalk.security.CustomAccessDeniedHandler;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final AuthenticationManager authenticationManager;
	private final CustomAccessDeniedHandler customAccessDeniedHandler;
	private final UserService userService;
	@Value("${jwt.token.secret}")
	private String secretkey;
	private static final String[] PERMIT_ALL = {
			"/",
			"/css/**", "/img/**",
			"/api/*/users/join",
			"/api/*/users/login",
			"/users/join",
	};

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().disable()
				.csrf().disable()			//csrf 방지
				.cors().and();

		httpSecurity.authorizeHttpRequests(requests -> requests
//				.requestMatchers(PERMIT_ALL).permitAll()
				.anyRequest().permitAll()
		);
		httpSecurity.exceptionHandling()
				.authenticationEntryPoint(authenticationManager)
				.accessDeniedHandler(customAccessDeniedHandler);

		httpSecurity.addFilterBefore(new JwtTokenFilter(secretkey, userService), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new ExceptionHandlerFilter(), JwtTokenFilter.class);
		return httpSecurity.getOrBuild();
	}
}
