package com.camilolopes.movie.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.movie.interfaces.dao.UserDAO;
import com.camilolopes.movie.interfaces.services.UserService;
import com.camilolopes.movie.model.bean.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDAOImpl")
	private UserDAO userDAOImpl;
	public void saveOrUpdate(User entity) {
		userDAOImpl.saveOrUpdate(entity);
	}
	public UserDAO getUserDAOImpl() {
		return userDAOImpl;
	}
	public void setUserDAOImpl(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

}
