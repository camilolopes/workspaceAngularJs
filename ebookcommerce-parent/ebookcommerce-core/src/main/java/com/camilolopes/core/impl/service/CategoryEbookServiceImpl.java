package com.camilolopes.core.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.core.domain.ebook.CategoryEbook;
import com.camilolopes.core.interfaces.dao.CategoryEbookDAO;
import com.camilolopes.core.interfaces.service.CategoryEbookService;
@Service
public class CategoryEbookServiceImpl extends GenericServiceImpl<CategoryEbook, CategoryEbookDAO> implements CategoryEbookService {
	@Autowired
	@Qualifier("categoryEbookDAOImpl")
	@Override
	public void setDao(CategoryEbookDAO dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
