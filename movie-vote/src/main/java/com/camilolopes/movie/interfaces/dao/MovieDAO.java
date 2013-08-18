package com.camilolopes.movie.interfaces.dao;

import java.util.List;

import com.camilolopes.movie.model.bean.Movie;

public interface MovieDAO extends GenericDAO<Movie, Long> {

	List<Movie> getListTopMovies();

	Movie getMovieById(long id);


}
