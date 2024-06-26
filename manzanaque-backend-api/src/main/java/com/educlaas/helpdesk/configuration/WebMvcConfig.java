package com.educlaas.helpdesk.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOriginPatterns("*")
		.allowedOrigins("https://manzanaque-full.vercel.app")
		.allowedMethods("GET", "POST")
		.allowedHeaders("*")
		.allowCredentials(true);
	}
	
}
