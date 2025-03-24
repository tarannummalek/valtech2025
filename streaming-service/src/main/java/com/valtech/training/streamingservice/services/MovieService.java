package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.MovieVO;

public interface MovieService {

	MovieVO createOrUpdate(MovieVO vo);

	MovieVO getMovie(long id);

	List<MovieVO> getMoviesByLanguage(String language);

	List<MovieVO> getMoviesByGenre(String genre);
	
	List<MovieVO> getAllMovies();

}