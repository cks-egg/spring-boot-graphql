package com.example.shop;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ShopApiApplication {

	public static void main(String[] args) {
		init();
		try {
			SpringApplication.run(ShopApiApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void init() {
		if (Strings.isEmpty(System.getProperty("spring.profiles.active"))){
			System.setProperty("spring.profiles.active", "default");
		}
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
