package com.products.apirest.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public GroupedOpenApi productApi(){
        return GroupedOpenApi.builder()
                .pathsToMatch("/api/v1.**")
                .build();
    }

}
