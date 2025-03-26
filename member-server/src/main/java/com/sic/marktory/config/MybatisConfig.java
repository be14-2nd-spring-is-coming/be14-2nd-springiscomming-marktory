package com.sic.marktory.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

// Mybatis 설정 완료
@Configuration
@MapperScan(basePackages = "com.sic.marktory", annotationClass = Mapper.class)
public class MybatisConfig {

}
