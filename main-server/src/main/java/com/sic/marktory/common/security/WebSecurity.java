package com.sic.marktory.common.security;

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
    private Environment env;
    private JwtUtil jwtUtil;

    @Autowired
    public WebSecurity(JwtAuthenticationProvider jwtAuthenticationProvider, Environment env, JwtUtil jwtUtil) {
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.env = env;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider));
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable());

        /* 설명. 허용되는 경로 및 권한 설정 */
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers(new AntPathRequestMatcher("/**/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/api/report/reports/")).hasRole("ADMIN")
//                .requestMatchers(new AntPathRequestMatcher("/api/report/reportedWriterId")).hasRole("ADMIN")
//                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/v3/api-docs")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/swagger-resources/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/webjars/**")).permitAll()
                .anyRequest().authenticated()
                )
//                                .requestMatchers("/api/report/reportedWriterId")
//                                .hasRole("ADMIN")
//                                .requestMatchers(
//                                        "/v3/api-docs/**",
//                                        "/swagger-ui/**",
//                                        "/swagger-ui.html",
//                                        "/swagger-resources/**",
//                                        "/webjars/**"
//                                ).permitAll()
//                                .anyRequest().authenticated()
//                )
                .authenticationManager(authenticationManager())

                /* 설명. Session을 쓰지 않고 Jwt토큰 방식으로 LocalThread에 저장하겠다는 설정 */
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        /* 설명. 로그인 이후 사용자가 들고 온 (request header에 발급받은 bearer 토큰을 들고 옴)
            토큰을 검증하기 위한 필터 */
        http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
