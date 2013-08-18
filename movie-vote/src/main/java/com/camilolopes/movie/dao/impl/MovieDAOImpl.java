package com.camilolopes.movie.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.camilolopes.movie.interfaces.dao.MovieDAO;
import com.camilolopes.movie.model.bean.Movie;
@Repository
public class MovieDAOImpl extends HibernateDAO<Movie, Long> implements MovieDAO {

	
	public MovieDAOImpl() {
		super(Movie.class);
	}

	public List<Movie> getListTopMovies() {
		 Criteria criteria = createCriteriaQuery();
		List<Movie> listMovies = criteria.list();
		return listMovies;
	}
	
//	private List<Movie> getTopListMovies(long totalVote){
//			Criteria criteria = getCurrentSession().createCriteria(Movie.class);
//			criteria.add(Restrictions.eq("totalVote", totalVote));
//			criteria.addOrder(Order.asc("name"));
//		final List<Movie> list = criteria.list();
//		return list;
//	}
	private Criteria createCriteriaQuery() {
		Criteria criteria = getCurrentSession().createCriteria(Movie.class);
		 criteria.addOrder(Order.desc("totalVote"));
		 criteria.addOrder(Order.asc("name"));
		return criteria;
	}

	public Movie getMovieById(long id) {
		 	 Movie movie = (Movie) getCurrentSession().get(Movie.class, id);
			return movie;
	}

	

}
