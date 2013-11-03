package com.camilolopes.core.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;

import com.camilolopes.core.domain.ebook.TypeEbook;
import com.camilolopes.core.interfaces.dao.TypeEbookDAO;

@Repository
@SuppressWarnings("unchecked")
public class TypeEbookDAOImpl extends GenericHibernateDAO<TypeEbook> implements TypeEbookDAO {

	public TypeEbookDAOImpl() {
		super(TypeEbook.class);
	}

	@Override
	public List<TypeEbook> list() {
		Class<TypeEbook> typeEbook = getPersistentClass();
		Criteria criteria = getCurrentSession().createCriteria(typeEbook);
		criteria.setFetchMode("ebooks", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
}
