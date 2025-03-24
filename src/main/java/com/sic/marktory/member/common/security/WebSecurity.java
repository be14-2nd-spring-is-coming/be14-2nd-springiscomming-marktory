package com.sic.marktory.member.common.security;

import jakarta.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurity {
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider){
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());

        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz ->
                                authz.requestMatchers(new AntPathRequestMatcher("/api/member/**", "POST")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/login", "POST")).permitAll()
                                        .anyRequest().authenticated()
                )
                .authenticationManager(authenticationManager())

                /* 설명. Session을 쓰지 않고 Jwt토큰 방식으로 LocalThread에 저장하겠다는 설정 */
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // 필터 등록
        log.info("필터 등록 전 진입");
        http.addFilter(getAuthenticationFilter(authenticationManager()));

//        /* 설명. 로그인 이후 사용자가 들고 온 (request header에 발급받은 bearer 토큰을 들고 옴)
//            토큰을 검증하기 위한 필터 */
//        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
//        log.info("http build 전까지 완료");
        return http.build();
    }

    /* 설명. Filter는 jakarta.servlet으로 import */
    private Filter getAuthenticationFilter(AuthenticationManager authenticationManager) {
        log.info("진입했음");
        return new AuthenticationFilter(authenticationManager);
    }

}
