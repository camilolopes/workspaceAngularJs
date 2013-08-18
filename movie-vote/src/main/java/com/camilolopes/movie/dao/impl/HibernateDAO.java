package com.camilolopes.movie.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camilolopes.movie.interfaces.dao.GenericDAO;
@Repository
public abstract class HibernateDAO<T, Type extends Serializable>  implements GenericDAO<T, Type> {
	
	private Class<T> persistentClass;
	@Autowired
	private SessionFactory sessionFactory;


	public HibernateDAO(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	} 

	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);

	};
	
	public List<T> readAll() {
		final List<T> list = getCurrentSession().createCriteria(persistentClass).list();
		return list;
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



}
