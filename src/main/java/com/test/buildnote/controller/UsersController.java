package com.test.buildnote.controller;

import com.test.buildnote.dto.UsersDTO;
import com.test.buildnote.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String my() {

        //로그인 회원 > 자기 인증 정보 확인

        return "my";
    }

}
