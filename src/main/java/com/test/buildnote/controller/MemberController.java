package com.test.buildnote.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/create")
    public String createDailyReport() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("현재 사용자 권한: " + auth.getAuthorities());
        return "member/create";
    }

    @GetMapping("/list")
    public String viewReport() {
        return "member/list";
    }

    @GetMapping("/edit")
    public String editReport() {
        return "member/edit";
    }

    @GetMapping("/delete")
    public String deleteReport() {
        return "member/delete";
    }
}
