package com.vitorrafael.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration // This class will be used to configure the application
public class SpringBootEssentialsAdapter implements WebMvcConfigurer {
    // WebMvcConfigurer is an interface that contains the configuration methods
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // Create default pageable for the endpoint pagination
        PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
        phmar.setFallbackPageable(PageRequest.of(0, 5));
        argumentResolvers.add(phmar);
    }

}
