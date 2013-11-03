package com.camilolopes.core.impl.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.core.domain.ebook.Author;
import com.camilolopes.core.interfaces.dao.AuthorDAO;
import com.camilolopes.core.interfaces.service.AuthorService;

@Service
@Transactional
public class AuthorServiceImpl extends GenericServiceImpl<Author, AuthorDAO> implements AuthorService{

	@Autowired
	@Qualifier("authorDAOImpl")
	@Override
	public void setDao(AuthorDAO dao) {
		super.setDao(dao);
	}
	
}
