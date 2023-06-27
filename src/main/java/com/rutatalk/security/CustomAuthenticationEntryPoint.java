package com.rutatalk.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rutatalk.infra.entity.enums.Response;
import com.rutatalk.exception.CustomException;
import com.rutatalk.exception.ErrorCode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ObjectMapper objectMapper = new ObjectMapper();
        log.error("인증에 실패했습니다. : {}", authException.getMessage());
        CustomException e = new CustomException(ErrorCode.INVALID_PERMISSION, authException.getMessage());
        response.setStatus(e.getErrorCode().getStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(),
                Response.error(e));
        response.sendRedirect("/users/login");
    }
}
