package com.camilolopes.movie.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.movie.interfaces.dao.MovieDAO;
import com.camilolopes.movie.interfaces.services.MovieService;
import com.camilolopes.movie.model.bean.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	@Qualifier("movieDAOImpl")
	private MovieDAO movieDAOImpl;
	public MovieServiceImpl() {
		
	}

	public void saveOrUpdate(Movie entity) {
		movieDAOImpl.saveOrUpdate(entity);
	}

	public void setMovieDAOImpl(MovieDAO movieDAOImpl) {
		this.movieDAOImpl = movieDAOImpl;
	}

	public List<Movie> getAllMovie() {
		List<Movie> listMovies = movieDAOImpl.getAll();
		return listMovies;
	}

	public List<Movie> getAllMoviesOrderByTheMostVoted() {
		List<Movie> listMovies = movieDAOImpl.getListTopMovies();

		return listMovies;
	}

	public Movie getMovie(long id) {
		Movie movie = movieDAOImpl.getMovieById(id);
		return movie;
	}

	public void voteInMovie(long idMovie) {
		Movie movie = movieDAOImpl.getMovieById(idMovie);
		long totalVoteActual = movie.getTotalVote();
		totalVoteActual++;
		movie.setTotalVote(totalVoteActual);
		movieDAOImpl.saveOrUpdate(movie);
	}

	@Transactional
	public List<Movie> getListSelectedMovie() {
		Set<Integer> numbers = new HashSet<Integer>();
		List<Movie> listMovies = movieDAOImpl.getAll();
		List<Movie> listSelectedMovie = new ArrayList<Movie>();
		validateListMovies(numbers, listMovies, listSelectedMovie);
		return listSelectedMovie;
	}

	private void validateListMovies(Set<Integer> numbers,
			List<Movie> listMovies, List<Movie> listSelectedMovie) {
		if (listMovies != null && !listMovies.isEmpty()) {
			generateIndexRandom(numbers);
			addMovieByIndex(numbers, listMovies, listSelectedMovie);
		}
	}

	private void addMovieByIndex(Set<Integer> numbers, List<Movie> listMovies,
			List<Movie> listSelectedMovie) {
		for (int index : numbers) {
			Movie movie = listMovies.get(index);
			listSelectedMovie.add(movie);
		}
	}

	private void generateIndexRandom(Set<Integer> numbers) {
		int totalMovie = 4;
		while (numbers.size() < totalMovie) {
			int minNumber = 0;
			int maxNumber = 5;
			int index = (int) (minNumber + maxNumber * Math.random());
			numbers.add(index);
		}
	}

}
