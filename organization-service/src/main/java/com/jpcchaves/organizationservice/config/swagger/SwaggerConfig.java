package com.jpcchaves.organizationservice.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Organization Service - REST API Microsservice")
                        .version("v1")
                        .contact(new Contact().url("https://www.linkedin.com/in/joaopaulo-chaves/").email("jpcchaves@outlook.com"))
                        .description("Rest API built to manage organizations")
                        .license(new License().name("License: MIT").url(""))
        );
    }
}
