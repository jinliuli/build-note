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
                .requestMatchers("/").permitAll() //요청하는 URI 패턴과 모든 사람들이 들어와서 볼수있도록
                .requestMatchers("/login").permitAll()
                .requestMatchers("/join", "/joinok").permitAll()
                .requestMatchers("/my").hasAnyRole("TEAM_LEADER", "ADMIN")
                .requestMatchers("/daily-report/**").hasRole("TEAM_LEADER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated() //나머지 경로 > 인증된 사용자만
        );
        //CSRF 토큰 해제
        //http.csrf(auth -> auth.disable());

        //커스텀 로그인 설정
        http.formLogin(auth -> auth
                .loginPage("/login")//사용자 로그인페이지 URL
                .usernameParameter("loginId")
                .passwordParameter("password")
                .defaultSuccessUrl("/") // 로그인 성공 시 이동할 URL
                .loginProcessingUrl("/loginok")
                .permitAll()
        );
        //로그아웃
        http.logout(auth -> auth  // 기존 securityFilterChain 내용 통합
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
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