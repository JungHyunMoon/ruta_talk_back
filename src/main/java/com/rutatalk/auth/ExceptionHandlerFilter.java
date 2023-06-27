package com.rutatalk.auth;

import com.rutatalk.exception.CustomException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try{
            filterChain.doFilter(request, response);
        } catch (CustomException e){
            log.error(e.getErrorCode().name());
        } catch(ExpiredJwtException e) {
            log.error("토큰만료");
            makeErrorResponse(request, response);
        } catch(JwtException | IllegalArgumentException e){
            log.error("유효하지 않은 토큰");
            makeErrorResponse(request, response);
        } catch(ArrayIndexOutOfBoundsException e){
            log.error("토큰을 추출할 수 없습니다.");
            makeErrorResponse(request, response);
        } catch(NullPointerException e){
            log.error("NULL 에러");
            makeErrorResponse(request, response);
        }
    }
    public void makeErrorResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setStatus(errorCode.getStatus().value());
        HttpSession session = request.getSession(false);
        session.setAttribute("jwt", null);
        response.setContentType("text/html; charset=utf-8");
        String msg = "다시 로그인 해주세요.";
        String url = "/users/login";
        PrintWriter w = response.getWriter();
        w.write("<script>alert('" + msg + "'); location.href='" + url + "';</script>");
        w.flush();
//        w.close();
    }
}
