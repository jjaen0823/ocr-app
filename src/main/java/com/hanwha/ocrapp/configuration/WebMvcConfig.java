package com.hanwha.ocrapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 요청을 허용할 경로 설정
                .allowedOrigins("http://localhost:3000") // 허용할 오리진(클라이언트 주소) 설정
                .allowedOrigins("http://43.202.101.105:3000") // 허용할 오리진(클라이언트 주소) 설정
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드 설정
                .allowedHeaders("*") // 허용할 헤더 설정
                .allowCredentials(false); // 인증정보를 포함할지 여부 설정
    }
}

