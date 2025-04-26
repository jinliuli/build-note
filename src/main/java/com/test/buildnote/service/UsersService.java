package com.test.buildnote.service;

import com.test.buildnote.entity.Users;
import com.test.buildnote.repository.UsersRepository;
import com.test.buildnote.dto.UsersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.hibernate.engine.transaction.internal.jta.JtaStatusHelper.isActive;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void join(UsersDTO dto) {

        //아이디 중복검사
        boolean result = usersRepository.existsByLoginId(dto.getLoginId());

        if (result) {
            System.out.println("이미 사용중인 아이디 입니다.");
            return;
        }

        //DTO > (변환) > Entity
        Users users = Users.builder()
                .userName(dto.getUserName())
                .loginId(dto.getLoginId())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .phoneNumber(dto.getPhoneNumber())
                .companyName(dto.getCompanyName())
                .department(dto.getDepartment())
                .jobType(dto.getJobType())
                .isActive("Y") // 직접 지정
                .build();

        usersRepository.save(users);

    }
}
