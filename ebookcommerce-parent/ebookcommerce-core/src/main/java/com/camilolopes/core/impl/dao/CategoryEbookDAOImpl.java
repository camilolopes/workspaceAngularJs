package com.camilolopes.core.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.springframework.stereotype.Repository;

import com.camilolopes.core.domain.ebook.CategoryEbook;
import com.camilolopes.core.interfaces.dao.CategoryEbookDAO;

@Repository
@SuppressWarnings("unchecked")
public class CategoryEbookDAOImpl extends GenericHibernateDAO<CategoryEbook> implements
		CategoryEbookDAO {

	public CategoryEbookDAOImpl() {
		super(CategoryEbook.class);
	}

	@Override
	public List<CategoryEbook> list() {
		Criteria criteria = getCurrentSession().createCriteria(CategoryEbook.class);
		criteria.setFetchMode("ebooks", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

}
