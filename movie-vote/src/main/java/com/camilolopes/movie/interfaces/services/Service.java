package com.camilolopes.movie.interfaces.services;

import org.springframework.transaction.annotation.Transactional;

public interface Service<T extends Object> {
	@Transactional
	void saveOrUpdate(T entity);
}
