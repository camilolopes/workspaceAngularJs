package com.camilolopes.movie.interfaces.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO<T, Type extends Serializable> {
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveOrUpdate(T entity);
	public List<T> getAll();
}
