package com.camilolopes.agenda.interfaces.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor=Exception.class)
public interface GenericService<T> {
	void save(T entity); 
	void update (T entity); 
	void delete (T entity); 
	List<T> listAll();
}
