package com.valtech.training.jaws.services;

import java.util.List;

import com.valtech.training.jaws.Movie;

public interface MovieService {

	Movie createMovie(Movie m);

	Movie getMovie(long id);

	List<Movie> getAllMovies();

}