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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("1."+username);
        //select * from Users where loginId = ?
        // username 파라미터를 loginId로 사용
        Users users = usersRepository.findByLoginId(username);
        System.out.println("2."+username);
        if (users == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }
        return new CustomUserDetails(users);
    }

//        if (users != null) {
//            System.out.println("로그인성공! " + users.getLoginId());
//            return new CustomUserDetails(users); //로그인 성공
//        }
//
//        System.out.println("로그인 실패");
//        // return null; // null을 반환하면 안 됨 !
//        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
//    }
}