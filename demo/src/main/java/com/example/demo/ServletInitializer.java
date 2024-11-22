package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSecurityApplication.class);
	}
}
