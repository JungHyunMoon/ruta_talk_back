package com.rutatalk.infra.controller.ui;


import com.rutatalk.exception.CustomException;
import com.rutatalk.exception.ErrorCode;
import com.rutatalk.infra.dto.UserLoginRequest;
import com.rutatalk.infra.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserUiController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("userLoginRequest", new UserLoginRequest());
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginRequest req, HttpServletRequest httpServletRequest, Model model) {
        String jwtToken = "";
        try {
            jwtToken = userService.login(req).getJwt();
        } catch (CustomException e) {
            if(e.getErrorCode() == ErrorCode.USERNAME_NOT_FOUND) {
                model.addAttribute("message", "아이디가 존재하지 않습니다");
                model.addAttribute("nextUrl", "/users/login");
                return "users/login";
            }
            if(e.getErrorCode() == ErrorCode.INVALID_PASSWORD) {
                model.addAttribute("message", "비밀번호가 틀렸습니다.");
                model.addAttribute("nextUrl", "/users/login");
                return "users/login";
            }
        } catch (Exception e) {
            throw e;
        }

        // 기존 Session 파기 후 새로 생성
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);

        // login 후 받은 jwt Token 값을 session에 넣어줌
        session.setAttribute("jwt", "Bearer " + jwtToken);
        session.setMaxInactiveInterval(30 * 60); // Session이 30분동안 유지

        return "redirect:/home";
    }
}
