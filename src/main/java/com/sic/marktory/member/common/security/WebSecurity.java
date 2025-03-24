package com.sic.marktory.member.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity {
    private Environment env;        // 의존성 주입

    @Autowired
    public WebSecurity(Environment env) {
        this.env = env;
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());

        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz ->
                                authz.requestMatchers(new AntPathRequestMatcher("/api/member/**", "POST")).permitAll()
                                        .anyRequest().authenticated()
                )

                /* 설명. Session을 쓰지 않고 Jwt토큰 방식으로 LocalThread에 저장하겠다는 설정 */
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
