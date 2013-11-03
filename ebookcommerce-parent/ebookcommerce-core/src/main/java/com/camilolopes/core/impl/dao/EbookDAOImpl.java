package com.camilolopes.core.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.core.domain.ebook.Ebook;
import com.camilolopes.core.enums.ebook.Status;
import com.camilolopes.core.interfaces.dao.EBookDAO;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class EbookDAOImpl extends GenericHibernateDAO<Ebook> implements EBookDAO{

	public EbookDAOImpl() {
		super(Ebook.class);
	}

	@Override
	public Ebook getEbookByTitle(String title) {
		Class<Ebook> ebook = getPersistentClass();
		Criteria criteria = getCurrentSession().createCriteria(ebook);
		addCriteriaAuthorAndStatus(criteria,Status.Active);
		criteria.add(Restrictions.ilike("title", title));
		return (Ebook) criteria.uniqueResult();
	}
	
	@Override
	public List<Ebook> list() {
		Class<Ebook> ebook = getPersistentClass();
		Criteria criteria = getCurrentSession().createCriteria(ebook);
		addCriteriaAuthorAndStatus(criteria,Status.Active);
		addFetchMode(criteria);
		final List<Ebook> listEbooks = criteria.list();
		return listEbooks;
	}

	private void addFetchMode(Criteria criteria) {
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
		criteria.setFetchMode("typeEbooks", FetchMode.JOIN);
		criteria.setFetchMode("categoryEbook", FetchMode.JOIN);
	}
	
	private void addCriteriaAuthorAndStatus(Criteria criteria, Status status) {
		criteria.setFetchMode("authors", FetchMode.JOIN);
		criteria.add(Restrictions.eq("status", status));
	}

	@Override
	public List<Ebook> listInactiveEbook() {
		Class<Ebook> ebook = getPersistentClass();
		Criteria criteria = getCurrentSession().createCriteria(ebook);
		addCriteriaAuthorAndStatus(criteria,Status.Inactive);
		addFetchMode(criteria);
		final List<Ebook> listEbookDevelopment = criteria.list();
		return listEbookDevelopment;
	}
}
