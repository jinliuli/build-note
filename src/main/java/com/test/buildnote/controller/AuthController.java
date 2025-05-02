package com.test.buildnote.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
//        System.out.println("로그인된거야? -> URI: " + request.getRequestURI());
//        System.out.println("Referer: " + request.getHeader("Referer"));
//        System.out.println("User-Agent: " + request.getHeader("User-Agent"));

        System.out.println("로그인 성공");
        return "/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication); //로그아웃
        }

        return "redirect:/";
    }
}
