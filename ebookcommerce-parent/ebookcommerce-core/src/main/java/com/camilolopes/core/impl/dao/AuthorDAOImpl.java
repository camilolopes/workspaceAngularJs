package com.camilolopes.core.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.camilolopes.core.domain.ebook.Author;
import com.camilolopes.core.interfaces.dao.AuthorDAO;

@Repository("authorDAOImpl")
public class AuthorDAOImpl extends GenericHibernateDAO<Author> implements AuthorDAO {

	public AuthorDAOImpl() {
		super(Author.class);
	}
	
	@Override
	public List<Author> list() {
		Criteria criteria = getCurrentSession().createCriteria(getPersistentClass());
		criteria.setFetchMode("ebooks", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
		criteria.addOrder(Order.asc("nameEditor"));
		List<Author> listAuthors = criteria.list();
		return listAuthors;
	}

}
