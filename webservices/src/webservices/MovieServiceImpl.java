package webservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {
	
	@Override
	public List<Movie> getAllMovies(){
		return movies;
	}
	
	private List<Movie> movies= new ArrayList<Movie>();
	
	@Override
	public void addMovie(Movie m) {
		movies.add(m);
	}
	@Override
	public void removeMovie(Movie m) {
		movies.remove(0);
	}
	
	@Override
	public Movie getMovie(int id) {
		Optional<Movie> movie=movies.stream().filter(f->f.getId()==id).findFirst();
	if(movie.isPresent()) 
		return movie.get();
		return new Movie();
	}
	
	

}
