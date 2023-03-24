package com.example.AuthService.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI().info(
                new Info().title("test")
                        .version("0.0.0")
                        .description("testing")
        );
    }

}