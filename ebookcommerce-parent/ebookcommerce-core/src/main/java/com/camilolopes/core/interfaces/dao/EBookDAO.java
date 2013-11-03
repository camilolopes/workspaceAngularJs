package com.camilolopes.core.interfaces.dao;

import java.util.List;

import com.camilolopes.core.domain.ebook.Ebook;

public interface EBookDAO  extends GenericDAO<Ebook>{

	Ebook getEbookByTitle(String title);

	List<Ebook> listInactiveEbook();

}
