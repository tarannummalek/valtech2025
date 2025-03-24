package com.valtech.training.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	@Bean
	public SimpleInterast simpleInterast(Arithmatic arithmatic) {
		return new SimpleInterastImpl
				(arithmatic);
	}
	
	@Bean
	public Arithmatic arithmatic() {
		return new ArithmaticImpl();
	}
	
	
	
	
	

}
