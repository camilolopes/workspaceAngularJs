package com.camilolopes.agenda.interfaces.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camilolopes.agenda.interfaces.dao.GenericDAO;
@Service
public class GenericServiceImpl<T, DAO extends GenericDAO<T>> implements GenericService<T> {
	
	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public DAO getDao() {
		return dao;
	}

	public void save(T entity) {
		dao.saveOrUpdate(entity);
		
	}

	public void update(T entity) {
		dao.saveOrUpdate(entity);
		
	}

	public void delete(T entity) {
		dao.delete(entity);
		
	}

	public List<T> listAll() {
		List<T> list = dao.list();
		return list;
	}
	
}
