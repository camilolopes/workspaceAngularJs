package com.camilolopes.core.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.core.domain.ebook.TypeEbook;
import com.camilolopes.core.interfaces.dao.TypeEbookDAO;
import com.camilolopes.core.interfaces.service.TypeEbookService;
@Service
public class TypeEbookServiceImpl extends GenericServiceImpl<TypeEbook, TypeEbookDAO> implements	TypeEbookService {
	@Autowired
	@Qualifier("typeEbookDAOImpl")
	@Override
	public void setDao(TypeEbookDAO dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

}
