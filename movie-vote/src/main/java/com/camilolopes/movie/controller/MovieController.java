package com.camilolopes.movie.controller;

import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.camilolopes.movie.interfaces.services.MovieService;
import com.camilolopes.movie.interfaces.services.UserService;
import com.camilolopes.movie.model.bean.Movie;
import com.camilolopes.movie.model.bean.User;
@Controller
@Path("/movie")
public class MovieController {
	
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService movieServiceImpl;
	private HashSet<Long> listMoviesIdVoted;
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	private List<Movie> listMovieTopVoted;
	
	 public MovieController() {
		 listMoviesIdVoted = new  HashSet<Long>();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getListMovies(){
			List<Movie> listSelectedMovie = movieServiceImpl.getListSelectedMovie();
		return listSelectedMovie;
	}
	@GET
	@Path("/top")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getListTopMovies(){
		listMovieTopVoted = movieServiceImpl.getAllMoviesOrderByTheMostVoted();
		return  listMovieTopVoted;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerMovieSelected(Movie movie){
		addListMovieSelected(movie.getId());
	}
	
	private void addListMovieSelected(long id) {
		listMoviesIdVoted.add(id);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/vote/finish")
	public void registerVote(User user){
		registerUser(user);
		registerVote();
		
	}

	private void registerVote() {
		for(long idMovie : listMoviesIdVoted){
			movieServiceImpl.voteInMovie(idMovie);
		}
		listMoviesIdVoted.clear();
	}

	private void registerUser(User user) {
		userServiceImpl.saveOrUpdate(user);
	}
	
	
	public void setMovieServiceImpl(MovieService movieServiceImpl) {
		this.movieServiceImpl = movieServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
}
