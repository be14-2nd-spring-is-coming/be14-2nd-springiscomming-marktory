package com.sic.marktory.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    /* 설명. 우선적으로, ModelMapper 방식으로 Spring Data JPA  */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /* 설명. 비밀번호 bcrypt 암호화를 위한 암호화 추가 */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
