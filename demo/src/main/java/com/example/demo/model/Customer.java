package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {
	private String id;
	private String name;
	private String phoneMobile;
	private String email;
	public Customer(String id, String name, String phoneMobile, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phoneMobile = phoneMobile;
		this.email = email;
	}
	public Customer() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
