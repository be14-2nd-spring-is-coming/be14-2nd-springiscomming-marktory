package com.sic.marktory.member.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("memberAppConfig")
public class AppConfig {

    /* 설명. 우선적으로, ModelMapper 방식으로 Spring Data JPA  */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
