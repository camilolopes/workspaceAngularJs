package com.camilolopes.movie.dao.impl;

import org.springframework.stereotype.Repository;

import com.camilolopes.movie.interfaces.dao.UserDAO;
import com.camilolopes.movie.model.bean.User;
@Repository
public class UserDAOImpl extends HibernateDAO<User, Long> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

}
