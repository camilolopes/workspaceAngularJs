package com.camilolopes.movie.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.movie.interfaces.services.MovieService;
import com.camilolopes.movie.model.bean.Movie;
@Service
public class DataSetup {
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService movieService;
	private static List<String> listMovies;
	

	public  void addMovies(){
		createListMovies();
		for (String movieName : listMovies) {
			Movie movie = new Movie();
			movie.setName(movieName);
			movieService.saveOrUpdate(movie);
		}
		
	}
	private  void createListMovies(){
		listMovies = new ArrayList<String>();
		listMovies.add("BATMAN");
		listMovies.add("X-MEN");
		listMovies.add("MORTAL KOMBAT");
		listMovies.add("SUPER-MAN");
		listMovies.add("SPIDER-MAN");
	}
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
}
