package com.toyproject.jobadream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")  // 모든 경로 허용
			.allowedOrigins("http://localhost:8080", "https://jobadream.com",
				"http://api.jobadream.com") // 허용할 출처
			.allowedMethods("GET", "POST", "DELETE", "PATCH") // 허용할 HTTP 메서드
			.allowedHeaders("*") // 모든 헤더 허용
			.allowCredentials(true) // 인증 정보(쿠키 등) 허용
			.maxAge(3600); // 캐시 시간(초 단위)
	}
}
