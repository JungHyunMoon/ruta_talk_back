package com.rutatalk.security;

import com.rutatalk.exception.ErrorCode;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        makeErrorResponse(response, ErrorCode.INVALID_PERMISSION);
    }

    public void makeErrorResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException {
        response.setStatus(errorCode.getStatus().value());
        response.setContentType("text/html; charset=utf-8");
        String msg = "잘못된 접근입니다.";
        String url = "/users/login";
        PrintWriter w = response.getWriter();
        w.write("<script>alert('" + msg + "');location.href='" + url + "';</script>");
        w.flush();
        w.close();
    }
}
