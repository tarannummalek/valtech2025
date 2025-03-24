package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.MovieVO;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/contents")
public class ContentController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private WebSeriesService webSeriesService;
	
	@GetMapping("/movies/{id}")
	MovieVO getMovie(@PathVariable ("id") long id) {
		return movieService.getMovie(id);
		
	}
	
	@PostMapping("/movies")
	MovieVO createMovie(@RequestBody MovieVO movieVO) {
		return movieService.createOrUpdate(movieVO);
	}
	@GetMapping("/movies/g/{genre}")
	List<MovieVO> getMoviesByGenre(@PathVariable ("genre") String genre) {
		return movieService.getMoviesByGenre(genre);
		
	}
	@GetMapping("/movies/l/{language}")
	List<MovieVO> getMoviesByLanguage(@PathVariable ("language") String language) {
		return movieService.getMoviesByLanguage(language);
		
	}
	
	@GetMapping("/movies")
	List<MovieVO> getAllMovies(){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/webseries/{id}")
	public WebSeriesVO getWebSeries(@PathVariable("id")long id) {
		return webSeriesService.getWebSeries(id);
	}
	@GetMapping("/webseries/{id}")
	public WebSeriesVO getWebSeriesByDuration(@PathVariable("id")long id) {
		return webSeriesService.getWebSeries(id);
	}
	@GetMapping("/webseries/{id}")
	public WebSeriesVO getWebSeriesByEpisodeCount(@PathVariable("id")int
			id) {
		return webSeriesService.getWebSeries(id);
	}
	
}
