package com.camilolopes.core.impl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.core.interfaces.dao.GenericDAO;
import com.camilolopes.core.interfaces.service.GenericService;
@Service
public class GenericServiceImpl<T, DAO extends GenericDAO<T>> implements GenericService<T> {
	
	private DAO dao;
	
	@Override
	public void saveOrUpdate(T entity) throws Exception {
		dao.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) throws Exception {
		dao.delete(entity);
	}

	@Override
	public T getById(Long id) throws Exception {
		return dao.getById(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<T> list() throws Exception {
		return dao.list();
	}
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public DAO getDao() {
		return dao;
	}

	@Override
	public long getCount(T entity) throws Exception {
		return dao.getCount(entity);
	}
	
}
