package com.valtech.training.jaws.webservices;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.services.MovieService;

@WebService(endpointInterface ="com.valtech.training.jaws.webservices.MovieServiceWS",name = "MovieService",portName = "MovieServicePort")
public class MovieServiceWSImpl implements MovieServiceWS {
	@Autowired
	private MovieService movieService;

	public MovieServiceWSImpl(MovieService movieService2) {
		this.movieService=movieService;
	}

	@Override
	public Movie createMovie(Movie m) {
		return movieService.createMovie(m);
	}

	@Override
	public Movie getMovie(long id) {
		return movieService.getMovie(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	

}
