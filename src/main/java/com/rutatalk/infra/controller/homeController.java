package com.rutatalk.infra.controller;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequiredArgsConstructor
@ApiIgnore
public class homeController {
    @GetMapping(value={"", "/"})
    public String root(Authentication auth, Model model){
        return "home";
    }
    @GetMapping(value = {"/home"})
    public String home(org.springframework.security.core.Authentication auth, Model model){
        return "home";
    }
}
