package com.valtech.training.jaswsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JaswsclientApplicationTests {
	
	@Autowired
	private MovieServiceWS movieServcieWS;

	@Autowired
	private HelloWorld helloWorld;
	
	@Test
	void contextLoads() {
		
		System.out.println(helloWorld.hello("Jax WS"));
		movieServcieWS.createMovie(new Movie("barfi","drama","hindi",List.of("Ranbir kapoor")));
		System.out.println(movieServcieWS.getAllMovies());
	
	}

}
