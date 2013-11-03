package com.camilolopes.core.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camilolopes.core.interfaces.dao.GenericDAO;

@Repository
@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAO<T> implements GenericDAO<T> {

	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public GenericHibernateDAO(Class<T> persistenClass) {
		super();
		this.persistentClass = persistenClass;
	}

	@Override
	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	};

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	@Override
	public T getById(Long id) {
		return (T) getCurrentSession().get(persistentClass, id);
	}

	@Override
	public List<T> list() {
		List<T> list = getCurrentSession()
			.createCriteria(persistentClass)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			.list();
		return list;
	}
	
	@Override
	public long getCount(T entity) {
		
		return getCurrentSession().createCriteria(persistentClass).list().size();
	}

	public void setSessionFactory(SessionFactory sessionFactory) { //NOSONAR
		this.sessionFactory = sessionFactory;
	};

}