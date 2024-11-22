package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

public class DebugController {
	 @GetMapping("/debug")
	    public ResponseEntity<?> debug() {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        return ResponseEntity.ok(auth.getAuthorities());
	    }
}
