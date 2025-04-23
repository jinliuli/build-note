package com.test.buildnote.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll() //요청하는 URI 패턴과 모든 사람들이 들어와서 볼수있도록
                .requestMatchers("/login").permitAll()
                .requestMatchers("/join", "/joinok").permitAll()
                .requestMatchers("/my").hasAnyRole("TEAM_LEADER", "ADMIN")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated() //나머지 경로 > 인증된 사용자만
        );

        return http.build(); // ✅ 필수 리턴
    }
}