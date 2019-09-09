package com.idwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class IDwebappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IDwebappApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IDwebappApplication.class);
	}
	
	@Bean
	public BCryptPasswordEncoder enconder() {
		
		return new BCryptPasswordEncoder();
	}
}
