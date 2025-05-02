package com.test.buildnote.controller;

import com.test.buildnote.dto.UsersDTO;
import com.test.buildnote.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/join")
    public String join() {

        return "join";
    }

    @PostMapping("/joinok")
    public String joinok(UsersDTO dto) {

        //System.out.println("1. 폼에서 받은거 DTO에 넣기");
        System.out.println("dto: " + dto);

        //System.out.println("2. 아이디 중복검사");
        usersService.join(dto);

        return "redirect:/login";
    }

    @GetMapping("/my")
    public String myPage(Authentication authentication, Model model) {
        // 현재 인증된 사용자 정보를 모델에 추가
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("authorities", authentication.getAuthorities());
        }
        return "my"; // my.html 뷰 리턴
    }

}
