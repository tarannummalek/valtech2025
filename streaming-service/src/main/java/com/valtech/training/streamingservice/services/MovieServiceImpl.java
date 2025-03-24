package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO createOrUpdate(MovieVO vo) {
		return MovieVO.from(movieRepo.save(vo.to()));
	}
	
	@Override
	public MovieVO getMovie(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	@Override
	public List<MovieVO> getMoviesByGenre(String genre) {
		return MovieVO.fromlist(movieRepo.findAllByGenre(genre));
	}
	@Override
	public List<MovieVO> getMoviesByLanguage(String language) {
		return MovieVO.fromlist(movieRepo.findAllByLanguage(language));
	}
	
	@Override
	public List<MovieVO> getAllMovies(){
	return MovieVO.fromlist(movieRepo.findAll());
	}

}
