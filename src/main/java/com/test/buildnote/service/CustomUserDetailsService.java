package com.test.buildnote.service;


import com.test.buildnote.dto.CustomUserDetails;
import com.test.buildnote.entity.Users;
import com.test.buildnote.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    //로그인 처리 > DB 사용
    private final UsersRepository usersRepository;

    //사용자 > 로그인 시도(username, password) > loadUserByUsername 호출
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        //select * from Users where loginId = ?
        // username 파라미터를 loginId로 사용
        Users users = usersRepository.findByLoginId(loginId);

        if (users == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + loginId);
        }
        return new CustomUserDetails(users);
    }

}