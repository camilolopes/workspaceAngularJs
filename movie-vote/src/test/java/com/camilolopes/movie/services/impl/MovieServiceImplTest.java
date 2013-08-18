package com.camilolopes.movie.services.impl;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.camilolopes.dbunit.configuration.DBUnitConfiguration;
import com.camilolopes.movie.interfaces.services.MovieService;
import com.camilolopes.movie.model.bean.Movie;
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceImplTest extends DBUnitConfiguration {
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService movieServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testSaveMovieWithSuccess() throws Exception {
		Movie movie = new Movie();
		movie.setName("X-men");
		movieServiceImpl.saveOrUpdate(movie);
	}
	@Test
	public void testGetListAllMovieIsNotEmpty(){
		assertFalse(movieServiceImpl.getAllMovie().isEmpty());
	}
	
	@Test
	public void testGetTotalTheMostVotedMovieInTheTopOfList(){
		final Movie movie = movieServiceImpl.getAllMoviesOrderByTheMostVoted().get(0);
		final long totalVote = movie.getTotalVote();
		final long expectedTotalVote = 6;
		assertEquals(expectedTotalVote,totalVote);
		final String expectedNameOfMovie = "Bataman";
		assertEquals(expectedNameOfMovie,movie.getName());
	}
	@Test
	public void testGetNameOfTheMostVotedMovieOrderByName(){
		final String expectedNameOfMovie = "[Bataman, Carandiru, X-Men, Super Man, SpiderMan]";
		assertEquals(expectedNameOfMovie,movieServiceImpl.getAllMoviesOrderByTheMostVoted().toString());
	}
	@Test
	public void testVoteInOneMovieWasComputed(){
		final int idMovie = 1;
		Movie movie = movieServiceImpl.getMovie(idMovie);
		long totalVoteBeforeVote = movie.getTotalVote();
		movieServiceImpl.voteInMovie(idMovie);
		long totalVoteAfterVote = movieServiceImpl.getMovie(idMovie).getTotalVote();
		final long expectedFinalTotalVote = ++totalVoteBeforeVote;
		assertEquals(expectedFinalTotalVote,totalVoteAfterVote);
	}
	@Test
	public void testGetListOfMoviesSelectedToBeVotedSizeIsEqualsFour(){
		List<Movie> listSelectedMovie = movieServiceImpl.getListSelectedMovie();
		final int totalMoviesExpected = 4;
		assertEquals(totalMoviesExpected,listSelectedMovie.size());
	}
	
	public void setMovieServiceImpl(MovieService movieServiceImpl) {
		this.movieServiceImpl = movieServiceImpl;
	}

}
