package com.valtech.training.streamingservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.streamingservice.entities.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{
	
 List<Movie> findAllByDuration(long duration);

List<Movie> findAllByGenre(String genre);

List<Movie> findAllByLanguage(String language);
}
