package com.ramq.Security;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController("/medecin").setViewName("medecin");
        registry.addViewController("/patient").setViewName("patient");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/error").setViewName("error");
    }

}
