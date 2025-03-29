package com.sic.marktory.common.security;

import com.sic.marktory.member.service.MemberVerifyService;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;

@Component
@Profile("test")  // test 환경에서만 이 빈이 등록됨
public class TestJwtUtil extends JwtUtil {

    public TestJwtUtil(MemberVerifyService memberVerifyService) {
        // 부모 생성자에 아무 키나 넣어도 됨 (어차피 validateToken 무시됨)
        super( Base64.getEncoder().encodeToString("this-is-a-test-secret-key-1234567890".getBytes()), memberVerifyService);
    }

    @Override
    public boolean validateToken(String token) {
        // 무조건 유효한 토큰으로 간주
        return true;
    }

    @Override
    public Authentication getAuthentication(String token) {
        // test 인증 객체 생성 (권한 없음)
        return new UsernamePasswordAuthenticationToken("test-user", null, List.of());
    }
}