package com.sic.marktory.common.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final Environment environment;

    public JwtFilter(JwtUtil jwtUtil, Environment environment) {
        this.jwtUtil = jwtUtil;
        this.environment = environment;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        log.info("들고 온 토큰 확인: {}", authorizationHeader);

        // test 모드를 위해 상단 if문 추가 (테스트 모드 토큰을 통과시켜야함ㅋ)
        if (isTestProfileActive()) {
            log.info("test 프로필 - 토큰 없이 인증 객체 강제 주입");
            Authentication authentication = new UsernamePasswordAuthenticationToken("test-user", null, List.of());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);    // "Bearer "를 제외한 토큰 부분만 추출
            log.info("순수 토큰 값: " + token);
            if(jwtUtil.validateToken(token)) {

                /* 설명. 유효한 토큰을 통해 아이디와 권한들을 가진 Authentication 추출(Spring Security가 인식할 수 있게 반환) */
                Authentication authentication = jwtUtil.getAuthentication(token);

                /* 설명. Spring Security가 인식할 수 있게 주입(요청당 저장 할 수 있는 공간인 LocalThread에 저장) */
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        /* 설명. 다음 필터를 진행하게 해 줘야 AuthenticationFilter가 동작함 */
        filterChain.doFilter(request, response);
    }

    private boolean isTestProfileActive() {
        return List.of(environment.getActiveProfiles()).contains("test");
    }
}
