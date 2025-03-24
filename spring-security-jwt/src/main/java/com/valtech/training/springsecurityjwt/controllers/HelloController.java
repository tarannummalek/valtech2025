package com.valtech.training.springsecurityjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/login")
	public String data() {
		return "Data";
	}
	@GetMapping("/data")
	public String data1() {
		return "Data";
	}

}
