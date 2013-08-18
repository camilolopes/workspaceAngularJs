package com.camilolopes.movie.interfaces.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.movie.model.bean.Movie;

public interface MovieService extends Service<Movie> {
	@Transactional
	List<Movie> getAllMovie();
	@Transactional
	List<Movie> getAllMoviesOrderByTheMostVoted();
	@Transactional
	Movie getMovie(long id);
	@Transactional
	void voteInMovie(long idMovie);
	@Transactional
	List<Movie> getListSelectedMovie();

}
