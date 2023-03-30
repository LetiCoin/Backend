package com.example.AuthService.Config;

import io.swagger.v3.core.model.ApiDescription;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.webmvc.api.OpenApiResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;


@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

//    @Bean
//    public OpenA temp(){
//        return
//    }
// com.example.AuthService.Controllers
    @Bean
    public OpenAPI baseOpenApi(){
        return new OpenAPI()
                .info(
                new Info().title("AuthService")
                        .version("0.0.0")
                        .description("testing")
                );
    }

}
