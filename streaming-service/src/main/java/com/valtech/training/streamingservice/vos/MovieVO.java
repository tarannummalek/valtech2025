package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO(long id,String name,String genre,String language,long duration,long costPerView) {
	
	public static MovieVO from(Movie movie) {
		return new MovieVO(movie.getId(), movie.getName(), movie.getGenre(),movie.getLanguage(), movie.getDuration(),movie.getCostPerView());
	}
	public Movie to() {
		return new Movie(name, language, genre, duration, costPerView);
	}
	
	public static List<MovieVO> fromlist(List<Movie> list){
		return list.stream().map(m->MovieVO.from(m)).collect(Collectors.toList());
	}
	public List<Movie> tolist(List<MovieVO> list){
		return list.stream().map(m->m.to()).collect(Collectors.toList());
	}

}
