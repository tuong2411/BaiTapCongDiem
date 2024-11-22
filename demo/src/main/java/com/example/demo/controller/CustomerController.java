package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class CustomerController {
	  private final List<Customer> customers = List.of(
	            new Customer("001", "Hoang Manh Tuong","0123456789", "tuong@gmail.com"),
	            new Customer("002", "Manh Tuong","0987654321", "manhtuong@gmail.com")
	    );
	  
	  @GetMapping("/hello")
	    public ResponseEntity<String> hello() {
	        return ResponseEntity.ok("Hello is Guest");
	    }
	  
	  	@GetMapping("/customer/all")
	  	@PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<List<Customer>> getCustomerList() {
	        return ResponseEntity.ok(customers);
	    }
	  
	  @GetMapping("/customer/{id}")
	  @PreAuthorize("hasRole('USER')")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
	        return customers.stream()
	                .filter(customer -> customer.getId().equals(id))
	                .findFirst()
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	  
}
