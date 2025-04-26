package com.test.buildnote.dto;

import com.test.buildnote.entity.Users;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//인증 사용자 정보 객체 > principal
@Getter
public class CustomUserDetails implements UserDetails {
    //사용자 추가 정보 저장용
    //(Users Entity)
    private Users users;

    public CustomUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return users.getRole();
            }
        });

        return authorities;
    }

    @Override
    public String getPassword() {

        return users.getPassword();
    }

    @Override
    public String getUsername() {

        return users.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {

        //DB > 컬럼 존재(active)
        //계정 만료 유무?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        //계정 잠금 상태
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        //자격 증명(암호) 만료 상태
        return true;
    }

    @Override
    public boolean isEnabled() {

        //사용 유무
        return true;
    }
}

