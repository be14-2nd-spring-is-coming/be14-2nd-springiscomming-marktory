package com.sic.marktory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@OpenAPIDefinition(
        info = @Info(
                title = "MarkTory",
                version = "v0.0.2",
                description = "MarkTory의 API 명세서"
        )
//        , servers = {
//                @Server(url = "http://api.localhost:8080", description = "blog service"),
//                @Server(url = "http://api.member:8761", description = "member service")
//        }
)
@SpringBootApplication
@EnableDiscoveryClient
public class MarktoryMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarktoryMainApplication.class, args);
    }

}
