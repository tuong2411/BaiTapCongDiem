package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	 @Bean
	 public UserDetailsService userDetailsService(PasswordEncoder encoder) {
	        UserDetails admin = User.withUsername("admin")
	                .password(encoder.encode("1"))
	                .roles("ADMIN")
	                .build();

	        UserDetails user = User.withUsername("user")
	                .password(encoder.encode("1"))
	                .roles("USER")
	                .build();


	        return new InMemoryUserDetailsManager(admin, user);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	        		.authorizeHttpRequests(auth -> auth
	        		        .requestMatchers("/", "/hello").permitAll()
	        		        .requestMatchers("/customer/all").hasAuthority("ROLE_ADMIN")
	        		        .requestMatchers("/customer/{id}").hasAuthority("ROLE_USER")
	        		        .anyRequest().authenticated() // Cần đăng nhập với các endpoint /customer/**
	                )
	                .formLogin(Customizer.withDefaults()) // Bật form đăng nhập mặc định
	                .build();
	    }

	
}
