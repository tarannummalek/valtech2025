package webservices;

import java.util.List;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class MovieServiceClient {
	public static void main(String[] args) {
		
		ClientProxyFactoryBean client =new ClientProxyFactoryBean();
		client.setAddress("http://localhost:7777/MovieService");
		MovieService movieService=client.create(MovieService.class);
		System.out.println(movieService.getAllMovies());
		System.out.println(movieService.getMovie(1));
		System.out.println(movieService.getMovie(2));
		//movieService.addMovie(new Movie(6,"Day and Knight","english","action",List.of("Tom cruise")));
	System.out.println(movieService.getAllMovies());
	}

}
