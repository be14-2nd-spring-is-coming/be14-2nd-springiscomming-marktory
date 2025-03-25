package com.sic.marktory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class Be142ndSpringiscommingMarktoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Be142ndSpringiscommingMarktoryApplication.class, args);
    }

}
