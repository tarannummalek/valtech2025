package webservices;

import java.util.List;

public interface MovieService {

	List<Movie> getAllMovies();

	void addMovie(Movie m);

	void removeMovie(Movie m);

	Movie getMovie(int id);

}