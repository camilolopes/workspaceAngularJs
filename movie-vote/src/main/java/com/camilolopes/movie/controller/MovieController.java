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
import com.camilolopes.movie.model.bean.Movie;
@Controller
@Path("/movie")
public class MovieController {
	
	@Autowired
	@Qualifier("movieServiceImpl")
	private MovieService movieServiceImpl;
	private HashSet<Long> listMoviesIdVoted;
	
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
		List<Movie> listMovieTopVoted = movieServiceImpl.getAllMoviesOrderByTheMostVoted();
		return  listMovieTopVoted;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerMovieSelected(Movie movie){
//		TODO retorno a lista atualizada com os outros dois filmes pedendentes 
//		movieServiceImpl.voteInMovie(movie.getId());
		addListMovieSelected(movie.getId());
	}
	
	private void addListMovieSelected(long id) {
		listMoviesIdVoted.add(id);
		System.out.println(listMoviesIdVoted);
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/vote/finish")
	public void registerVote(){
		
	}
	
	
	public void setMovieServiceImpl(MovieService movieServiceImpl) {
		this.movieServiceImpl = movieServiceImpl;
	}
	
}
