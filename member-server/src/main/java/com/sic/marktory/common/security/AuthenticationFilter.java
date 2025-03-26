package com.sic.marktory.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sic.marktory.member.command.domain.aggregate.vo.RequestLoginVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private Environment env;

    public AuthenticationFilter(AuthenticationManager authenticationManager, Environment env) {
        super(authenticationManager);
        this.env = env;
    }

    /* 설명. 로그인 시도 시 동작하는 기능(POST /login 요청 시), url 노출 방지 post 사용 */
    // 로그인 시도(내려 갈 때 수행하는 메소드), 인증을 시도
    // 로그인 정보를 필터 순서대로 받는데, 이 메소드를 통해 받음
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            /* 설명. request를 통해 넘어온 json(login 시 id/pwd)를 RequestLoginVO 옮겨 담기 */
            RequestLoginVO creds = new ObjectMapper().readValue(request.getInputStream(), RequestLoginVO.class);
            log.info("creds: {}", creds);
            // 아직 권한은 없다고 설정하고 넘기기 ?, 그림 2번까지 수행
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 설명. 로그인 성공 시(Authentication authResult에는 로그인에 성공한 User 객체가 들어있음) JWT 토큰 생성할 예정 */
    // 로그인 성공(다시 올라 갈 때 수행하는 메소드), DB에서 조회하여 인증 완료된 객체가 포함되어 있음
    // JwtAuthenticationProvider에서 인증 성공 후 Authenticatino에 들어간 데이터? result로 반환?
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공 이후 spring securiy가 Authentication 객체로 관리 되어 넘어옴: {}", authResult);
        /* 설명. 로그인 이후 넘어온 Authentication 객체를 활용해 JWT 토큰 만들기 */
        log.info("시크릿 키 : {}", env.getProperty("token.secret"));    // 토큰 생성을 위한 secret key

        /* 설명. 토큰의 payload에 (id, 가진 권한들, 만료 시간)을 담을 예정 */
        String id = ((User)authResult.getPrincipal()).getUsername();
        log.info("회원의 아이디(이메일): {}", id);

        List<String> roles = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        log.info("List<String> 형태로 뽑아낸 로그인 한 회원의 권한들: {}", roles);
        log.info("만료 시간: {}", env.getProperty("token.expiration_time"));

        /* 설명. 이제부터 위에서 추출한 재료들로 JWT Token 제작(JWT 라이브러리 추가) */
        // 공개 + 비공개의 클레임을 가지고 조립
        Claims claims = Jwts.claims().setSubject(id);
        claims.put("auth", roles);

        String token = Jwts.builder()
//                .setSubject(id)
                .setClaims(claims)      // 등록된 클레임(subject) + 비공개 클레임(auth)
                .setExpiration(new Date(System.currentTimeMillis()
                        + Long.parseLong(env.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512, env.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        log.info("successfulAuthentication");
    }
}