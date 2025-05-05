package com.test.buildnote.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/home", "/login", "/join", "/css/**", "/js/**", "/images/**", "/my", "/member/**", "/admin/**").permitAll()
//                // 공개 리소스
//                .requestMatchers("/", "/home", "/login", "/join", "/css/**", "/js/**", "/images/**").permitAll()
//                // 인증된 사용자만 접근 가능한 페이지
//                .requestMatchers("/my").authenticated() // 내 정보 페이지는 로그인한 모든 사용자에게 허용
//                // 팀장 권한 필요
//                .requestMatchers("/member/**").hasRole("MEMBER")
//                // 관리자 권한 필요
//                .requestMatchers("/admin/**").hasRole("ADMIN")
                // 그 외 모든 요청은 인증 필요
                .anyRequest().authenticated()
        );
        //CSRF 토큰 해제
        //http.csrf(auth -> auth.disable());

        //커스텀 로그인 설정
        http.formLogin(auth -> auth
                .loginPage("/login")
                .loginProcessingUrl("/loginok")
                .usernameParameter("loginId") // << 여기!
                .passwordParameter("password") // 생략 가능, 기본값 그대로면
                .defaultSuccessUrl("/", true)
                .permitAll()
        )

        //로그아웃
        .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
        );


        return http.build();
    }

    //BCrypt 암호화 객체
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

//    //로그아웃 설정
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.logout(auth -> auth
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//        );
//
//        return http.build();
//    }
}