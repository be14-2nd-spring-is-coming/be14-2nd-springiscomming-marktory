package com.sic.marktory.member.common.security;

import com.sic.marktory.member.query.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/* 설명. Jwt 토큰 방식의 로그인을 구경할 때 UsernamePasswordAuthenticationToken을 처리할 프로바이더 */
/* 설명. Service 계층을 UserDetailsService 타입으로 바꿀 예정 */
@Slf4j
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public JwtAuthenticationProvider(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        /* 설명. 넘어온 토큰에서 사용자가 로그인 시 입력한 id(email)와 pwd(pwd) 추출 */
        String email = authentication.getName();
//        String pwd = authentication.getCredentials().toString();
        String pwd = (String)authentication.getCredentials();

        /* 설명. 해당 email과 일치하는 DB에서 조회 된 회원 */
        UserDetails userDetails = memberService.loadUserByUsername(email);

        // 이제 사용자가 입력한 이메일과 암호와 DB의 이메일과 암호가 만남
        // BCrypt 암호 일치하지 않다면, matches 이용 정해진 예외 발생시키기
        if (!passwordEncoder.matches(pwd, userDetails.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        /* 설명. 예외가 발생하지 않고 여기 코드가 실행되면 인증된 회원정보 */
        // 회원 정보, 비밀번호(null), 회원의 권한
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
    }

    // 매니저가 이 토큰을 처리할 것이 있는지 확인하는 support?
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}